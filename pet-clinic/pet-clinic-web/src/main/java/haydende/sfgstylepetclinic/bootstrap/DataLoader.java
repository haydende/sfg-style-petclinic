package haydende.sfgstylepetclinic.bootstrap;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.model.Vet;
import haydende.sfgstylepetclinic.services.OwnerService;
import haydende.sfgstylepetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("First-Name");
        owner1.setLastName("Last-Name");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nirst-Fame");
        owner2.setLastName("Nast-Lame");

        ownerService.save(owner2);

        System.out.println("Loaded the owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vett");
        vet1.setLastName("Ttev");

        vetService.save(vet1);

        System.out.println("Loaded the vets...");
    }
}
