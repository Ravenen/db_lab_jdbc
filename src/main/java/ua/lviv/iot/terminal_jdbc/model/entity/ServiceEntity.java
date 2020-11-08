package ua.lviv.iot.terminal_jdbc.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.InputIgnore;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

@Table(name = "service")
public class ServiceEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "date")
  private Date date;
  @Column(name = "terminal_id")
  private Integer terminalId;
  @Column(name = "workman_id")
  private Integer workmanId;
  @Column(name = "service_type_id")
  private Integer serviceTypeId;
  @Column(name = "duration_in_hours")
  private BigDecimal durationInHours;
  @InputIgnore
  @Column(name = "total_price_uah")
  private BigDecimal totalPriceUah;

  public ServiceEntity() {
  }

  public ServiceEntity(Integer id, Date date, Integer terminalId, Integer workmanId, Integer serviceTypeId,
      BigDecimal durationInHours, BigDecimal totalPriceUah) {
    super();
    this.id = id;
    this.date = (Date) date.clone();
    this.terminalId = terminalId;
    this.workmanId = workmanId;
    this.serviceTypeId = serviceTypeId;
    this.durationInHours = durationInHours;
    this.totalPriceUah = totalPriceUah;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDate() {
    return (Date) date.clone();
  }

  public void setDate(Date date) {
    this.date = (Date) date.clone();
  }

  public Integer getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(Integer terminalId) {
    this.terminalId = terminalId;
  }

  public Integer getWorkmanId() {
    return workmanId;
  }

  public void setWorkmanId(Integer workmanId) {
    this.workmanId = workmanId;
  }

  public Integer getServiceTypeId() {
    return serviceTypeId;
  }

  public void setServiceTypeId(Integer serviceTypeId) {
    this.serviceTypeId = serviceTypeId;
  }

  public BigDecimal getDurationInHours() {
    return durationInHours;
  }

  public void setDurationInHours(BigDecimal durationInHours) {
    this.durationInHours = durationInHours;
  }

  public BigDecimal getTotalPriceUah() {
    return totalPriceUah;
  }

  public void setTotalPriceUah(BigDecimal totalPriceUah) {
    this.totalPriceUah = totalPriceUah;
  }

  @Override
  public String toString() {
    return "ServiceEntity [id=" + id + ", date=" + date + ", terminalId=" + terminalId + ", workmanId=" + workmanId
        + ", serviceTypeId=" + serviceTypeId + ", durationInHours=" + durationInHours + ", totalPriceUah="
        + totalPriceUah + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + ((durationInHours == null) ? 0 : durationInHours.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((serviceTypeId == null) ? 0 : serviceTypeId.hashCode());
    result = prime * result + ((terminalId == null) ? 0 : terminalId.hashCode());
    result = prime * result + ((totalPriceUah == null) ? 0 : totalPriceUah.hashCode());
    result = prime * result + ((workmanId == null) ? 0 : workmanId.hashCode());
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
    ServiceEntity other = (ServiceEntity) obj;
    if (date == null) {
      if (other.date != null) {
        return false;
      }
    } else if (!date.equals(other.date)) {
      return false;
    }
    if (durationInHours == null) {
      if (other.durationInHours != null) {
        return false;
      }
    } else if (!durationInHours.equals(other.durationInHours)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (serviceTypeId == null) {
      if (other.serviceTypeId != null) {
        return false;
      }
    } else if (!serviceTypeId.equals(other.serviceTypeId)) {
      return false;
    }
    if (terminalId == null) {
      if (other.terminalId != null) {
        return false;
      }
    } else if (!terminalId.equals(other.terminalId)) {
      return false;
    }
    if (totalPriceUah == null) {
      if (other.totalPriceUah != null) {
        return false;
      }
    } else if (!totalPriceUah.equals(other.totalPriceUah)) {
      return false;
    }
    if (workmanId == null) {
      if (other.workmanId != null) {
        return false;
      }
    } else if (!workmanId.equals(other.workmanId)) {
      return false;
    }
    return true;
  }
  
}
