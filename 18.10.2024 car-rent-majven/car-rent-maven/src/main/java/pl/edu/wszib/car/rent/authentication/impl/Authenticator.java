package pl.edu.wszib.car.rent.authentication.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.db.UserRepository;
import pl.edu.wszib.car.rent.model.User;

public class Authenticator implements IAuthenticator {
    private static Authenticator instance = new Authenticator();
    private UserRepository userRepository = UserRepository.getInstance();
    private String seed = "esdSarzBG4n5gjcuWEy26TM8RvhfNAUY";

    private Authenticator() {

    }

    public boolean authenticate(User user) {
        User userfromdb = this.userRepository.getUser(user.getLogin());
        return userfromdb != null && userfromdb.getPassword().equals(DigestUtils.md5Hex(user.getPassword()+seed));
    }

    public static Authenticator getInstance() {
        return instance;
    }
}
