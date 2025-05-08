package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Admin;
import com.tcc.ecoplus.ecorecicla.model.repository.AdminRepository;

import java.util.List;

public class AdminServiceImp  implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return List.of();
    }

    @Override
    public Admin findById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
