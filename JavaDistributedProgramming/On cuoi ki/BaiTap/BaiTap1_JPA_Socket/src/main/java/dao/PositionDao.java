package dao;

import entity.Position;

import java.util.List;
import java.util.Map;

public interface PositionDao {
    public List<Position> listPositions(String name,double salaryFrom,double salaryTo);
    public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID);
}
