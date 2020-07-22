package haydende.sfgstylepetclinic.repositories;

import haydende.sfgstylepetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

    Speciality save(Speciality speciality);

    void delete(Speciality speciality);

    void deleteById(Long id);

}
