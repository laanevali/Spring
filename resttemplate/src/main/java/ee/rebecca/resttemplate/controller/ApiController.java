package ee.rebecca.resttemplate.controller;

import ee.rebecca.resttemplate.model.Omniva;
import ee.rebecca.resttemplate.model.Post;
import ee.rebecca.resttemplate.model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ApiController {
    @GetMapping("omniva")
    public List<Omniva> getOmnivaParcelMachines() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response = restTemplate.exchange(url, HttpMethod.GET,null, Omniva[].class);

        List<Omniva> omniva = Arrays.stream(response.getBody())
                .filter(e -> e.getA0_NAME().equals("EE"))
                .toList();

        return omniva;
    }

    @GetMapping("posts/{userId}")
    public List<Post> getPosts(@PathVariable int userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.org/posts";
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET,null, Post[].class);

        List<Post> posts = Arrays.stream(response.getBody())
                .filter(e -> e.getUserId() == userId)
                .toList();

        return posts;
    }

    @GetMapping("products/{minRating}")
    public List<Product> getProducts(@PathVariable double minRating) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<Product[]> response = restTemplate.exchange(url, HttpMethod.GET,null, Product[].class);

        List<Product> products = Arrays.stream(response.getBody())
                .filter(e -> e.getRating().getRate() > minRating)
                .toList();

        return products;
    }
}
