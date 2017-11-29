package be.unamur.vgnx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "utilisateurs")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class User implements Serializable {
  @Id
  @Column(nullable=false)
  @NotBlank
  private String pseudo;
  @Column(nullable=false)
  @NotBlank
  private String password;
  @Column(nullable = false)
  @NotBlank
  private String firstName;

  @Column(nullable = false)
  @NotBlank
  private String lastName;
  @Column(nullable = false)

  private double lattitude;

  @Column(nullable = false)
  private double longitude;

  @Column(nullable = false)
  private String numtel;
  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;
  @ElementCollection
  @JoinTable(name="User_achat")
  @JsonManagedReference
  @OneToMany(targetEntity=Achat.class, cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private List<Achat> achat = new ArrayList<>();
  @ElementCollection
  @JoinTable(name="User_vente")
  @JsonManagedReference
  @OneToMany(targetEntity=Vente.class, cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private List <Vente> vente = new ArrayList<>();
  @ElementCollection
  @JoinTable(name="User_echange")
  @JsonManagedReference
  @OneToMany(targetEntity=Echange.class, cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private List <Echange> echange = new ArrayList<>() ;

	public User() {
	}



  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User(String pseudo, String password, String fname, String lname, double lattitude, double longitude, String numtel) {
	  this.pseudo = pseudo;
	  this.password = password;
		this.firstName = fname;
    this.lastName = lname;
    this.lattitude = lattitude;
    this.longitude = longitude;
    this.numtel = numtel;
	}

  public List<Echange> getEchange() {
    return echange;
  }

  public void setEchange(List<Echange> echange) {
    this.echange = echange;
  }

  public double getLattitude() {
    return lattitude;
  }

  public String getNumtel() {
    return numtel;
  }

  public void setNumtel(String numtel) {
    this.numtel = numtel;
  }

  public void setLattitude(double lattitude) {
    this.lattitude = lattitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public List<Achat> getAchat() {
    return achat;
  }

  public void setAchat(List<Achat> achat) {

    this.achat = achat;
  }

  public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

  public List<Vente> getVente() {
    return vente;
  }

  public void setVente(List<Vente> vente) {


	  this.vente = vente;
  }


}
