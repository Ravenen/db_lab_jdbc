package ua.lviv.iot.terminal.model.entity;

import ua.lviv.iot.terminal.model.annotation.Column;
import ua.lviv.iot.terminal.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal.model.annotation.Table;

@Table(name = "manufacturer")
public class ManufacturerEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "name", length = 45)
  private String name;
  @Column(name = "contact_number", length = 13)
  private String contactNumber;
  @Column(name = "country_id")
  private Integer countryId;

  public ManufacturerEntity() {
  }

  public ManufacturerEntity(Integer id, String name, String contactNumber, Integer countryId) {
    super();
    this.id = id;
    this.name = name;
    this.contactNumber = contactNumber;
    this.countryId = countryId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

  @Override
  public String toString() {
    return "ManufacturerEntity [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", countryId="
        + countryId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
    result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
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
    ManufacturerEntity other = (ManufacturerEntity) obj;
    if (contactNumber == null) {
      if (other.contactNumber != null) {
        return false;
      }
    } else if (!contactNumber.equals(other.contactNumber)) {
      return false;
    }
    if (countryId == null) {
      if (other.countryId != null) {
        return false;
      }
    } else if (!countryId.equals(other.countryId)) {
      return false;
    }
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
