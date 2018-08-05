package pl.sda;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BasketApp basketApp = context.getBean(BasketApp.class);
        basketApp.start();
    }
}
