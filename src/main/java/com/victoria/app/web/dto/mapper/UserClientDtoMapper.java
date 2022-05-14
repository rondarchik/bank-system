package com.victoria.app.web.dto.mapper;

import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.Role;
import com.victoria.app.core.model.User;
import com.victoria.app.core.repository.BankRepository;
import com.victoria.app.core.repository.CompanyRepository;
import com.victoria.app.web.dto.UserClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserClientDtoMapper {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private CompanyRepository companyRepository;

   public User mapToUser(UserClientDto userClientDto){
       User user = new User();

       user.setLogin(userClientDto.getLogin());
       user.setPassword(userClientDto.getPassword());
       user.setRole(Role.CLIENT);

        return user;
    }

    public Client mapToClient(UserClientDto userClientDto){
        Client client = new Client();

        client.setSurname(userClientDto.getSurname());
        client.setName(userClientDto.getName());
        client.setLastname(userClientDto.getLastname());
        client.setPassportId(userClientDto.getPassportId());
        client.setIdentityNumber(userClientDto.getIdentityNumber());
        client.setTelephone(userClientDto.getTelephoneNumber());
        client.setEmail(userClientDto.getEmail());


        client.setCompany(companyRepository.getCompanyByName(userClientDto.getCompany()));
        client.setBanks(Collections.singletonList(bankRepository.getBankByName(userClientDto.getBank())));
        return client;
    }
}
