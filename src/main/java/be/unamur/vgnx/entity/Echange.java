package be.unamur.vgnx.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
// Echange de legume avec un autre legume
@Entity
@Table(name="ECHANGE")
@JsonIgnoreProperties(value = {"createdAt, updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Echange implements Serializable{
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name="pseudo")
  private User user;
  @JoinColumn(name="legume1",nullable=false)
  private String legume;
  @JoinColumn(name="legume2",nullable=false)
  private String legume2;
  @Column(nullable=false)
  private double qte;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;
  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;


  @Override
  public String toString() {
    return "Echange [id=" + id + ", user=" + user + ", legume=" + legume + ", legume2=" + legume2 + ", qte=" + qte
      + "]";
  }
  public Echange(Integer id, User user, String legume, String legume2, double qte) {

    this.id = id;
    this.user = user;
    this.legume = legume;
    this.legume2 = legume2;
    this.qte = qte;
  }
  public Echange() {

    // TODO Auto-generated constructor stub
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
  public String getLegume() {
    return legume;
  }
  public void setLegume(String legume) {
    this.legume = legume;
  }
  public String getLegume2() {
    return legume2;
  }
  public void setLegume2(String legume2) {
    this.legume2 = legume2;
  }
  public double getQte() {
    return qte;
  }
  public void setQte(double qte) {
    this.qte = qte;
  }


}
