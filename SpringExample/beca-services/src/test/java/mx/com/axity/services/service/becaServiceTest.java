package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.BaseTest;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

public class becaServiceTest extends BaseTest {

    java.io.PrintStream o = System.out;
    static final Logger LOG = LogManager.getLogger(becaServiceTest.class);
    @Autowired
    public IbecaService becaService;
    @Autowired
    public IbecaFacade becaFacade;

    @Test
    public void getUserByIDExistRegister(){
        //Exito -> Registro exista y se actualice
        UserDO userDO = this.becaService.getUserByID(7l);
        Assert.assertNotNull(userDO);
        Assert.assertEquals(new Long(7), userDO.getId());
        Assert.assertEquals("Francisco 7", userDO.getName());
    }

    @Test
    public void getUserByIDNotExistRegister(){
        //Exito -> Registro exista y no se actualice
        try {
            UserTO testTO = new UserTO();
            testTO.setId(2453);
            testTO.setAge(343);
            testTO.setLastName("fgetge");
            testTO.setName("grrrb");
            this.becaFacade.updateUser(testTO);
            Assert.assertTrue(false);
        } catch (Throwable e){
            Assert.assertEquals(e.getClass(), NoSuchElementException.class);
        }
        //Assert.assertEquals("Francisco 7", userDO.getName());
    }






    @Test
    public void shouldReturnTheSumOfTwoNumbers(){
        int num1 = 5;
        int num2 = 10;
        int result = this.becaService.sum(num1, num2);
        Assert.assertEquals(15, result);
    }
    @Test
    public void shouldReturnTheSubstractionOfTwoNumbers(){
        int num1 = 10;
        int num2 = 5;
        int result = this.becaService.subtraction(num1, num2);
        Assert.assertEquals(5, result);
    }
    @Test
    public void shouldReturnTheMultiplicationOfTwoNumbers(){
        int num1 = 5;
        int num2 = 10;
        int result = this.becaService.multiplication(num1, num2);
        Assert.assertEquals(50, result);
    }
    @Test
    public void shouldReturnTheDivisionOfTwoNumbers(){
        int num1 = 10;
        int num2 = 5;
        int result = this.becaService.division(num1, num2);
        Assert.assertEquals(2, result);
    }

}
