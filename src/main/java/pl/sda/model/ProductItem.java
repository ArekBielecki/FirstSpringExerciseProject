package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {

    private Product product;
    private int quantity;

    public void increase(){
        quantity++;
    }

    @Override
    public String toString() {
        return "Product: " + product.getName() + ", Qty: " + quantity;
    }
}
