package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.dto.EmailDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 16/07/2026 - 9:52
 */
public interface EmailService {
    EmailDTO createEmail(EmailDTO emailDTO);
    EmailDTO getEmailById(Long id);
    List<EmailDTO> searchEmailByEmailAddress(String emailAddress);
    List<EmailDTO> getAllEmail();
    EmailDTO updateEmail(Long id, EmailDTO emailDTO);
    void deleteEmail(Long id);
}
