package DAO;

import core.CriminalCase;
import core.Detective;

import java.util.ArrayList;
import java.util.List;

public class CriminalCaseDAO implements IFCriminalCaseDAO{
    List<CriminalCase> criminalCaseList = new ArrayList<>();

    @Override
    public CriminalCase addCriminalCase(CriminalCase criminalCase) {
        criminalCaseList.add(criminalCase);
        return criminalCase;
    }

    @Override
    public CriminalCase findCriminalCaseByName(String number) {
        for (CriminalCase criminalcase: criminalCaseList) {
            if(criminalcase.getNumber().equals(number)){
                return criminalcase;
            }
        }
        return null;
    }

    @Override
    public void removeCriminalCaseByName(String number) {
        for (CriminalCase crimunalcase: criminalCaseList) {
            if(crimunalcase.getNumber().equals(number)){
                criminalCaseList.remove(crimunalcase);
            }
        }

    }

    @Override
    public CriminalCase updeteCriminalCase(CriminalCase criminalCase) {
        removeCriminalCaseByName(criminalCase.getNumber());
        criminalCaseList.add(criminalCase);
        return criminalCase;
    }

    @Override
    public List<CriminalCase> findAllCriminalCase() {
        List<CriminalCase> listAll = new ArrayList<>(criminalCaseList.stream().toList());
        return listAll;
    }
}
