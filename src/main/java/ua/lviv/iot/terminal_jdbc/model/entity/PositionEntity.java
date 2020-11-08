package ua.lviv.iot.terminal_jdbc.model.entity;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

@Table(name = "post")
public class PositionEntity {
  @PrimaryKey
  @Column(name = "id")
  private Integer id;
  @Column(name = "post", length = 45)
  private String post;

  public PositionEntity() {
  }

  public PositionEntity(Integer id, String name) {
    super();
    this.id = id;
    this.post = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return post;
  }

  public void setName(String name) {
    this.post = name;
  }

  @Override
  public String toString() {
    return "PositionEntity [id=" + id + ", name=" + post + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((post == null) ? 0 : post.hashCode());
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
    PositionEntity other = (PositionEntity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (post == null) {
      if (other.post != null) {
        return false;
      }
    } else if (!post.equals(other.post)) {
      return false;
    }
    return true;
  }

}
