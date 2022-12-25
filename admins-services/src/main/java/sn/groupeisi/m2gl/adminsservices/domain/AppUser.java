package sn.groupeisi.m2gl.adminsservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements Serializable {
    private int id;
    private String password;
    @NotNull(message = "le nom ne doit pas etre null")
    private String email;
}
