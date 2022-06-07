package DAO;

import core.Detective;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetectiveDAO implements IFDetectiveDAO{
    List<Detective> detectiveList = new ArrayList<>();

    @Override
    public Detective addDetective(Detective detective) {
        detectiveList.add(detective);
        return detective;
    }

    @Override
    public Detective findById(Long id) {
        for (Detective d: detectiveList) {
            if (d.getId() == id){
                return d;
            }
        }
        throw new IndexOutOfBoundsException("Detective Not Found Exception");
    }

    @Override
    public void removeById(Long id) {
        for (Detective removeDetective: detectiveList) {
            if (removeDetective.getId() == id){
                detectiveList.remove(removeDetective);
            }
        }

    }

    @Override
    public Detective updateDetective(Detective detective) {
        for (Detective removeDetective: detectiveList) {
            if (removeDetective.getId() == detective.getId()){
                detectiveList.remove(removeDetective);
                addDetective(detective);
            }else {
                addDetective(detective);
            }

        }
        return detective;
    }

    @Override
    public List<Detective> findAllDetective() {
        List<Detective> listAll = new ArrayList<>(detectiveList.stream().toList());
        return listAll;
    }
}
