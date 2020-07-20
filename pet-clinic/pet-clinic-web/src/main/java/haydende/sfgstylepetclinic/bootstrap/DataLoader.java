package haydende.sfgstylepetclinic.bootstrap;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.model.Pet;
import haydende.sfgstylepetclinic.model.PetType;
import haydende.sfgstylepetclinic.model.Vet;
import haydende.sfgstylepetclinic.services.OwnerService;
import haydende.sfgstylepetclinic.services.PetTypeService;
import haydende.sfgstylepetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("First-Name");
        owner1.setLastName("Last-Name");
        owner1.setAddress("123 Street");
        owner1.setCity("Citytown");
        owner1.setTelephone("123456789");

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Owner1Dog");
        owner1Pet.setPetType(dog);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.of(1999, 07, 12));
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nirst-Fame");
        owner2.setLastName("Nast-Lame");
        owner2.setAddress("123 Street");
        owner2.setCity("Citytown");
        owner2.setTelephone("123456789");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Owner2Cat");
        owner2Pet.setPetType(cat);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.of(2005, 12, 16));
        ownerService.save(owner2);

        System.out.println("Loaded the owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vett");
        vet1.setLastName("Ttev");

        vetService.save(vet1);

        System.out.println("Loaded the vets...");
    }
}
