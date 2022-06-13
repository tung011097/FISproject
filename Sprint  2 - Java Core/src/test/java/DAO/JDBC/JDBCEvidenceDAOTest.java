package DAO.JDBC;

import DAO.IFEvidenceDAO;
import core.Evidence;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCEvidenceDAOTest {

    @Test
    void addEvidence() {
        IFEvidenceDAO evidenceDAO = new JDBCEvidenceDAO();
        Evidence evidence = new Evidence(5L,5, LocalDateTime.now(),LocalDateTime.now(),null,"123","CC","a",true,null);
        evidenceDAO.addEvidence(evidence);
        List<Evidence> list = evidenceDAO.findAllEvidence();
        assertEquals(2,list.size());
    }

    @Test
    void findByIdEvidence() {
        IFEvidenceDAO evidenceDAO = new JDBCEvidenceDAO();
       Evidence evidence = evidenceDAO.findByIdEvidence(5l);
       assertEquals(5,evidence.getId());
    }

    @Test
    void deleteByIdEvidence() {
        IFEvidenceDAO evidenceDAO = new JDBCEvidenceDAO();
        evidenceDAO.deleteByIdEvidence(5l);
        assertEquals(1,evidenceDAO.findAllEvidence().size());
    }

    @Test
    void updateEvidence() {
        IFEvidenceDAO evidenceDAO = new JDBCEvidenceDAO();
        Evidence evidence = new Evidence(5L,8, LocalDateTime.now(),LocalDateTime.now(),null,"123","bb","a",true,null);
        evidenceDAO.updateEvidence(evidence);
        assertEquals("bb",evidenceDAO.findByIdEvidence(5l).getIteamName());
    }

    @Test
    void findAllEvidence() {
        IFEvidenceDAO evidenceDAO = new JDBCEvidenceDAO();
        List<Evidence> list = evidenceDAO.findAllEvidence();
        //lit.stream().forEach(System.out::println);
        assertNotNull(list);
        assertEquals(1,list.size());
    }
}