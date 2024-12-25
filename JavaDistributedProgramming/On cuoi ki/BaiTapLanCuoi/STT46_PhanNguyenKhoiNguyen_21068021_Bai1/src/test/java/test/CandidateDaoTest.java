package test;

import dao.CandidateDao;
import daoImpl.CandidateImpl;
import entity.Candidate;
import entity.Certificate;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CandidateDaoTest {
    private CandidateDao candidateDao;

    public void setUp() {
        candidateDao = new CandidateImpl();
    }

//    @Test
//    public void testlistCadidatesByCompanies() {
//        setUp();
//        Map<Candidate,Long> map = candidateDao.listCadidatesByCompanies();
//        map.forEach((k,v) -> {
//            System.out.println(k + "Số công ty là :" + v);
//        });
//        assertNotNull(map);
//        assertEquals(11,map.size());
//
//
//    }

//    @Test
//    public void testAddCandidate() {
//        setUp();
//        //String description, String email, String fullName, String gender, String id, String phone, int yearOfBirth
//        Candidate candidate = new Candidate("moTa", "email", "PhanNguyenKhoiNguyen", "Male", "C112", "phone", 2003);
//        boolean result = candidateDao.addCandidate(candidate);
//
//        assertEquals(true,result);
//    }

//    @Test
//    public void testListCadidatesAndCertificates() {
//        setUp();
//         Map<Candidate, Set<Certificate>> map = candidateDao.listCadidatesAndCertificates();
//        map.forEach((k,v) -> {
//            System.out.println(k + "\n"+ "   " + v);
//        });
//    }

    @Test
    public void testTim() {
        setUp();
        Candidate result = candidateDao.tim();
        System.out.println(result);
    }


    @AfterEach
    public void tearDown() {
        candidateDao = null;
    }
}
