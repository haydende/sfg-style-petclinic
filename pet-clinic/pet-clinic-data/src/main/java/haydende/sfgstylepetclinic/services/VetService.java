package haydende.sfgstylepetclinic.services;

import haydende.sfgstylepetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{

    Vet save(Vet vet);

    void delete(Vet vet);

    void deleteById(Long id);

}
