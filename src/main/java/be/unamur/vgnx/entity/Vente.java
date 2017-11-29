package be.unamur.vgnx.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="VENTES")
@JsonIgnoreProperties(value = {"createdAt, updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)

public class Vente implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "pseudo")
  private User user;
  @Column(nullable = false)
  private String legume;
  @Column(nullable = false)
  private double prixKg;
  @Column(nullable = false)
  private double qte;
  @Column(nullable = false)
  private double totalprix;
  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;
  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getTotalprix() {
    return totalprix;
  }

  public void setTotalprix(float totalprix) {
    this.totalprix = totalprix;
  }

  public void setPrixKg(float prixKg) {
    this.prixKg = prixKg;
  }

  public void setQte(float qte) {
    this.qte = qte;
  }

  public Vente() {

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


  public Vente(Integer id, User user, String legume, double prixKg, double qte) {
    super();
    this.id = id;
    this.user = user;
    this.legume = legume;
    this.prixKg = prixKg;
    this.qte = qte;
    this.totalprix = this.qte * this.prixKg;
  }

  public double getPrixKg() {
    return prixKg;
  }

  public double getQte() {
    return qte;
  }

}
