package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private String city;

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", City: " + city;
    }
}
