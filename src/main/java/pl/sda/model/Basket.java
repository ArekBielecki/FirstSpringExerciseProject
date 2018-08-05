package pl.sda.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Basket {
    private List<ProductItem> productItemList;

    public Basket() {
        productItemList = new ArrayList();
    }
}
