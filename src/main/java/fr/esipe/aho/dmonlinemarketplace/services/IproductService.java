package fr.esipe.aho.dmonlinemarketplace.services;

import fr.esipe.aho.dmonlinemarketplace.models.productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jichun Anna HO
 */
@Service
public interface IproductService {
    @Autowired
    productDTO add(productDTO product);
    void remove(String id);

    productDTO update(String id, String name, Integer price, String description);

    productDTO get(String id);
    List<productDTO> getAll();
}
