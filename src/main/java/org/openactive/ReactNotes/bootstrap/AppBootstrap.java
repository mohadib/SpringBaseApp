package org.openactive.ReactNotes.bootstrap;

import org.openactive.ReactNotes.dao.RoleDao;
import org.openactive.ReactNotes.dao.UserDao;
import org.openactive.ReactNotes.domain.Role;
import org.openactive.ReactNotes.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppBootstrap extends LoadData
{
  @Autowired
  private RoleDao roleDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void load()
  {
    Role adminRole = new Role("ROLE_ADMIN");
    adminRole = roleDao.save(adminRole);

    Role userRole = new Role("ROLE_USER");
    userRole = roleDao.save(userRole);

    User jason = new User();
    jason.setFname("Jason");
    jason.setLname("Davis");
    jason.setEmail("jdavis@openactive.org");
    jason.setPassword(passwordEncoder.encode("letmein"));
    jason.setRoles(Arrays.asList( adminRole, userRole));
    jason = userDao.save(jason);
  }
}
