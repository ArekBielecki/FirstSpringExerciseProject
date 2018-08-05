package pl.sda.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.model.discount.Discount;
import pl.sda.model.User;

import java.util.Map;

@Service
@AllArgsConstructor
public class DiscountFactory {

    private Map<String, Discount> discountMap;

    public Discount calculateDiscountForUser(User user){
        if(user.getAge() == 18){
            return discountMap.get("thirdDiscount");
        }
        else if(user.getAge() < 40){
            return discountMap.get("firstDiscount");
        }
        else if(user.getAge() > 20 && user.getCity().equals("Radom")){
            return discountMap.get("secondDiscount");
        }
        else{
            return discountMap.get("noDiscount");
        }
    }

}
