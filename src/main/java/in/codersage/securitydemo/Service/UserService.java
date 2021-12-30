package in.codersage.securitydemo.Service;

import in.codersage.securitydemo.Entity.User;


public interface UserService {
    void save(User user);
    User findUserByName(String username);

    void processOAuthPostLogin(String email);
}
