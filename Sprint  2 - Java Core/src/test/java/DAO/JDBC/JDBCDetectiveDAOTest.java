package DAO.JDBC;

import DAO.IFDetectiveDAO;
import DAO.memory.DetectiveDAO;
import core.Detective;
import core.Enum.EmploymentStatus;
import core.Enum.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCDetectiveDAOTest {

    @Test
    void findAllDetective() {
        IFDetectiveDAO db = new JDBCDetectiveDAO();
        List<Detective> list = db.findAllDetective();
        //list.forEach(System.out :: println);
        assertEquals(2,list.size());
        assertNotNull(list);
    }

    @Test
    void addDetective() {
        IFDetectiveDAO db = new JDBCDetectiveDAO();
        Detective detective = new Detective(2l,10,LocalDateTime.now(),LocalDateTime.now(),"AA",
                "BB","CC","A123",LocalDateTime.now(),"A123",true,null,null,null);
        db.addDetective(detective);
        List<Detective> list = db.findAllDetective();
        assertEquals(3,list.size());
    }

    @Test
    void findById() {
        IFDetectiveDAO db = new JDBCDetectiveDAO();
        Detective detective = db.findById(2l);
        assertEquals(2,detective.getId());
    }

    @Test
    void deleteById() {
        IFDetectiveDAO db = new JDBCDetectiveDAO();
        db.deleteById(2L);
        assertEquals(1,db.findAllDetective().size());
    }

    @Test
    void updateDetective() {
        IFDetectiveDAO db = new JDBCDetectiveDAO();
        Detective detective = new Detective( 2l,5,LocalDateTime.now(),LocalDateTime.now(),"AA",
                "BB","CC","A123",LocalDateTime.now(),"A123",true,null,null,null);
        db.updateDetective(detective);
        assertEquals(5,db.findById(2l).getVersion());
    }
}