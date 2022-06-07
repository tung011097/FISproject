package DAO;

import core.Evidence;

import java.util.ArrayList;
import java.util.List;

public interface IFEvidenceDAO {
    Evidence addEvidence(Evidence evidence);
    Evidence findByNumberEvidence(String number);
    void removeByNumberEvidence(String number);
    Evidence updateEvidence(Evidence evidence);
    List<Evidence> findAllEvidence();
}
