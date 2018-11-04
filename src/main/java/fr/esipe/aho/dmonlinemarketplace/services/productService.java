package fr.esipe.aho.dmonlinemarketplace.services;

import fr.esipe.aho.dmonlinemarketplace.models.productDTO;
import fr.esipe.aho.dmonlinemarketplace.utils.repository.productRepositoryMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jichun Anna HO
 */
@Service
public class productService implements IproductService {
    @Autowired
    private productRepositoryMock productRepository;

    /**
     * Method to create a new product
     * @param product productDTO
     * @return productDTO created
     */
    @Override
    public productDTO add(productDTO product) {
        return productRepository.save(product);
    }

    /**
     * Method to remove a product
     * @param id productDTO id
     */
    @Override
    public void remove(String id) {
        productRepository.delete(get(id));
    }

    /**
     * Method to delete product by id
     * @param id
     * @param name
     * @param price
     * @param description
     * @return
     */
    @Override
    public productDTO update(String id, String name, Integer price, String description) {
        productDTO product = get(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        return product;
    }

    /**
     * Method to get a product by id
     * @param id productDTO id
     * @return productDTO found
     */
    @Override
    public productDTO get(String id) {
        return productRepository.findById(id);
    }

    /**
     * Method to list all product
     * @return List of all product
     */
    @Override
    public List<productDTO> getAll() {
        return (List<productDTO>) productRepository.findAll();
    }
}
