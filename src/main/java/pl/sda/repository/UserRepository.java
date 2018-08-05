package pl.sda.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class UserRepository {

    @Getter
    private static List<User> userList;

    static{
        userList = new ArrayList<User>();
        userList.add(new User("Adam",18, "Katowice"));
        userList.add(new User("Piotr",25, "Kraków"));
        userList.add(new User("Tomasz",40, "Radom"));
    }
}
