package com.petworkouts.apiuser.service;

import com.petworkouts.apiuser.domain.entity.Owner;
import com.petworkouts.apiuser.reporsitory.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

//    private final MessageSender<UserPwO> messageSenderClient;

//    public UserService(MessageSender<UserPwO> messageSenderClient) {
//        this.messageSenderClient = messageSenderClient;
//    }

    public List<Owner> getAllUserPerson(){
        return userRepository.findByUserList();
    }
    public List<Owner> getUserByPersonId(int personId){
        return userRepository.findUserByDocument(personId);
    }
//
    public Optional<Owner> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }


    public Owner saveUserPwO(Owner bodyUsers){
        return userRepository.save(bodyUsers);
    }
//
    public void deleteUserPwO(int id){
        userRepository.deleteById(id);
    }
//
    public Owner updateUserByFields(int id, Map<String, Object> fields) {
        Optional<Owner> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Owner.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return userRepository.save(existingUser.get());
        }
        return null;
    }
}
