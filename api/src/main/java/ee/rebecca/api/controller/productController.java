package ee.rebecca.api.controller;

import ee.rebecca.api.entity.product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class productController {

    List<String> cars = new ArrayList<>(Arrays.asList("Tesla", "Nobe", "BMW"));
    List<product> products = new ArrayList<>(Arrays.asList(
            new product("Tesla", 85000),
            new product("Nobe", 25000),
            new product("BMW", 50000)
    ));
    @GetMapping("product")
    public product getProducts(){
        return new product();
    }

    // 1. kõikide toodete võtmine listist
    @GetMapping("get-products")
    public List<product> getProducts(){
        return products;
    }

    // 2. ühe toote kustutamine listist, võttes järjekorranumbri
    @GetMapping("delete-product/{index}")
    public List<product> deleteProduct(@PathVariable int index) {
        products.remove(index);
        return products;
    }
    // 3. ühe toote lisamine listi, võttes nime ja hinna
    @GetMapping("add-product")
    public List<product> addProduct(@RequestParam String name, @RequestParam double price) {
        products.add(new product(name, price));
        return products;
    }
}
