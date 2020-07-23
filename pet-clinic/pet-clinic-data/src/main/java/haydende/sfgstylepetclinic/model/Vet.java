package haydende.sfgstylepetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        // Define the name of the Join Table
        name = "vet_specialities",
        // Column from this table used in the join table
        joinColumns = @JoinColumn(name = "vet_id"),
        // Column from the joining table used in the join table
        inverseJoinColumns = @JoinColumn(name = "speciality")
    )
    private Set<Speciality> specialities = new HashSet<>();

}
