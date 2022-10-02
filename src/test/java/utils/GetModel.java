package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import model.User;

import java.io.File;
import java.io.IOException;

public class GetModel {
    ObjectMapper objectMapper = new ObjectMapper();

    public User GetUser() throws IOException {
        User user = objectMapper.readValue(new
                        File("src/test/java/resource/Users.json"),
                User.class);
        return user;
    }

    public Product[] GetProducts() throws IOException {
        Product[] products = objectMapper.readValue(new
                        File("src/test/java/resource/Products.json"),
                Product[].class);
        return products;
    }
}
