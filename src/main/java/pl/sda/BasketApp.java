package pl.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Product;
import pl.sda.model.User;
import pl.sda.model.discount.Discount;
import pl.sda.repository.ProductRepository;
import pl.sda.repository.UserRepository;
import pl.sda.service.BasketService;
import pl.sda.service.DiscountFactory;

import java.util.Scanner;

@Component
public class BasketApp {

    private boolean isAppRunning = true;
    private User user;
    private Scanner scanner;

    private BasketService basketService;
    private DiscountFactory discountFactory;


    @Autowired
    public BasketApp(BasketService basketService, DiscountFactory discountFactory) {
        this.basketService = basketService;
        this.discountFactory = discountFactory;
        scanner = new Scanner(System.in);
    }

    public void start() {
        user = chooseUser();
        while (isAppRunning) {
            System.out.println("Witamy w sklepie");
            System.out.println("1. Dodaj produkt");
            System.out.println("2. Zobacz koszyk");
            System.out.println("3. Zobacz cenę");
            System.out.println("4. Wyjdź");
            switch (scanner.nextInt()) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showBasket();
                    break;
                case 3:
                    showPrice();
                    break;
                case 4:
                    isAppRunning = false;
                    break;
                default:
                    System.out.println("Zły numer");
                    break;
            }
        }
    }

    private void showPrice() {
        int basketPrice = basketService.calculateBasketPrice();
        System.out.println("Przed obniżką: " + basketPrice);
        Discount discountType = discountFactory.calculateDiscountForUser(user);
        int discount = discountType.calculate(basketPrice);
        System.out.println("Wartość zniżki: " + discount);
        System.out.println("Do zapłaty: " + (basketPrice - discount));
    }

    private void showBasket() {
        basketService.getListOfProductsInBasket().forEach(System.out::println);
    }

    private void addProduct() {
        int id = 1;
        for (Product product : ProductRepository.getProductList()) {
            System.out.println(id++ + " : " + product);
        }
        switch (scanner.nextInt()) {
            case 1:
                basketService.addProductItemToBasket(ProductRepository.getProductList().get(0));
                break;
            case 2:
                basketService.addProductItemToBasket(ProductRepository.getProductList().get(1));
                break;
            case 3:
                basketService.addProductItemToBasket(ProductRepository.getProductList().get(2));
                break;
            case 4:
                basketService.addProductItemToBasket(ProductRepository.getProductList().get(3));
                break;
            case 5:
                basketService.addProductItemToBasket(ProductRepository.getProductList().get(4));
                break;
            default:
                System.out.println("Wrong number");
        }
    }

    private User chooseUser() {
        System.out.println("Wybierz użytkownika: ");
        int id = 1;
        for (User user : UserRepository.getUserList()) {
            System.out.println(id++ + " : " + user);
        }
        switch (scanner.nextInt()) {
            case 1:
                return UserRepository.getUserList().get(0);
            case 2:
                return UserRepository.getUserList().get(1);
            case 3:
                return UserRepository.getUserList().get(2);
            default:
                return UserRepository.getUserList().get(0);
        }
    }

}
