package DAO.memory;

import DAO.IFDetectiveDAO;
import core.CriminalCase;
import core.Detective;
import core.Enum.EmploymentStatus;
import core.Enum.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveDAOTest {

    @Test
    void addDetective() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateDetective() {
    }

    @Test
    void findAllDetective() {
        IFDetectiveDAO detectiveDAO = new DetectiveDAO();
        detectiveDAO.addDetective(new Detective(1L, 1, LocalDateTime.now(), LocalDateTime.now(), "AA",
                "BB", "CC", "A111", LocalDateTime.now(), "1", true, null , null, null));
        List<Detective> detectiveList = detectiveDAO.findAllDetective();
        System.out.println(detectiveList);
    }
}