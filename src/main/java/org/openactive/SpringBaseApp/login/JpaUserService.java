package org.openactive.SpringBaseApp.login;

import org.openactive.SpringBaseApp.dao.UserDao;
import org.openactive.SpringBaseApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class JpaUserService implements UserDetailsService
{

  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    User user = userDao.findOneByEmail( username );
    if( user == null )
    {
      throw new UsernameNotFoundException("Not found");
    }
    org.springframework.security.core.userdetails.User springUser =
      new org.springframework.security.core.userdetails.User( user.getEmail(), user.getPassword(), true, true, true, true, new ArrayList<>());

    return springUser;
  }
}
