package DAO;

import core.Evidence;

import java.util.ArrayList;
import java.util.List;

public interface IFEvidenceDAO {
    /**
     * @param evidence : Doi tuong Evidence add vao database
     * @return lai doi tuong da add thanh cong
     */
    Evidence addEvidence(Evidence evidence);
    /**
     * @param id ID muon tim kiem
     * @return Evidence trong he thong trung voi id can tim
     */
    Evidence findByIdEvidence(Long id);
    /**
     * @param id ID muon xoa
     */
    void deleteByIdEvidence(Long id);
    /**
     * @param evidence Doi tuong Evidence muon update
     * @return Doi tuong Evidence da update
     */
    Evidence updateEvidence(Evidence evidence);
    /**
     * @return Tat ca Evidence co trong he thong
     */
    List<Evidence> findAllEvidence();
}
