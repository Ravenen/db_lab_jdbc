package ua.lviv.iot.terminal_jdbc.model.entity;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

@Table(name = "sex")
public class SexEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "sex", length = 45)
  private Integer sex;

  public SexEntity() {
  }

  public SexEntity(Integer id, Integer sex) {
    super();
    this.id = id;
    this.sex = sex;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "SexEntity [id=" + id + ", sex=" + sex + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
    SexEntity other = (SexEntity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (sex == null) {
      if (other.sex != null) {
        return false;
      }
    } else if (!sex.equals(other.sex)) {
      return false;
    }
    return true;
  }

}
