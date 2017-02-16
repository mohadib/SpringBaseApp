package org.openactive.ReactNotes.dao;

import org.openactive.ReactNotes.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer>
{
}
