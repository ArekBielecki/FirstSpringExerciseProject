package pl.sda.model.discount;

import org.springframework.stereotype.Service;

@Service
public class SecondDiscount implements Discount {
    @Override
    public int calculate(int price) {
        return (int)(0.6*price);
    }
}
