package dao;

import entity.Facility;

import java.util.Map;

public interface FacilityDao {
    public boolean updateFacility(Facility facilityNewInfor);
    public Map<Facility,Long> countMaintenance();
}
