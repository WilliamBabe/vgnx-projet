package be.unamur.vgnx.service;

import be.unamur.vgnx.entity.Achat;
import be.unamur.vgnx.entity.Echange;
import be.unamur.vgnx.entity.User;
import be.unamur.vgnx.entity.Vente;
import be.unamur.vgnx.repository.AchatRepository;
import be.unamur.vgnx.repository.EchangeRepository;
import be.unamur.vgnx.repository.UserRepository;
import be.unamur.vgnx.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
  @Autowired
  private VenteRepository venteRepository;
  @Autowired
  private AchatRepository achatRepository;
  @Autowired
  private EchangeRepository echangeRepository;

	@Transactional
	@PostConstruct
	public void init() {
    // Add fake users
		 addFakeUsers();
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
	public List <Achat> findAchat(){return achatRepository.findAll();}
  public List <Achat> findAchatPseudo(String Pseudo){
	  User user = findOne(Pseudo);
	  List <Achat> achat = user.getAchat();
	  return achat;
  }

  public void addAchat (User user, Achat achat){


    user.getAchat().add(achat);
    updateUser(user.getPseudo(), user);
  }

  public void addvente(User user, Vente vente){
    user.getVente().add(vente);
    updateUser(user.getPseudo(), user);
  }

  public void addEchange(User user, Echange echange){
    user.getEchange().add(echange);
    updateUser(user.getPseudo(),user);
  }
	public User findOne(String pseudo) {
		return userRepository.findOne(pseudo);
	}
	public Achat findAchat(Integer id){return achatRepository.findOne(id);}
	public Vente findVente(Integer id){return venteRepository.findOne(id);}
	public Echange findEchange(Integer id){return echangeRepository.findOne(id);}
  public Achat save(Achat achat){return achatRepository.save(achat);}
  public User save(User user) {
    return userRepository.save(user);
  }



  public User updateUser(String pseudo, User userDetails) {
    User user = findOne(pseudo);

    String password= userDetails.getPassword();
    String lastName = userDetails.getLastName();
    String firstName = userDetails.getFirstName();
    double lattidude= userDetails.getLattitude();
    double longitude = userDetails.getLongitude();
    List <Achat> achat = userDetails.getAchat();
    List <Vente> vente = userDetails.getVente();
    List <Echange> echange = userDetails.getEchange();

    if(user == null) {
      return null;
    }

    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setPassword(password);
    user.setLattitude(lattidude);
    user.setLongitude(longitude);
    user.setAchat(achat);
    user.setVente(vente);
    user.setEchange(echange);
    System.out.println(user);

    return save(user);
  }

  public boolean deleteUser(String userId) {
    User user = findOne(userId);
    if(user == null) {
      return false;
    }
    userRepository.delete(user);
    return true;
  }

  public boolean deleteAchat( Integer Id){
    Achat achat = findAchat(Id);
    User user = findOne(achat.getUser().getPseudo());

    user.getAchat().remove(achat);
    updateUser(user.getPseudo(), user);
    achatRepository.delete(achat);
    return true;
  }

  public boolean deleteEchange(Integer Id){
    Echange echange = findEchange(Id);
    User user = findOne(echange.getUser().getPseudo());

    user.getEchange().remove(echange);
    updateUser(user.getPseudo(),user);
    echangeRepository.delete(echange);
    return true;
  }

  public boolean deleteVente(Integer Id){
    Vente vente = findVente(Id);
    User user = findOne(vente.getUser().getPseudo());

    user.getVente().remove(vente);
    updateUser(user.getPseudo(), user);
    venteRepository.delete(vente);
    return true;

  }




	private void addFakeUsers() {
    User user = new User("Remi","romus","Jean", "A", 72.4,74.2,"061235687");
    User user2 = new User("Vlad", "Romulus","Jean", "B",4.5,3.66,"047489635");
    Achat achat =  new Achat(0,user,"Tomate",2.5,200.52);
    Achat achat2 =  new Achat(220,user,"Salade",112.5,2.52);
    Achat achat3 = new Achat(220,user2,"Salade",112.5,2.52);
    Vente vente = new Vente(0,user,"canne",2.5,56);
    Vente vente2 = new Vente(0,user,"canneton",20.5,56);
    Vente vente3 = new Vente(0,user2,"canneman",27.5,5);
    Echange echange = new Echange(0, user, "canne", "cannard",2);
    userRepository.save(user);
    userRepository.save(user2);
    addAchat(user,achat);
    addvente(user,vente);
    addvente(user,vente2);
    addvente(user2,vente3);
    addEchange(user,echange);




		userRepository.save(new User("Vincent", "BOOTEN","Jean", "C",2.6,2.7,"0368265"));

	}
}
