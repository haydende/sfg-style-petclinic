package haydende.sfgstylepetclinic.controllers;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    MockMvc mockMvc;

    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        int numOwners = 2;
        mockMvc.perform(get("/"))
            // verify that HTTP status is 'ok'
            .andExpect(status().isOk())
            // verify that the name of the provided view is "owners/index"
            .andExpect(view().name("owners/index"))
            // verify that the model contains an attribute of 'owners' that features two items
            .andExpect(model().attribute("owners", hasSize(numOwners)));
    }

    @Test
    void findOwners() throws Exception {
        String viewName = "owners/findowners";
        mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name(viewName));
        verifyZeroInteractions(ownerService);
    }
}