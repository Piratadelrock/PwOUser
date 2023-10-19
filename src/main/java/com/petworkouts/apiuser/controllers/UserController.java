package com.petworkouts.apiuser.controllers;

import com.petworkouts.apiuser.domain.entity.UserPwO;
import com.petworkouts.apiuser.response.CustomResponse;
import com.petworkouts.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
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
            List<UserPwO> usersPwO = userService.getUserByPersonId(personId);
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
            Optional<UserPwO> UsersPwo = userService.getUserByEmail(email);
            CustomResponse customResponse = new CustomResponse("Consulta del cliente exitosa: " + email, HttpStatus.OK);
            customResponse.setResults(UsersPwo);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>("No se pudo encontrar el cliente con el email: " + email, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
//
//    @PostMapping
//    public ResponseEntity<Object> newUser(@RequestBody UserPwO newUserPwO) {
//        ResponseEntity<Object> response;
//        try{
//            userService.saveUserPwO(newUserPwO);
//            CustomResponse customResponse = new CustomResponse("Creacion del cliente fue exitosa", HttpStatus.OK);
//            customResponse.setResults(newUserPwO);
//            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
//
//
//        } catch (Exception e) {
//            response = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el cliente" + newUserPwO, HttpStatus.BAD_REQUEST);
//        }
//        return response;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable int id) {
//
//            userService.deleteUserPwO(id);
//
//    }
//
//    @PutMapping
//    public ResponseEntity<Object> updateUser(@RequestBody UserPwO updateUserPwO){
//        ResponseEntity<Object> response;
//        try{
//            userService.saveUserPwO(updateUserPwO);
//            CustomResponse customResponse = new CustomResponse("Actualizacion del cliente fue exitosa", HttpStatus.OK);
//            customResponse.setResults(updateUserPwO);
//            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
//
//
//        } catch (Exception e) {
//            response = new ResponseEntity<>("Disculpa tenemos un error tratando de actualizar el cliente" + updateUserPwO, HttpStatus.BAD_REQUEST);
//        }
//        return response;
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Object> updateUserByFields(@PathVariable int id, @RequestBody Map<String, Object> fields){
//        ResponseEntity<Object> response;
//        try{
//            userService.updateUserByFields(id,fields);
//            CustomResponse customResponse = new CustomResponse(
//                    "La actualización del id:" + id + " y los siguientes campos "
//                            + fields + " fue exitosa", HttpStatus.OK);
//            customResponse.setResults(fields);
//            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
//        }catch (Exception e) {
//            response = new ResponseEntity<>("El usuario con id:"+id+" o campo a modificar no existe", HttpStatus.BAD_REQUEST);
//        }
//        return response;
//    }
}