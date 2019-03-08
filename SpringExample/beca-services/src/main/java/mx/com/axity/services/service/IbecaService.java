package mx.com.axity.services.service;

import mx.com.axity.model.UserDO;

import java.util.List;
import java.util.Optional;

public interface IbecaService {

    int sum(int sum1, int sum2);
    int subtraction(int subs1, int subs2);
    int multiplication(int mult1, int mult2);
    int division(int div1, int div2);
    List<UserDO> getAllUsers();
    void createUser(UserDO userDO);
    UserDO getUserByID(Long id);
    void deleteUserByID(Long id);
    void updateUser(UserDO userDO);
}
