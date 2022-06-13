package DAO.memory;

import DAO.IFDetectiveDAO;
import core.Detective;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectiveDAO implements IFDetectiveDAO {
    public Map<Long, Detective> detectiveMap = new HashMap<>();

    @Override
    public Detective addDetective(Detective detective) {
        return detectiveMap.put(detective.getId(), detective);
    }

    @Override
    public Detective findById(Long id) {
        return detectiveMap.get(id);
    }

    @Override
    public void deleteById(Long id) {
            detectiveMap.remove(id);
    }

    @Override
    public Detective updateDetective(Detective detective) {
        detectiveMap.put(detective.getId(), detective);
        return detective;
    }

    @Override
    public List<Detective> findAllDetective() {
        return detectiveMap.values().stream().toList();
    }

    @Override
    public String toString() {
        return "DetectiveDAO{" +
                "detectiveMap=" + detectiveMap +
                '}';
    }
}
