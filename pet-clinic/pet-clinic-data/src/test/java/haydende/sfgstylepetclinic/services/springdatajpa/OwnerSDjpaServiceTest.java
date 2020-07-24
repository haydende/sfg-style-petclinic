package haydende.sfgstylepetclinic.services.springdatajpa;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.repositories.OwnerRepository;
import haydende.sfgstylepetclinic.repositories.PetRepository;
import haydende.sfgstylepetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDjpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDjpaService ownerSDjpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName("Smith").build();

        when(ownerSDjpaService.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerSDjpaService.findByLastName("Smith");

        assertEquals("Smith", smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwners = new HashSet<>();
        returnedOwners.add(Owner.builder().id(2L).build());

        when(ownerSDjpaService.findAll()).thenReturn(returnedOwners);

        Set<Owner> owners = ownerSDjpaService.findAll();

        assertNotNull(owners);
        assertEquals(1, owners.size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        Owner returnedOwner =  Owner.builder().id(1L).build();

        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));

        Owner actualOwner = ownerSDjpaService.findById(1L);

        assertEquals(1L, actualOwner.getId());
    }

    @Test
    void save() {
        Owner returnedOwner = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner actualOwner = ownerSDjpaService.save(Owner.builder().id(1L).build());

        assertEquals(1L, actualOwner.getId());

    }

    @Test
    void deleteNonSaved() {
        ownerSDjpaService.delete(Owner.builder().build());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDjpaService.deleteById(1L);
        verify(ownerRepository).deleteById(any());
    }
}