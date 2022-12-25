package sn.groupeisis.dashboardservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements Serializable {
    private int id;
    private String password;
    @NotNull(message = "le nom ne doit pas etre null")
    private String email;
}
