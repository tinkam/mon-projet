package com.starstel.telcopro.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.accounts.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> 
{
	public AppRole findByRoleName(String roleName);
}
