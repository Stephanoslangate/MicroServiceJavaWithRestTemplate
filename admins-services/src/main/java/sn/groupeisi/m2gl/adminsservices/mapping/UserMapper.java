package sn.groupeisi.m2gl.adminsservices.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.m2gl.adminsservices.domain.AppUser;
import sn.groupeisi.m2gl.adminsservices.entity.UserEntity;
import org.springframework.context.annotation.*;


@Mapper
public interface UserMapper {
    AppUser toAppUser(UserEntity appUserEntity);
    UserEntity fromAppUser(AppUser appUser);

}
