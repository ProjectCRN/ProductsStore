package com.netcracker.crm.services.impl;

import com.netcracker.crm.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;

/**
 * Created by on 12.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-SpringModule.xml"})
public class UserServiceImplTest {

    @Autowired
    MockHttpSession session;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Test
    public void testAdminExists() {
        int id = userService.getIdByLogin("Admin");
        assertTrue(-2 == id);

    }
}