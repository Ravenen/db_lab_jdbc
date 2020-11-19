package ua.lviv.iot.terminal.model.entity;

import ua.lviv.iot.terminal.model.annotation.Column;
import ua.lviv.iot.terminal.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal.model.annotation.Table;

@Table(name = "city")
public class CityEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "name", length = 45)
  private String name;
  @Column(name = "postal_code", length = 6)
  private String postalCode;
  @Column(name = "region_id")
  private Integer regionId;
  @Column(name = "country_id")
  private Integer countryId;

  public CityEntity() {
  }

  public CityEntity(Integer id, String name, String postalCode, Integer regionId, Integer countryId) {
    super();
    this.id = id;
    this.name = name;
    this.postalCode = postalCode;
    this.regionId = regionId;
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

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Integer getRegionId() {
    return regionId;
  }

  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

  @Override
  public String toString() {
    return "CityEntity [id=" + id + ", name=" + name + ", postalCode=" + postalCode + ", regionId=" + regionId
        + ", countryId=" + countryId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
    result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
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
    CityEntity other = (CityEntity) obj;
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
    if (postalCode == null) {
      if (other.postalCode != null) {
        return false;
      }
    } else if (!postalCode.equals(other.postalCode)) {
      return false;
    }
    if (regionId == null) {
      if (other.regionId != null) {
        return false;
      }
    } else if (!regionId.equals(other.regionId)) {
      return false;
    }
    return true;
  }

}
