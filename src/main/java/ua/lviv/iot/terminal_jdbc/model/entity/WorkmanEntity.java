package ua.lviv.iot.terminal_jdbc.model.entity;

import java.math.BigDecimal;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

@Table(name = "workman")
public class WorkmanEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "name", length = 45)
  private String name;
  @Column(name = "surname", length = 45)
  private String surname;
  @Column(name = "price_per_hour_uah")
  private BigDecimal pricePerHourUah;
  @Column(name = "contact_number", length = 13)
  private String contactNumber;
  @Column(name = "sex_id")
  private Integer sexId;
  @Column(name = "post_id")
  private Integer postId;

  public WorkmanEntity() {
  }

  public WorkmanEntity(Integer id, String name, String surname, BigDecimal pricePerHourUah, String contactNumber,
      Integer sexId, Integer postId) {
    super();
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.pricePerHourUah = pricePerHourUah;
    this.contactNumber = contactNumber;
    this.sexId = sexId;
    this.postId = postId;
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public BigDecimal getPricePerHourUah() {
    return pricePerHourUah;
  }

  public void setPricePerHourUah(BigDecimal pricePerHourUah) {
    this.pricePerHourUah = pricePerHourUah;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public Integer getSexId() {
    return sexId;
  }

  public void setSexId(Integer sexId) {
    this.sexId = sexId;
  }

  public Integer getPostId() {
    return postId;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  @Override
  public String toString() {
    return "WorkmanEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", pricePerHourUah="
        + pricePerHourUah + ", contactNumber=" + contactNumber + ", sexId=" + sexId + ", postId=" + postId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((postId == null) ? 0 : postId.hashCode());
    result = prime * result + ((pricePerHourUah == null) ? 0 : pricePerHourUah.hashCode());
    result = prime * result + ((sexId == null) ? 0 : sexId.hashCode());
    result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
    WorkmanEntity other = (WorkmanEntity) obj;
    if (contactNumber == null) {
      if (other.contactNumber != null) {
        return false;
      }
    } else if (!contactNumber.equals(other.contactNumber)) {
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
    if (postId == null) {
      if (other.postId != null) {
        return false;
      }
    } else if (!postId.equals(other.postId)) {
      return false;
    }
    if (pricePerHourUah == null) {
      if (other.pricePerHourUah != null) {
        return false;
      }
    } else if (!pricePerHourUah.equals(other.pricePerHourUah)) {
      return false;
    }
    if (sexId == null) {
      if (other.sexId != null) {
        return false;
      }
    } else if (!sexId.equals(other.sexId)) {
      return false;
    }
    if (surname == null) {
      if (other.surname != null) {
        return false;
      }
    } else if (!surname.equals(other.surname)) {
      return false;
    }
    return true;
  }

}
