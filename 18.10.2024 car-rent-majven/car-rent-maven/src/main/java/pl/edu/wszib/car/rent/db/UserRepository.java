package pl.edu.wszib.car.rent.db;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users = new ArrayList<>();
    private static UserRepository instance = new UserRepository();
    private UserRepository() {
        this.users.add(new User("admin",
                DigestUtils.md5Hex("adminesdSarzBG4n5gjcuWEy26TM8RvhfNAUY")));
        this.users.add(new User("janusz",
                DigestUtils.md5Hex("janusz123esdSarzBG4n5gjcuWEy26TM8RvhfNAUY")));
    }
    public static UserRepository getInstance() {return instance;}

    public User getUser(String login){
        for(User user : this.users){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers(){
        return users;
    }
}
