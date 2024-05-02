package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import lk.ijse.gdse65.AAD_Course_Work.dto.UserDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.LoginDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.User;
import lk.ijse.gdse65.AAD_Course_Work.repo.UserDAO;
import lk.ijse.gdse65.AAD_Course_Work.response.LoginResponse;
import lk.ijse.gdse65.AAD_Course_Work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUser_id(),
                userDTO.getUser_name(),
                userDTO.getEmail(),

                this.passwordEncoder.encode(userDTO.getPassword())
        );
       userDAO.save(user);

       return user.getUser_name();
    }


    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userDAO.findByEmail(loginDTO.getEmail());
        if (user1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userDAO.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()){
                    return new LoginResponse("Login Success", true);
                }else {
                    return new LoginResponse("Login Failed", false);
                }
            }else {
                return new LoginResponse("Password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exist", false);
        }
    }
}
