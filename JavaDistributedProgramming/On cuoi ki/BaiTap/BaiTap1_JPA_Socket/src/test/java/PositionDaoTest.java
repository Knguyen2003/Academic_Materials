import dao.PositionDao;
import dao.impl.PositionImpl;
import entity.Position;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PositionDaoTest {

    private PositionDao positionDao;

    public void setUp() {
        positionDao = new PositionImpl();
    }
   /*
    @Test
    public void testListPositions() {
        setUp();
       List<Position> DsPos =  positionDao.listPositions("S", 10000, 20000);
        DsPos.forEach(position -> {
            System.out.println(position);
        });
        assertNotNull(DsPos);//Kiểm tra xem danh sách vị trí công việc có rỗng không .Nếu rỗng thì fail
        assertTrue(DsPos.size() == 7);//Kiểm tra xem danh sách vị trí công việc có 7 phần tử không .Nếu không bằng 7 thì fail


        for (int i = 0; i < DsPos.size() - 1; i++) {
            String currentName = DsPos.get(i).getName();
            String nextName = DsPos.get(i + 1).getName();
            assertTrue(currentName.compareTo(nextName) >= 0);
        }
    }
*/


    @Test
    public void testListYearsOfExperienceByPosition() {
        setUp();
        Map<Position, Integer> result = positionDao.listYearsOfExperienceByPosition("C101");
        result.forEach((position, years) -> {

            System.out.println(position + " - " + years);
        });
        assertNotNull(result);
        assertTrue(result.size() == 4);

    }
    @AfterEach
    public void tearDown() {
        positionDao = null;
    }
}
