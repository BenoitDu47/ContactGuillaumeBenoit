package fr.fms.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    @Size(min=1 , max=25)
    private String name;
    @NotNull
    @Size(min=1, max=25)
    private String firstName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 5, max= 50)
    private String address;
    @NotNull
    @Digits(fraction=0, integer=10, message="Numéro invalide")
    private String phone;

    @ManyToOne
    private Category category;

}