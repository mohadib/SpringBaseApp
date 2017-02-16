package org.openactive.ReactNotes.domain;

import org.openactive.ReactNotes.domain.listeners.CreatableAndUpdateable;
import org.openactive.ReactNotes.domain.listeners.CreateUpdateListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "user")
@EntityListeners({ CreateUpdateListener.class })
public class User implements CreatableAndUpdateable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, unique = true)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, length = 60)
  private String password;

  @Basic
  private String fname;

  @Basic
  private String lname;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created", nullable = false )
  private Date created;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "lastUpdated" )
  private Date lastUpdated;

  @ManyToMany
  List<Role> roles;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getFname()
  {
    return fname;
  }

  public void setFname(String fname)
  {
    this.fname = fname;
  }

  public String getLname()
  {
    return lname;
  }

  public void setLname(String lname)
  {
    this.lname = lname;
  }

  @Override
  public Date getCreated()
  {
    return created;
  }

  @Override
  public void setCreated(Date created)
  {
    this.created = created;
  }

  @Override
  public Date getLastUpdated()
  {
    return lastUpdated;
  }

  @Override
  public void setLastUpdated(Date lastUpdated)
  {
    this.lastUpdated = lastUpdated;
  }

  public List<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(List<Role> roles)
  {
    this.roles = roles;
  }
}
