package com.srmasset.manager.service;

import com.srmasset.manager.enums.DocumentIdentifier;
import com.srmasset.manager.model.User;
import com.srmasset.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        checkDocument(user);
        userRepository.save(user);
    }

    private void checkDocument(User user) {
        if (user.getDocumentIdentifier() == null) {
            if (user.getDocument().length() == 11) {
                user.setDocumentIdentifier(DocumentIdentifier.CPF);
            } else if (user.getDocument().length() == 14) {
                user.setDocumentIdentifier(DocumentIdentifier.CNPJ);
            } else {
                user.setDocumentIdentifier(DocumentIdentifier.OTHER);
            }
        }
    }

}
