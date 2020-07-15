package haydende.sfgstylepetclinic.bootstrap;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.model.Vet;
import haydende.sfgstylepetclinic.services.OwnerService;
import haydende.sfgstylepetclinic.services.VetService;
import haydende.sfgstylepetclinic.services.map.OwnerServiceMap;
import haydende.sfgstylepetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("First-Name");
        owner1.setLastName("Last-Name");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Nirst-Fame");
        owner2.setLastName("Nast-Lame");

        ownerService.save(owner2);

        System.out.println("Loaded the owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vett");
        vet1.setLastName("Ttev");

        vetService.save(vet1);

        System.out.println("Loaded the vets...");
    }
}
