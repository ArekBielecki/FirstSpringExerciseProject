package pl.sda.model.discount;

import org.springframework.stereotype.Service;

@Service
public class FirstDiscount implements Discount{
    @Override
    public int calculate(int price) {
        return (int)(0.2*price);
    }
}
