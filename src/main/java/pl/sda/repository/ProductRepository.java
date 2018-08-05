package pl.sda.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class ProductRepository {

    @Getter
    private static List<Product> productList;

    static{
        productList = new ArrayList();
        productList.add(new Product("Komputer", 1000));
        productList.add(new Product("Klawiatura", 100));
        productList.add(new Product("TV", 700));
        productList.add(new Product("Myszka", 50));
        productList.add(new Product("PS4", 2000));
    }

}
