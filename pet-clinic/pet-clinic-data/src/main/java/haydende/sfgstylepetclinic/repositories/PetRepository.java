package haydende.sfgstylepetclinic.repositories;

import haydende.sfgstylepetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
