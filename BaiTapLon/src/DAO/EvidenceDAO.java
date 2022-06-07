package DAO;

import core.Evidence;

import java.util.ArrayList;
import java.util.List;

public class EvidenceDAO implements IFEvidenceDAO {
    List<Evidence> evidenceList = new ArrayList<>();

    @Override
    public Evidence addEvidence(Evidence evidence) {
        evidenceList.add(evidence);
        return evidence;
    }

    @Override
    public Evidence findByNumberEvidence(String number) {
        for (Evidence e : evidenceList) {
            if (e.getNumber().equals(number)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void removeByNumberEvidence(String number) {
        for (Evidence e : evidenceList) {
            if (e.getNumber().equals(number)) {
                evidenceList.remove(e);
            }
        }
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        removeByNumberEvidence(evidence.getNumber());
        addEvidence(evidence);
        return evidence;
    }

    @Override
    public List<Evidence> findAllEvidence() {
        List<Evidence> listAll = new ArrayList<>(evidenceList.stream().toList());
        return listAll;
    }
}
