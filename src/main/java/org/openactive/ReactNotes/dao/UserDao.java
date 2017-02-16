package org.openactive.ReactNotes.dao;

import org.openactive.ReactNotes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>
{
  public User findOneByEmail( String email );
}
