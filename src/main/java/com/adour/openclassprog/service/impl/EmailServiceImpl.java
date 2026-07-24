package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.EmailMap;
import com.adour.openclassprog.dto.EmailDTO;
import com.adour.openclassprog.model.Email;
import com.adour.openclassprog.repository.EmailRepository;
import com.adour.openclassprog.service.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/07/2026 - 9:55
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;
    private final EmailMap emailMap;

    public EmailServiceImpl(EmailRepository emailRepository, EmailMap emailMap) {
        this.emailRepository = emailRepository;
        this.emailMap = emailMap;
    }

    @Override
    public EmailDTO createEmail(EmailDTO emailDTO) {
        Email email = emailMap.toEntity(emailDTO);
        Email saveEmail = emailRepository.save(email);
        return emailMap.toDTO(saveEmail);
    }

    @Override
    public EmailDTO getEmailById(Long id) {
        Email getEmailId = emailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Email record not found with ID: " + id));
        return emailMap.toDTO(getEmailId);
    }

    @Override
    public List<EmailDTO> searchEmailByEmailAddress(String emailAddress) {
        List<Email> cariEmail = emailRepository.findByEmailContainingIgnoreCase(emailAddress);
        if (cariEmail.isEmpty()) {
            throw new NoSuchElementException("No email record found with name: " + emailAddress);
        }
        return cariEmail.stream()
                .map(emailMap::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDTO> getAllEmail() {
        List<Email> allEmail = emailRepository.findAllByOrderByIdDesc();
        return emailMap.toDTOList(allEmail);
    }

    @Override
    public EmailDTO updateEmail(Long id, EmailDTO emailDTO) {
        Email existingEmail = emailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Email record not found with ID: " + id));
        emailMap.updateEntityFromDTO(emailDTO, existingEmail);
        return emailMap.toDTO(emailRepository.save(existingEmail));
    }

    @Override
    public void deleteEmail(Long id) {
        if (!emailRepository.existsById(id)) {
            throw new NoSuchElementException("Email not found with id: " + id);
        }
        emailRepository.deleteById(id);
    }
}
