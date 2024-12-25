package dao.impl;

import dao.PositionDao;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionImpl implements PositionDao {

    private EntityManager em;

    public PositionImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }


    /*
    Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và mức lương khoảng từ,
    kết quả sắp xếp theo tên vị trí công việc.
     */
    @Override
    public List<Position> listPositions(String name, double salaryFrom, double salaryTo) {
        try {
            return em.createNamedQuery("Position.listPositions", Position.class)
                    .setParameter("ten", "%" + name + "%")
                    .setParameter("tu", salaryFrom)
                    .setParameter("den", salaryTo)
                    .getResultList();
        } catch (Exception e) {
            return null;
//            e.printStackTrace();
        }
    }

    @Override
    public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID) {
        Map<Position, Integer> result = new HashMap<>();

        List<?> list = em.createNamedQuery("Position.listYearsOfExperienceByPosition1")
                .setParameter("id", candidateID)
                .getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(o -> {
                    Position p = em.find(Position.class, o[0]);
                    result.put(p, (Integer) o[1]);
                });
        return result;
    }
}
