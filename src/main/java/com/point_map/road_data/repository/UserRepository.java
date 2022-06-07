package com.point_map.road_data.repository;

import com.point_map.road_data.models.Role;
import com.point_map.road_data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        User user =
//
//            Set<Role> roles = user.getRoles();
//            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : roles) {
//                authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;
}
