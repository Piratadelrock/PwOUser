package com.petworkouts.apiuser.service;

import com.petworkouts.apiuser.domain.entity.UserPwO;
import com.petworkouts.apiuser.reporsitory.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

//    private final MessageSender<UserPwO> messageSenderClient;

//    public UserService(MessageSender<UserPwO> messageSenderClient) {
//        this.messageSenderClient = messageSenderClient;
//    }

    public List<UserPwO> getAllUserPerson(){
        return userRepository.findByUserList();
    }
    public List<UserPwO> getUserByPersonId(int personId){
        return userRepository.findUserByDocument(personId);
    }
//
    public Optional<UserPwO> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }


    public UserPwO saveUserPwO(UserPwO bodyUsers){
//        messageSenderClient.execute(bodyDiscapUsers, (bodyDiscapUsers.getPersonID().toString()));
        return userRepository.save(bodyUsers);
    }
//
    public void deleteUserPwO(int id){
        userRepository.deleteById(id);
    }
//
//    public UserPwO updateUserByFields(int id, Map<String, Object> fields) {
//        Optional<UserPwO> existingUser = userRepository.findById(id);
//        if(existingUser.isPresent()) {
//            fields.forEach((key, value) -> {
//                Field field = ReflectionUtils.findField(DiscapUser.class, key);
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, existingUser.get(), value);
//            });
//            return userRepository.save(existingUser.get());
//        }
//        return null;
//    }
}
