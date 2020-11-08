package ua.lviv.iot.terminal_jdbc.model.entity;

import java.sql.Date;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

@Table(name = "terminal")
public class TerminalEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "gps_coordinates", length = 24)
  private String gpsCoordinates;
  @Column(name = "commissioning_date")
  private Date commissioningDate;
  @Column(name = "manufacturer_id")
  private Integer manufacturerId;
  @Column(name = "terminal_type_id")
  private Integer terminalTypeId;
  @Column(name = "address_id")
  private Integer addressId;

  public TerminalEntity() {
  }

  public TerminalEntity(Integer id, String gpsCoordinates, Date commisioningDate, Integer manufacturerId,
      Integer terminalTypeId, Integer addressId) {
    super();
    this.id = id;
    this.gpsCoordinates = gpsCoordinates;
    this.commissioningDate = commisioningDate;
    this.manufacturerId = manufacturerId;
    this.terminalTypeId = terminalTypeId;
    this.addressId = addressId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getGpsCoordinates() {
    return gpsCoordinates;
  }

  public void setGpsCoordinates(String gpsCoordinates) {
    this.gpsCoordinates = gpsCoordinates;
  }

  public Date getCommisioningDate() {
    return commissioningDate;
  }

  public void setCommisioningDate(Date commisioningDate) {
    this.commissioningDate = commisioningDate;
  }

  public Integer getManufacturerId() {
    return manufacturerId;
  }

  public void setManufacturerId(Integer manufacturerId) {
    this.manufacturerId = manufacturerId;
  }

  public Integer getTerminalTypeId() {
    return terminalTypeId;
  }

  public void setTerminalTypeId(Integer terminalTypeId) {
    this.terminalTypeId = terminalTypeId;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  @Override
  public String toString() {
    return "Terminal [id=" + id + ", gpsCoordinates=" + gpsCoordinates + ", commisioningDate=" + commissioningDate
        + ", manufacturerId=" + manufacturerId + ", terminalTypeId=" + terminalTypeId + ", addressId=" + addressId
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
    result = prime * result + ((commissioningDate == null) ? 0 : commissioningDate.hashCode());
    result = prime * result + ((gpsCoordinates == null) ? 0 : gpsCoordinates.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((manufacturerId == null) ? 0 : manufacturerId.hashCode());
    result = prime * result + ((terminalTypeId == null) ? 0 : terminalTypeId.hashCode());
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
    TerminalEntity other = (TerminalEntity) obj;
    if (addressId == null) {
      if (other.addressId != null) {
        return false;
      }
    } else if (!addressId.equals(other.addressId)) {
      return false;
    }
    if (commissioningDate == null) {
      if (other.commissioningDate != null) {
        return false;
      }
    } else if (!commissioningDate.equals(other.commissioningDate)) {
      return false;
    }
    if (gpsCoordinates == null) {
      if (other.gpsCoordinates != null) {
        return false;
      }
    } else if (!gpsCoordinates.equals(other.gpsCoordinates)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (manufacturerId == null) {
      if (other.manufacturerId != null) {
        return false;
      }
    } else if (!manufacturerId.equals(other.manufacturerId)) {
      return false;
    }
    if (terminalTypeId == null) {
      if (other.terminalTypeId != null) {
        return false;
      }
    } else if (!terminalTypeId.equals(other.terminalTypeId)) {
      return false;
    }
    return true;
  }

}
