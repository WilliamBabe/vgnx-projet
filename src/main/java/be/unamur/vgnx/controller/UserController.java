package be.unamur.vgnx.controller;

import be.unamur.vgnx.entity.Achat;
import be.unamur.vgnx.entity.Echange;
import be.unamur.vgnx.entity.User;
import be.unamur.vgnx.entity.Vente;
import be.unamur.vgnx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	// Get All Users
  @GetMapping("/users")
  public List<User> getAllUsers() {
 return userService.findAll();
  }

	// Create a new User
  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userService.save(user);
  }
  // Create a new Achat
  //@PostMapping("/users/{id}")
  //public User createUser(@Valid @RequestBody User user) {
  //  return userService.save(user);
  //}
  @PostMapping("/users/{id}")
  public User updateUser2(@PathVariable(value = "id") String userId,
                                         @Valid @RequestBody User userDetails) {
    User updatedUser = userService.updateUser(userId, userDetails);
    return userService.updateUser(userId,updatedUser);
  }
	// Get a Single User
  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userId) {
    User user = userService.findOne(userId);
    if(user == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(user);
  }
  // Get list<Achat> d'un client
  @GetMapping("/users/{id}/achat")
  public ResponseEntity<List<Achat>> getAchatByPseudo(@PathVariable(value="id") String userId){
    User user = userService.findOne(userId);
    if(user == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(user.getAchat());

  }
  @GetMapping("/users/{id}/vente")
  public ResponseEntity<List<Vente>> getVenteByPseudo(@PathVariable(value="id") String userId){
    User user = userService.findOne(userId);
    if(user == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(user.getVente());

  }
  @GetMapping("/users/{id}/echange")
  public ResponseEntity<List<Echange>> getEchangeByPseudo(@PathVariable(value="id") String userId){
    User user = userService.findOne(userId);
    if(user == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(user.getEchange());

  }
	// Update a User
  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId,
                                         @Valid @RequestBody User userDetails) {
    User updatedUser = userService.updateUser(userId, userDetails);
    if(updatedUser == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(updatedUser);
  }
  
	// Delete a User
  @DeleteMapping("/users/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable(value = "id") String userId) {
    boolean userDeleted = userService.deleteUser(userId);
    if(!userDeleted) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/users/{id}/achat/{idachat}")
  public ResponseEntity<User> deleteAchat(@PathVariable(value = "id") String userId, @PathVariable (value = "idachat") Integer achatId ) {
    boolean AchatDeleted = userService.deleteAchat(achatId);
    if(!AchatDeleted) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/users/{id}/vente/{idvente}")
  public ResponseEntity<User> deleteVente(@PathVariable(value = "id") String userId, @PathVariable (value = "idvente") Integer venteId ) {
    boolean VenteDeleted = userService.deleteVente(venteId);
    if(!VenteDeleted) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
  }
  @DeleteMapping("/users/{id}/echange/{idechange}")
  public ResponseEntity<User> deleteEchange(@PathVariable(value = "id") String userId, @PathVariable (value = "idechange") Integer echangeId ) {
    boolean EchangeDeleted = userService.deleteEchange(echangeId);
    if(!EchangeDeleted) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
  }



}
