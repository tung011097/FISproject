package DAO.JDBC;

import DAO.IFCriminalCaseDAO;
import core.CriminalCase;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseDAOTest {

    @Test
    void addCriminalCase() {
        IFCriminalCaseDAO db = new JDBCCriminalCaseDAO();
        CriminalCase criminalCase = new CriminalCase(5l,2, LocalDateTime.now(),LocalDateTime.now()
                ,"rr","qq","aa","yy",null,null,null);
        db.addCriminalCase(criminalCase);
        List<CriminalCase> list = db.findAllCriminalCase();
        assertNotNull(list);
        assertEquals(3,list.size());
    }

    @Test
    void findCriminalCaseById() {
        IFCriminalCaseDAO db = new JDBCCriminalCaseDAO();
        CriminalCase criminalCase = db.findCriminalCaseById(5l);
        assertEquals(5,criminalCase.getId());
    }

    @Test
    void deleteCriminalCaseById() {
        IFCriminalCaseDAO db = new JDBCCriminalCaseDAO();
        db.deleteCriminalCaseById(5l);
        assertEquals(2,db.findAllCriminalCase().size());
    }

    @Test
    void updateCriminalCase() {
        IFCriminalCaseDAO db = new JDBCCriminalCaseDAO();
        CriminalCase criminalCase = new CriminalCase(5l,10, LocalDateTime.now(),LocalDateTime.now()
                ,"cc","cc","cc","yy",null,null,null);
        db.updateCriminalCase(criminalCase);
        assertEquals(10,db.findCriminalCaseById(5l).getVersion());
    }

    @Test
    void findAllCriminalCase() {
        IFCriminalCaseDAO db = new JDBCCriminalCaseDAO();
        List<CriminalCase> list = db.findAllCriminalCase();
        //list.stream().forEach(System.out::println);
        assertNotNull(list);
    }
}