package org.openactive.ReactNotes.domain;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, unique = true)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String name;

  public Role(){}

  public Role(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (!(o instanceof Role)) return false;

    Role role = (Role) o;

    return getName().equals(role.getName());
  }

  @Override
  public int hashCode()
  {
    return getName().hashCode();
  }
}
