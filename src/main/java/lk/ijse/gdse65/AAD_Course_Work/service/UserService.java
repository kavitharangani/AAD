package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.UserDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.LoginDTO;
import lk.ijse.gdse65.AAD_Course_Work.response.LoginResponse;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
