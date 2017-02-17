package org.openactive.SpringBaseApp.dao;

import org.openactive.SpringBaseApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>
{
  User findOneByEmail( String email );
}
