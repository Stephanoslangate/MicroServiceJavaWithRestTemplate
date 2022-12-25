package sn.groupeisi.m2gl.adminsservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.groupeisi.m2gl.adminsservices.entity.UserEntity;

@Repository
public interface IAppUserRepository  extends JpaRepository<UserEntity, Integer> {
}
