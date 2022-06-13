package DAO;

import core.Detective;

import java.util.List;

public interface IFDetectiveDAO {
    /**
     * @param detective : Doi tuong Evidence add vao database
     * @return lai doi tuong da add thanh cong
     */
    Detective addDetective(Detective detective);

    /**
     * @param id ID muon tim kiem
     * @return Detective trong he thong
     */
    Detective findById(Long id);

    /**
     * @param id ID muon xoa
     */
    void deleteById(Long id);

    /**
     * @param detective Doi tuong Detective muon update
     * @return Doi tuong Detective da update
     */
    Detective updateDetective(Detective detective);

    /**
     * @return Tat ca Detective co trong he thong
     */
    List<Detective> findAllDetective();

}
