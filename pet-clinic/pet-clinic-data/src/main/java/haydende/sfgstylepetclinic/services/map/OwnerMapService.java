package haydende.sfgstylepetclinic.services.map;

import haydende.sfgstylepetclinic.model.Owner;
import haydende.sfgstylepetclinic.model.Pet;
import haydende.sfgstylepetclinic.model.PetType;
import haydende.sfgstylepetclinic.services.OwnerService;
import haydende.sfgstylepetclinic.services.PetService;
import haydende.sfgstylepetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long>
                             implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            // if the PetType instance hasn't been saved yet,
                            // save it and then add the returned version to
                            // the pet instance (so it will have an ID)
                            PetType savedType = petTypeService.save(pet.getPetType());

                            System.out.println("PetType being saved: " + savedType);
                            pet.setPetType(petTypeService.save(savedType));
                        }
                        if (pet.getId() == null) {
                            // stored returned instance of Pet for later use
                            Pet savedPet = petService.save(pet);
                            System.out.println("Pet being saved: " + savedPet);
                            // get Id value from savedPet and provide it to pet
                            pet.setId(savedPet.getId());
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
