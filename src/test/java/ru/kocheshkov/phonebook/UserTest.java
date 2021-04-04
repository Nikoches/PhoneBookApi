package ru.kocheshkov.phonebook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import ru.kocheshkov.phonebook.Main;
import ru.kocheshkov.phonebook.controllers.ContactController;
import ru.kocheshkov.phonebook.controllers.UserController;
import ru.kocheshkov.phonebook.domain.Contact;
import ru.kocheshkov.phonebook.domain.User;


import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;
    @MockBean
    private ContactController contactController;
    @Test
    public void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }
    @Test
    public void test() throws Exception {
        this.mockMvc.perform(get("/api/users")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void getUsers() throws Exception {
        User user = new User();
        user.setName("Alexander The Great");
        List<User> users = singletonList(user);

        given(userController.getAllUsers()).willReturn(users);

        mockMvc.perform(get("/api/users")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(user.getName())));
    }
    @Test
    public void getContacts() throws Exception {
        Contact contact = new Contact();
        User user = new User();
        user.setName("Alexander The Great");
        user.setId(1);
        contact.setName("Alexander The Great");
        contact.setNumber("8800555353");
        contact.setUser(user);
        List<Contact> contactList = singletonList(contact);

        given(contactController.getAllContactsByUserId(1)).willReturn(contactList);

        mockMvc.perform(get("/api/contacts/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].number", is(contact.getNumber())))
                .andExpect(jsonPath("$[0].name", is(contact.getName())));
    }
}
