package com.petworkouts.apiuser.reporsitory;

import com.petworkouts.apiuser.domain.entity.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends CrudRepository<Owner,Integer> {
    @Query(value = "select * from public.owner where document = ?", nativeQuery = true)
    List<Owner> findUserByDocument(int document);

//    @Query(value = "select d.id as id, d.document_type as document_type,d.document as document , d.name as name, d.last_name as last_name, d.gender as gender, " +
//            "d.phone as phone,d.email as email, d.register_type as register_type, d.password as password, d.active as active FROM public.user_pwo d", nativeQuery = true)
    @Query(value = "select * from public.owner ", nativeQuery = true)
    List<Owner> findByUserList();

    @Query(value = "select * from public.owner where email = ?", nativeQuery = true)
    Optional<Owner> findUserByEmail(String email);


}
