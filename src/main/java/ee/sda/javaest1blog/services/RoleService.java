package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.Role;
import ee.sda.javaest1blog.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {

    final RoleRepository repository;

    public Role save(Role role){
        return repository.save(role);
    }
}
