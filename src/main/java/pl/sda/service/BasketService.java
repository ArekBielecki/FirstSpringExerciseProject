package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Basket;
import pl.sda.model.Product;
import pl.sda.model.ProductItem;

import java.util.List;

@Service
public class BasketService {

    private Basket basket;
    private DiscountFactory discountFactory;

    @Autowired
    public BasketService(Basket basket) {
        this.basket = basket;
    }

    public void addProductItemToBasket(Product product){
        if(basket.getProductItemList()
                .stream()
                .anyMatch(x -> x.getProduct().getName().equals(product.getName()))){
            ProductItem productItem = basket.getProductItemList()
                    .stream()
                    .filter(x -> x.getProduct().getName().equals(product.getName())).findFirst().get();
            productItem.increase();
        } else{
            basket.getProductItemList().add(new ProductItem(product, 1));
        }

    }

    public List<ProductItem> getListOfProductsInBasket(){
        return basket.getProductItemList();
    }

    public int calculateBasketPrice(){
        int amount = 0;
        for (ProductItem productItem : basket.getProductItemList()) {
            amount = amount + productItem.getProduct().getPrice()*productItem.getQuantity();
        }
        return amount;
    }
}
