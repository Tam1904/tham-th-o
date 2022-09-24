package shuaicj.example.security.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shuaicj.example.security.common.model.GatewayUser;
import shuaicj.example.security.common.model.Role;
import shuaicj.example.security.common.repository.sql.RoleRepo;
import shuaicj.example.security.common.repository.sql.UserRepo;

import java.util.HashSet;

@Service
public class GatewayUserDetailsService implements UserDetailsService {

    @Autowired
    protected UserRepo userRepo;

    @Autowired
    protected RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String appId) throws UsernameNotFoundException {

        GatewayUser gatewayUser = userRepo.findGatewayUserByAppId(appId);

        HashSet<Role> roles = roleRepo.findRoleByAppId(gatewayUser.getId());

        HashSet<GrantedAuthority> authorities = new HashSet<>(roles.size());

        for (Role role : roles)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));

        return new User(gatewayUser.getApplication_api_code(), gatewayUser.getApplication_api_key(), authorities);
    }
}
