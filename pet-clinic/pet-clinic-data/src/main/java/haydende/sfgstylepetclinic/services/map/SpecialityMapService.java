package haydende.sfgstylepetclinic.services.map;

import haydende.sfgstylepetclinic.model.Speciality;
import haydende.sfgstylepetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long>
                                  implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Speciality object) {

    }

    @Override
    public Speciality save(Speciality object) {
        return null;
    }

    @Override
    public Speciality findById(Long id) {
        return null;
    }
}
