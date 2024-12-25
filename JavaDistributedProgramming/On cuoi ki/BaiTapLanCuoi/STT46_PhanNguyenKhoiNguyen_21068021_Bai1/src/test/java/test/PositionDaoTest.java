package test;

import dao.PositionDao;
import daoImpl.PositionImpl;
import entity.Position;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PositionDaoTest {
    private PositionDao positionDao;

    public void setUp() {
        positionDao = new PositionImpl();
    }

//    @Test
//    public void testListPositions() {
//        setUp();
//        List<Position> ds = positionDao.listPositions("N",10000,15000);
//        for (Position p: ds) {
//            System.out.println(p);
//        }
//        assertNotNull(ds);
//        assertEquals(5,ds.size());
//
//    }
    @Test
    public void testListYearsOfExperienceByPosition(){
        setUp();
        Map<Position, Integer> result = positionDao.listYearsOfExperienceByPosition("C101");
        result.forEach((k,v) -> System.out.println(k + " " + v));
        assertNotNull(result);
        assertEquals(4,result.size());
    }


    @AfterEach
    public void tearDown() {
        positionDao = null;
    }
}
