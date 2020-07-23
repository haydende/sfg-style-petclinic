package haydende.sfgstylepetclinic.services.map;

import haydende.sfgstylepetclinic.model.Vet;
import haydende.sfgstylepetclinic.services.SpecialityService;
import haydende.sfgstylepetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long>
                           implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                // check if the speciality instance has been registered by checking for an Id value
               if (speciality.getId() == null) {
                    // send the speciality to be saved by the specialityService and replace with instance that has an Id value
                   speciality = specialityService.save(speciality);
               }
            });
        }
        return super.save(object);
    }
}
