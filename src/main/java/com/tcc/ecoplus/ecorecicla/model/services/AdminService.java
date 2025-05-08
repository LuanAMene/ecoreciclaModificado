package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Admin;

import java.util.List;

public interface AdminService {

    public Admin save(Admin admin);
    public List<Admin> findAll();
    public Admin findById(Long id);
    public boolean delete(Long id);
}
