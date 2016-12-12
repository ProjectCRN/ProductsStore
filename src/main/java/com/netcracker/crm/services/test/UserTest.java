package com.netcracker.crm.services.test;

import com.netcracker.crm.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ксения on 12.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserTest {
    private IUserService userService;

    @Required
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Test
    public void adminExists()
    {
        int id = userService.getIdByLogin("Admin");
        assertTrue(-2==id);
    }

}
