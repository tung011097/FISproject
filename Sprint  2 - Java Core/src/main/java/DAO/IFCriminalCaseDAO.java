package DAO;

import core.CriminalCase;

import java.util.List;

public interface IFCriminalCaseDAO {
    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase findCriminalCaseById(long id);

    void deleteCriminalCaseById(long id);

    CriminalCase updateCriminalCase(CriminalCase criminalCase);

    List<CriminalCase> findAllCriminalCase();
}
