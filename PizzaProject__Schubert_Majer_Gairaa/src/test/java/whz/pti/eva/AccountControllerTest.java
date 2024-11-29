package whz.pti.eva;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.security.Principal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import whz.pti.eva.customerManagement.boundary.AccountController;
import whz.pti.eva.customerManagement.service.DeliveryAddressService;
import whz.pti.eva.security.domain.CurrentUser;
import whz.pti.eva.security.domain.User;
import whz.pti.eva.security.service.user.UserService;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private DeliveryAddressService deliveryAddressService;

    @MockBean
    private CurrentUser currentUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testViewAccount_LoggedInUser() throws Exception {
   
        String loginname = "testUser";
        User user = new User();
        user.setLoginname(loginname);

        when(currentUser.getLoginname()).thenReturn(loginname);
        when(userService.getUserByLoginname(loginname)).thenReturn(Optional.of(user));

       
        mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(view().name("account"))
                .andExpect(model().attributeExists("customer"));

        verify(userService, times(1)).getUserByLoginname(loginname);
    }

    @Test
    void testViewAccount_RedirectToHomeIfNoUser() throws Exception {
    
        String loginname = "testUser";
        when(currentUser.getLoginname()).thenReturn(loginname);
        when(userService.getUserByLoginname(loginname)).thenReturn(Optional.empty());

    
        mockMvc.perform(get("/account"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/home"));

        verify(userService, times(1)).getUserByLoginname(loginname);
    }

    @Test
    void testUpdateName() throws Exception {
     
        String loginname = "testUser";
        User user = new User();
        user.setLoginname(loginname);

        when(currentUser.getLoginname()).thenReturn(loginname);
        when(userService.getUserByLoginname(loginname)).thenReturn(Optional.of(user));

      
        mockMvc.perform(post("/updateName")
                .param("newFirstName", "xxx")
                .param("newLastName", "yyy"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/account"));

        verify(userService, times(1)).getUserByLoginname(loginname);
        verify(userService, times(1)).updateCustomer(user);
    }
}
