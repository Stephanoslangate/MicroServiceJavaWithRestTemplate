package sn.groupeisi.m2gl.adminsservices.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.context.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import sn.groupeisi.m2gl.adminsservices.domain.AppUser;
import sn.groupeisi.m2gl.adminsservices.exception.EntityNotFoundException;
import sn.groupeisi.m2gl.adminsservices.mapping.UserMapper;
import sn.groupeisi.m2gl.adminsservices.repository.IAppUserRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor

public class AppUserService {
    private IAppUserRepository iAppUserRepository;
    private UserMapper appUserMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public List<AppUser> getAppUsers() {
        return StreamSupport.stream(iAppUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUser)
                .collect(Collectors.toList());
    }
    //si on veut recuperer un seul
    @Transactional(readOnly = true)
    public AppUser getAppUser(int id) {
        return appUserMapper.toAppUser(iAppUserRepository.findById(id)
                .orElseThrow(() ->//on cherche si on trouve on retourn  sinon on vas simplement envoyer saa
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public AppUser createAppUser(AppUser appUser) {
        return appUserMapper.toAppUser(iAppUserRepository.save(appUserMapper.fromAppUser(appUser)));
    }

}
