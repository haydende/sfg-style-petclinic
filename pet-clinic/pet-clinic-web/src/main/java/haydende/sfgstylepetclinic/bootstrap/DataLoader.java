package haydende.sfgstylepetclinic.bootstrap;

import haydende.sfgstylepetclinic.model.*;
import haydende.sfgstylepetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final SpecialityService specialityService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, SpecialityService specialityService, VetService vetService,
                      PetTypeService petTypeService, PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.specialityService = specialityService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("First-Name");
        owner1.setLastName("Last-Name");
        owner1.setAddress("123 Street");
        owner1.setCity("Citytown");
        owner1.setTelephone("123456789");

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Owner1Dog");
        owner1Pet.setPetType(savedDog);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.of(1999, 07, 12));
        owner1.getPets().add(owner1Pet);
        ownerService.save(owner1);

        Visit owner1visit = new Visit();
        owner1visit.setPet(owner1Pet);
        owner1visit.setDate(LocalDate.now());
        owner1visit.setDescription("Dog owned by First-Name Last-Name was " +
            "taken in.");

        visitService.save(owner1visit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nirst-Fame");
        owner2.setLastName("Nast-Lame");
        owner2.setAddress("123 Street");
        owner2.setCity("Citytown");
        owner2.setTelephone("123456789");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Owner2Cat");
        owner2Pet.setPetType(savedCat);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.of(2005, 12, 16));
        owner2.getPets().add(owner2Pet);
        ownerService.save(owner2);

        System.out.println("Loaded the owners...");

        Speciality radiology = new Speciality();
        Speciality surgery = new Speciality();
        Speciality dentistry = new Speciality();

        radiology.setDescription("Radiology");
        surgery.setDescription("Surgery");
        dentistry.setDescription("Dentistry");

        radiology = specialityService.save(radiology);
        surgery = specialityService.save(surgery);
        dentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vett");
        vet1.setLastName("Ttev");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet-name");
        vet2.setLastName("Vet-lastName");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Vet3Name");
        vet3.setLastName("Vet3LastName");
        vet3.getSpecialities().add(dentistry);
        vetService.save(vet3);

        System.out.println("Loaded the vets...");
    }
}
