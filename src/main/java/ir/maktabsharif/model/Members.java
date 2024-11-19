package ir.maktabsharif.model;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Members extends Users {



    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();


}
