package ee.sda.javaest1blog.configurations;

import ee.sda.javaest1blog.entities.Role;
import ee.sda.javaest1blog.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@RequiredArgsConstructor
public class JEUserDetails implements UserDetails {

    final User user;

    @Override
    @Transactional
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authoritySet = new HashSet<>();
        Collection<Role> roles = user.getRoles();
        roles.forEach(role -> {
                authoritySet.add(new SimpleGrantedAuthority(role.getName()));
                role.getPrivileges().forEach(privilege -> {
                    authoritySet.add(new SimpleGrantedAuthority(privilege.getName()));
                });
        });
        return authoritySet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
