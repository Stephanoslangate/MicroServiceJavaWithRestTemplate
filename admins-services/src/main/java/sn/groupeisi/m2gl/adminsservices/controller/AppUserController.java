package sn.groupeisi.m2gl.adminsservices.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.m2gl.adminsservices.domain.AppUser;
import sn.groupeisi.m2gl.adminsservices.service.AppUserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController {
    private AppUserService appUserService;

    @GetMapping
    public List<AppUser> getAll() {
        return appUserService.getAppUsers();

    }
    @RequestMapping(value = "/{id}")
    public AppUser getById(@PathVariable int id) {
        return appUserService.getAppUser(id);

    }
    @GetMapping("/helloAdmin")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("{\"value\": \"Je suis Admin - Stephanos\"}");
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)//si on insert il faut nous envoyer le status create-->200
    //@IsAdmin
    public AppUser createAppUser(@Valid @RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }
}