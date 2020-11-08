package ua.lviv.iot.terminal.model.entity;

import ua.lviv.iot.terminal.model.annotation.Column;
import ua.lviv.iot.terminal.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal.model.annotation.Table;

@Table(name = "address")
public class AddressEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "street", length = 64)
  private String street;
  @Column(name = "city_id")
  private Integer cityId;
  @Column(name = "house")
  private Integer house;

  public AddressEntity() {
  }

  public AddressEntity(Integer id, String street, Integer cityId, Integer house) {
    super();
    this.id = id;
    this.street = street;
    this.cityId = cityId;
    this.house = house;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public Integer getHouse() {
    return house;
  }

  public void setHouse(Integer house) {
    this.house = house;
  }

  @Override
  public String toString() {
    return "AddressEntity [id=" + id + ", street=" + street + ", cityId=" + cityId + ", house=" + house + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
    result = prime * result + ((house == null) ? 0 : house.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((street == null) ? 0 : street.hashCode());
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
    AddressEntity other = (AddressEntity) obj;
    if (cityId == null) {
      if (other.cityId != null) {
        return false;
      }
    } else if (!cityId.equals(other.cityId)) {
      return false;
    }
    if (house == null) {
      if (other.house != null) {
        return false;
      }
    } else if (!house.equals(other.house)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (street == null) {
      if (other.street != null) {
        return false;
      }
    } else if (!street.equals(other.street)) {
      return false;
    }
    return true;
  }

}
