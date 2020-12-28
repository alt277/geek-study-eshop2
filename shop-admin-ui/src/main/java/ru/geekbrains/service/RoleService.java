package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.model.Product;

import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.repo.RoleRepository;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Page <Role> findAll(Specification spec, PageRequest pageRequest){
        return roleRepository.findAll( pageRequest);
    }



}
