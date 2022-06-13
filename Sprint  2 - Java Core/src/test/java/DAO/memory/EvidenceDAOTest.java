package DAO.memory;

import core.Evidence;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EvidenceDAOTest {

    @Test
    void addEvidence() {
        List<Evidence> evidenceList = new ArrayList<>();
        Evidence evidence1 = new Evidence(null,"a123","123","A",true,null);
        Evidence evidence2 = new Evidence(null,"b456","456","B",true,null);
        evidenceList.add(evidence1);
        evidenceList.add(evidence2);
            for (Evidence e : evidenceList) {
                if (e.getNumber().equals("a123")) {
                    evidenceList.remove(e);
                }
            }
        System.out.println(evidenceList);
    }

    @Test
    void findByNumberEvidence() {
    }

    @Test
    void removeByNumberEvidence() {
    }

    @Test
    void updateEvidence() {
    }

    @Test
    void findAllEvidence() {
    }
}