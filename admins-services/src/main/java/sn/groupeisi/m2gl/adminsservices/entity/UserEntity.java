package sn.groupeisi.m2gl.adminsservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true ,nullable = false ,  length = 150)
    private String email;
    @Column(unique = true ,nullable = false ,  length = 150)
    private String password;
}
