package com.example.ocp_be.controller;

import com.example.ocp_be.entity.exceptions.ProductNotFoundException;
import com.example.ocp_be.entity.Role;
import com.example.ocp_be.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public String addRole(@ModelAttribute Role role) {
        Role saveRole = roleService.saveRole(role);
        return "homePage";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleByName(@PathVariable Long id) {
        Role role = roleService.searchRoleById(id);
        if (id == null) {
            throw new ProductNotFoundException("You are not allowed to ask for this role");
        }
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public String deleteRoleById(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return "Role successfully deleted";
    }

}
