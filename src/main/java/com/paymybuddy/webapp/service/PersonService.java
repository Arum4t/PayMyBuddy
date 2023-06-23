package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.model.specific.PersonData;
import com.paymybuddy.webapp.repository.PersonRepository;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public void register(PersonData personData) throws Exception {

        if(checkIfUserExist(personData.getEmail())) {
            throw new Exception("User already exists for this email");
        }
        Person person = new Person();
        BeanUtils.copyProperties(personData, person);
        encodePassword(person, personData);
        person.setRole("user");
        personRepository.save(person);
        Wallet wallet = new Wallet();
        wallet.setAmount(0);
        wallet.setIdPerson(person);
        walletRepository.save(wallet);
    }
    @Override
    public boolean checkIfUserExist(String email) {
        return personRepository.findByEmail(email) != null;
    }
    @Override
    public void encodePassword( Person person, PersonData user){
        person.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    @Override
    public Integer getPersonIdByEmail(String email){
        Person person = personRepository.findByEmail(email);
        return person.getIdPerson();
    }
    @Override
    public void updateEmailUser(String newEmail,Integer userId){
        Person user = personRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("Person", "Id", userId)
        );
        if(!Objects.equals(newEmail, user.getEmail())){
            user.setEmail(newEmail);
            personRepository.save(user);
        }
    }
    @Override
    public void updatePasswordUser(String newPassword, Integer userId){
        Person user = personRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("Person", "Id", userId)
        );
        if(!Objects.equals(newPassword, user.getEmail())){
            user.setPassword(passwordEncoder.encode(newPassword));
            personRepository.save(user);
        }
    }
}

