package com.adour.openclassprog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 13/07/2026 - 16:00
 */
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async // Runs in the background so the user doesn't wait for the email to send
    public void sendTicketNotification(String recipientEmail, String ticketNo, String title) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("jarisibertech@gmail.com");
            message.setTo(recipientEmail);
            message.setSubject("New Ticket Created: " + ticketNo);
            message.setText("Hello,\n\nA new ticket has been created for you.\n\n" +
                    "Ticket Number : " + ticketNo + "\n" +
                    "Title         : " + title + "\n\n" +
                    "We will approve your ticket shortly. We appreciate your patience during this process." + "\n\n" +
                    "Please do not hesitate to contact us if you have any questions." +
                    "Thank you." + "\n\n" +
                    "IT Support");

            mailSender.send(message);
            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
    @Async
    public void sendCloseTicketNotification(String recipientEmail, String ticketNo, String title) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("openclass.prg@gmail.com");
            message.setTo(recipientEmail);
            // Set the strict closed subject line
            message.setSubject("Ticket Closed: " + title);
            // Custom body message for resolution
            message.setText("Hello,\n\nThe following ticket has been successfully closed and resolved.\n\n" +
                    "Ticket Number : " + ticketNo + "\n" +
                    "Title         : " + title + "\n\n" +
                    "No further action is required from your end." + "\n\n" +
                    "Thank you." + "\n\n" +
                    "IT Support");

            mailSender.send(message);
            System.out.println("Resolution email sent successfully to " + recipientEmail);
        } catch (Exception e) {
            System.err.println("Failed to send close ticket email: " + e.getMessage());
        }
    }
}
