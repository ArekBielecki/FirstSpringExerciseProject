package pl.sda.model.discount;

import org.springframework.stereotype.Service;

@Service
public class NoDiscount implements Discount {
    @Override
    public int calculate(int price) {
        return 0;
    }
}
