package com.petworkouts.apiuser.controllers;

import com.petworkouts.apiuser.domain.entity.Owner;
import com.petworkouts.apiuser.response.CustomResponse;
import com.petworkouts.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Object> getAllUsers() {
        return Collections.singletonList(userService.getAllUserPerson());
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Object> getByDocument(@PathVariable int personId) {
        ResponseEntity<Object> response;
        try{
            List<Owner> usersPwO = userService.getUserByPersonId(personId);
            CustomResponse customResponse = new CustomResponse("Consulta del usuario exitosa: " + personId, HttpStatus.OK);
            customResponse.setResults(usersPwO);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
//            System.out.println("Valor de UsersPwo: " + usersPwO);
        } catch (Exception e) {
            response = new ResponseEntity<>("No se pudo encontrar el usuario con la cédula: " + personId, HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email) {
        ResponseEntity<Object> response;
        try{
            Optional<Owner> UsersPwo = userService.getUserByEmail(email);
            CustomResponse customResponse = new CustomResponse("Consulta del usuario exitosa: " + email, HttpStatus.OK);
            customResponse.setResults(UsersPwo);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>("No se pudo encontrar el usuario con el email: " + email, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody Owner newOwner) {
        ResponseEntity<Object> response;
        try{
            userService.saveUserPwO(newOwner);
            CustomResponse customResponse = new CustomResponse("Creacion del usuario fue exitosa", HttpStatus.OK);
            customResponse.setResults(newOwner);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);


        } catch (Exception e) {
            response = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el usuario" + newOwner, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
            userService.deleteUserPwO(id);
    }


    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody Owner updateOwner){
        ResponseEntity<Object> response;
        try{
            userService.saveUserPwO(updateOwner);
            CustomResponse customResponse = new CustomResponse("Actualizacion del usuario fue exitosa", HttpStatus.OK);
            customResponse.setResults(updateOwner);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);


        } catch (Exception e) {
            response = new ResponseEntity<>("Disculpa tenemos un error tratando de actualizar el usuario" + updateOwner, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateUserByFields(@PathVariable int id, @RequestBody Map<String, Object> fields){
        ResponseEntity<Object> response;
        try{
            userService.updateUserByFields(id,fields);
            CustomResponse customResponse = new CustomResponse(
                    "La actualización del id:" + id + " y los siguientes campos "
                            + fields + " fue exitosa", HttpStatus.OK);
            customResponse.setResults(fields);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        }catch (Exception e) {
            response = new ResponseEntity<>("El usuario con id:"+id+" o campo a modificar no existe", HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}