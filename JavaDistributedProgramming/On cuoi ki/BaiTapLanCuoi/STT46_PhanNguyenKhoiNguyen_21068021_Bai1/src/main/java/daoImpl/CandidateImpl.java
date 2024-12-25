package daoImpl;

import dao.CandidateDao;
import entity.Candidate;
import entity.Certificate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CandidateImpl implements CandidateDao {
    private EntityManager em;


    public CandidateImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }


    @Override
    public Map<Candidate, Long> listCadidatesByCompanies() {
        Map<Candidate, Long> result = new HashMap<>();
        List<?> list = em.createNamedQuery("Candidate.listCadidatesByCompanies1").getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(o -> {
                    Candidate candidate = em.find(Candidate.class, o[0]);
                    result.put(candidate, Long.parseLong(o[1].toString()));
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
            if(!candidate.getId().matches("^C\\d{3,}$")){
                return false;
            }
            tx.begin();
            em.persist(candidate);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Map<Candidate, Set<Certificate>> listCadidatesAndCertificates() {
        Map<Candidate, Set<Certificate>> result = new HashMap<>();
        List<?> list = em.createNamedQuery("Candidate.listCadidatesAndCertificates1").getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(o -> {
                    Candidate candidate = em.find(Candidate.class, o[0]);
                    Certificate certificate = new Certificate();
                    if(o[1] != null){
                        certificate = em.find(Certificate.class, o[1]);
                    }else{
                        certificate = null;
                    }
                    candidate.getCertificates().add(certificate);

                    result.put(candidate, candidate.getCertificates());
                });
        return result;
    }

    @Override
    public boolean deleteCandidate(String id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Candidate candidate = em.find(Candidate.class, id);
            //detach candidate
            em.detach(candidate);
            em.remove(candidate);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Candidate tim() {
        return em.createNamedQuery("Candidate.tim", Candidate.class)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
