package DAO.memory;

import DAO.IFCriminalCaseDAO;
import core.CriminalCase;
import core.Detective;
import core.Evidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriminalCaseDAO implements IFCriminalCaseDAO {
    public Map<Long, CriminalCase> criminalCaseMap = new HashMap<>();
    @Override
    public CriminalCase addCriminalCase(CriminalCase criminalCase) {
        criminalCaseMap.put(criminalCase.getId(),criminalCase);
        return criminalCase;
    }

    @Override
    public CriminalCase findCriminalCaseById(long id) {
        return criminalCaseMap.get(id);
    }

    @Override
    public void deleteCriminalCaseById(long id) {
        criminalCaseMap.remove(id);
    }

    @Override
    public CriminalCase updateCriminalCase(CriminalCase criminalCase) {
        return criminalCaseMap.put(criminalCase.getId(), criminalCase);
    }

    @Override
    public List<CriminalCase> findAllCriminalCase() {
        return criminalCaseMap.values().stream().toList();
    }
}