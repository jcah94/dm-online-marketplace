package fr.esipe.aho.dmonlinemarketplace.utils.controller;

import fr.esipe.aho.dmonlinemarketplace.models.productDTO;
import fr.esipe.aho.dmonlinemarketplace.services.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Jichun Anna HO
 */
@RestController
public class productController {
    @Autowired
    private IproductService productService;

    /**
     * Method to get a productDTO by id
     * @param id productDTO id
     * @return productDTO object
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/{id}")
    public productDTO getProduct(@PathVariable("id") String id) {
        return productService.get(id);
    }

    /**
     * Method to create a new product by id
     * @param id Product ID
     * @param name Product Name
     * @param price Product Price
     * @param description Product Description
     * @return productDTO
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/new/{id}")
    public productDTO newProduct(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("price") Integer price, @RequestParam("description") String description) {
        return productService.add(productDTO.builder().id(id).name(name).description(description).price(price).build());
    }

    /**
     * Method to delete a product
     * @param id Product ID
     * @return Delete String
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.remove(id);
        return "Product Deleted";
    }

    /**
     * Method to get all productDTO
     * @return List of all productDTO
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product")
    public List<productDTO> getAllProduct(){
        return productService.getAll();
    }

    /**
     * Method to update a product by id
     * @param id Product ID
     * @param name Product Name
     * @param price Product Price
     * @param description Product Description
     * @return productDTO
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/update/{id}")
    public productDTO updateProduct(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("price") Integer price, @RequestParam("description") String description) {
        return productService.update(id, name, price, description);
    }
}
