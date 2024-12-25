package dao.impl;

import dao.CandidateDao;
import entity.Candidate;
import entity.Certificate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CandidateImpl implements CandidateDao {
    private EntityManager em;

    public CandidateImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }

    /**
     * Liệt kê danh sách các ứng viên và số công ty mà các ứng viên này từng làm.
     * @return
     */
    @Override
    public Map<Candidate, Long> listCadidatesByCompanies() {
        //Do đề trả ra Map nên tạo Map để chứa kết quả trả về
        Map<Candidate, Long> result = new HashMap<>();

        List<?> ds = em.createNamedQuery("Candidate.listCadidatesByCompanies").getResultList();
        ds.stream()
                .map(o -> (Object[]) o)
                .forEach(a ->{
                    String id = (String) a[0];
                    Candidate can = em.find(Candidate.class, id);
                    long soLuong = (long) a[1];

                    result.put(can, soLuong);

                });
        return result;
    }

    @Override
    public Map<Candidate, Position> listCandidatesWithLongestWorking() {
        return Map.of();
    }

    @Override
    public boolean addCandidate(Candidate candidate) {
        EntityTransaction tx = em.getTransaction();
        try {
            //Trong đó mã số ứng viên phải bắt đầu là C, theo sau ít nhất là 3 ký số.

            // Cách 1: Sử dụng hàm matches của String
//            if (!candidate.getId().matches("^C\\d{3,}$")) {
//                return false;
//            }
            // Cách 2: Sử dụng hàm startsWith của String
            if (!candidate.getId().startsWith("C") || candidate.getId().length() < 4 || candidate == null) {
                return false;
            }
            tx.begin();
            em.persist(candidate);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Candidate, Set<Certificate>> listCadidatesAndCertificates() {
        Map<Candidate, Set<Certificate>> result = new HashMap<>();
        List<?> ds = em.createNamedQuery("Candidate.listCadidatesAndCertificates").getResultList();
        ds.stream()
                .map(o -> (Object[]) o)
                .forEach(a -> {

                    String id = (String) a[0];
                    Candidate can = em.find(Candidate.class, id);
                    Certificate cer = new Certificate();
                    if(a[1] == null){
                        cer = null;
                    }else{
                        cer = em.find(Certificate.class, a[1]);
                    }
                    can.getCertificates().add(cer);
                    result.put(can, can.getCertificates());
                });
        return result;
    }
}
