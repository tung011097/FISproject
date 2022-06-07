package DAO;

import core.CriminalCase;

import java.util.List;

public interface IFCriminalCaseDAO {
    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase findCriminalCaseByName(String number);

    void removeCriminalCaseByName(String number);

    CriminalCase updeteCriminalCase(CriminalCase criminalCase);

    List<CriminalCase> findAllCriminalCase();
}
