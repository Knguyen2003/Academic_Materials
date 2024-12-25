import dao.CandidateDao;
import dao.impl.CandidateImpl;
import entity.Candidate;
import entity.Certificate;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CandidateDaoTest {

    private CandidateDao candidateDao;

   public void setUp(){
       candidateDao = new CandidateImpl();
   }
   /*
   @Test
    public void testListCadidatesByCompanies(){
       setUp();
       Map<Candidate, Long> result = candidateDao.listCadidatesByCompanies();
       result.forEach((k,v) -> System.out.println(k + " - " + v));

       assertNotNull(result); // kiểm tra kết quả trả về khác null hay không ?. Nếu khác null thì test case sẽ pass

       // Tìm ứng viên có id là 'C101'
       Candidate c101 = null;
       for (Candidate candidate : result.keySet()) {
           if (candidate.getId().equals("C101")) {
               c101 = candidate;
               break;
           }
       }

       // Kiểm tra số lượng ứng viên có id là 'C101'
       assertNotNull(c101);
       assertEquals(5L, (long) result.get(c101));
       assertEquals(7, result.size());

    }
    */
    /*
    @Test
    public void testAddCandidate_False(){
        setUp();
        Candidate candidate = new Candidate("A101", "Mô tả", "nguyen@gmail.com", "Khôi Nguyên","Male","345-543-2345",1990);
        boolean result = candidateDao.addCandidate(candidate);
        assertEquals(false, result);
    }
    @Test
    public void testAddCandidate_True(){
        setUp();
        Candidate candidate = new Candidate("C112", "Mô tả", "nguyen@gmail.com", "Khôi Nguyên","Male","345-543-2345",1990);
        boolean result = candidateDao.addCandidate(candidate);
        assertEquals(true,candidate.getId().startsWith("C"));
        assertEquals(true, result);
    }
    */

    @Test
    public void testListCadidatesAndCertificates(){
        setUp();
        Map<Candidate,Set<Certificate>> result = candidateDao.listCadidatesAndCertificates();
        result.forEach((k,v) -> {
            System.out.println(k + " - ");
            v.forEach(cert -> System.out.println("    " + cert));
        });
        assertNotNull(result);
//        assertEquals(7, result.size());
    }

    @AfterEach
    public void tearDown(){
        candidateDao = null;
    }
}
