package DAO.memory;

import DAO.IFEvidenceDAO;
import core.Evidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvidenceDAO implements IFEvidenceDAO {
    public Map<Long,Evidence> evidenceMap = new HashMap<>();

    @Override
    public Evidence addEvidence(Evidence evidence) {
        evidenceMap.put(evidence.getId(), evidence);
        return evidence;
    }

    @Override
    public Evidence findByIdEvidence(Long id) {
        return evidenceMap.get(id);
    }

    @Override
    public void deleteByIdEvidence(Long id) {
        evidenceMap.remove(id);
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        return evidenceMap.put(evidence.getId(), evidence);
    }

    @Override
    public List<Evidence> findAllEvidence() {
        return evidenceMap.values().stream().toList();
    }
}
