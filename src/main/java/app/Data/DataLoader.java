package app.Data;

import app.Ingredient.Ingredient;
import app.Ingredient.IngredientRepository;
import app.Product.Product;
import app.Product.ProductRepository;
import app.ProductIngredient.ProductIngredient;
import app.ProductIngredient.ProductIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final IngredientRepository ingredientRepository;
    private final ProductRepository productRepository;
    private final ProductIngredientRepository productIngredientRepository;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    private static final String GITHUB_RAW_URL = "https://raw.githubusercontent.com/Zhivkk/RestaurantWebProjectResources/main/jsons/";

    public DataLoader(IngredientRepository ingredientRepository, ProductRepository productRepository,
                      ProductIngredientRepository productIngredientRepository, ObjectMapper objectMapper) {
        this.ingredientRepository = ingredientRepository;
        this.productRepository = productRepository;
        this.productIngredientRepository = productIngredientRepository;
        this.objectMapper = objectMapper;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        loadIngredients();
        loadProducts();
        //loadProductIngredients();
    }

    private void loadIngredients() throws Exception {
        String url = GITHUB_RAW_URL + "ingredients.json";
        String json = restTemplate.getForObject(url, String.class);
        List<Ingredient> ingredients = objectMapper.readValue(json, new TypeReference<>() {});
        ingredientRepository.saveAll(ingredients);
    }

    private void loadProducts() throws Exception {
        String url = GITHUB_RAW_URL + "products.json";
        String json = restTemplate.getForObject(url, String.class);
        List<Product> products = objectMapper.readValue(json, new TypeReference<>() {});
        productRepository.saveAll(products);
    }

    private void loadProductIngredients() throws Exception {
        String url = GITHUB_RAW_URL + "product_ingredients.json";
        String json = restTemplate.getForObject(url, String.class);
        List<ProductIngredient> productIngredients = objectMapper.readValue(json, new TypeReference<>() {});

        for (ProductIngredient pi : productIngredients) {
            pi.setProduct(productRepository.findById(pi.getProduct().getId()).orElseThrow());
            pi.setIngredient(ingredientRepository.findById(pi.getIngredient().getId()).orElseThrow());
        }

        productIngredientRepository.saveAll(productIngredients);
    }
}
