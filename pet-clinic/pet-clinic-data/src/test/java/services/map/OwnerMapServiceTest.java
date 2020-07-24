package services.map;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.services.map.OwnerMapService;
import haydende.sfgstylepetclinic.services.map.PetMapService;
import haydende.sfgstylepetclinic.services.map.PetTypeMapService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class OwnerMapServiceTest {

    final Long ownerID = 1L;
    final String lastName = "firstname";
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        // sets up dependency injection for this OwnerMapService class
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);
        assertEquals(ownerID, owner.getId());
    }

    @Test
    void save() {
        Owner savedOwner = ownerMapService.save(Owner.builder().id(3L).build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveExistingID() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }
}