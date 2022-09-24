package shuaicj.example.security.common.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shuaicj.example.security.common.model.Role;

import java.util.HashSet;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.id.user.id = :userId and r.active = true")
    HashSet<Role> findRoleByAppId(@Param("userId") int userId);
}
