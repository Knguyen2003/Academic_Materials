package daoImpl;

import dao.PositionDao;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;


import java.util.*;

public class PositionImpl implements PositionDao {
    private EntityManager em;

    public PositionImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }

    @Override
    public List<Position> listPositions(String name, double salaryFrom, double salaryTo) {
        try {
            return em.createNamedQuery("Position.listPositions1", Position.class)
                    .setParameter("name","%" +  name + "%")
                    .setParameter("tu", salaryFrom)
                    .setParameter("den", salaryTo)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID) {
        Map<Position, Integer> result = new TreeMap<>(
                Comparator.comparing(Position::getName)
        );
        List<?> list = em.createNamedQuery("Position.listYearsOfExperienceByPosition1")
                .setParameter("ma", candidateID)
                .getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(o -> {
                    Position position = em.find(Position.class, o[0]);
                    result.put(position, Integer.parseInt(o[1].toString()));
                });
        return result;
    }
}
