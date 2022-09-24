package shuaicj.example.security.common.repository.sql;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import shuaicj.example.security.common.model.GatewayUser;

@Repository
public interface UserRepo extends JpaRepository<GatewayUser, Integer> {

    @Modifying
    @Transactional
    @Query("update GatewayUser u set u.application_api_key = :appKey, u.application_api_code = :appId")
    void updateGatewayUser(@Param("appId") String appId, @Param("appKey") String appKey);

    @Query("select u from GatewayUser u where u.application_api_code = :appId")
    GatewayUser findGatewayUserByAppId(@Param("appId") String appId);
}
