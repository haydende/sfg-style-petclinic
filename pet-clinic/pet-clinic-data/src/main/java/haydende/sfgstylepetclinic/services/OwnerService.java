package haydende.sfgstylepetclinic.services;

import haydende.sfgstylepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
