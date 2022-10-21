package com.plb.projet.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plb.projet.model.Users;
import com.plb.projet.repository.UsersRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Users users = usersRepository.findByEmail(username);
             
      return UserDetailsImpl.build(users);
    }
}
