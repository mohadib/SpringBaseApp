package org.openactive.SpringBaseApp.dao;

import org.openactive.SpringBaseApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>
{
  public User findOneByEmail( String email );
}
