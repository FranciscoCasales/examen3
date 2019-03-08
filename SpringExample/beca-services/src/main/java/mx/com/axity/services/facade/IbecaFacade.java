package mx.com.axity.services.facade;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;
import java.util.Optional;

public interface IbecaFacade {

    int operation(int num1, int num2);

    List<UserTO> getAllUsers();

    void createUser(UserTO userTO);

    UserTO getUserByID(Long id);

    void deleteUserByID(Long id);

    void updateUser(UserTO userTO);

}
