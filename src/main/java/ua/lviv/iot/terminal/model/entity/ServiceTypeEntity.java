package ua.lviv.iot.terminal.model.entity;

import ua.lviv.iot.terminal.model.annotation.Column;
import ua.lviv.iot.terminal.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal.model.annotation.Table;

@Table(name = "service_type")
public class ServiceTypeEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "type", length = 45)
  private String type;

  public ServiceTypeEntity() {
  }

  public ServiceTypeEntity(Integer id, String type) {
    super();
    this.id = id;
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ServiceTypeEntity [id=" + id + ", type=" + type + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
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
    ServiceTypeEntity other = (ServiceTypeEntity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    return true;
  }

}
