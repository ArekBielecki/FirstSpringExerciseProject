package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;
    private int price;

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
}
