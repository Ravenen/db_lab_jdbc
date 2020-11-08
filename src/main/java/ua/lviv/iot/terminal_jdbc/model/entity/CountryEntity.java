package ua.lviv.iot.terminal_jdbc.model.entity;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

@Table(name = "country")
public class CountryEntity implements Cloneable {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "name", length = 53)
  private String name;

  public CountryEntity() {
    super();
  }

  public CountryEntity(int id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "CountryEntity [id=" + id + ", name=" + name + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    CountryEntity other = (CountryEntity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

}
