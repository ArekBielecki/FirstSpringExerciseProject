package pl.sda.model.discount;

import pl.sda.service.BasketService;

public interface Discount {
    public int calculate(int price);
}
