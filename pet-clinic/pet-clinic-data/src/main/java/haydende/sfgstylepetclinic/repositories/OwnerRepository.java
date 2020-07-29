package haydende.sfgstylepetclinic.repositories;

import haydende.sfgstylepetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike(String lastName);

    Set<Owner> findAll();

    Owner save(Owner owner);

    void delete(Owner owner);

    void deleteById(Long id);

    void deleteAll();
}
