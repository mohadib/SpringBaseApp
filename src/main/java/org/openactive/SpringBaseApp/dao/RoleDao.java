package org.openactive.SpringBaseApp.dao;

import org.openactive.SpringBaseApp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer>
{
}
