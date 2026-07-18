package com.adour.openclassprog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 13/07/2026 - 16:00
 */
@Service
public class EmailServiceConfig {
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
                    "We will approve your ticket shortly. We appreciate your patience during this process." + "\n" +
                    "Please do not hesitate to contact us if you have any questions." + "\n\n" +
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
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("openclass.prg@gmail.com", "IT Support Team");
            helper.setTo(recipientEmail);
            helper.setSubject("Ticket Resolved: [" + ticketNo + "] " + title);

            String htmlContent = "<html>" +
                    "<head>" +
                    "  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">" +
                    "  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>" +
                    "  <link href=\"https://fonts.googleapis.com/css2?family=Quicksand:wght@400;600;700&display=swap\" rel=\"stylesheet\">" +
                    "</head>" +
                    "<body>" +
                    "  <div style=\"font-family: 'Quicksand', sans-serif; line-height: 1.6; color: #333333; max-width: 500px; margin: 20px auto; border: 1px solid #e0e0e0; padding: 20px; border-radius: 5px;\">" +
                    "    <h2 style=\"color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 3px; margin: 2px 0 15px 0;\">Ticket Resolved</h2>" +
                    "    <p>Hello,</p>" +
                    "    <p>We are writing to inform you that your IT support request has been successfully resolved and closed.</p>" +
                    "    " +
                    "    <table style=\"width: 100%; border-collapse: collapse; background-color: #f9f9f9; font-family: 'Quicksand', sans-serif;\">" +
                    "      <tr>" +
                    "        <td style=\"padding: 1px; font-weight: bold; width: 20%;\">Ticket Number</td>" +
                    "        <td style=\"padding: 1px; font-weight: bold; width: 2%;\">:</td>" +
                    "        <td style=\"padding: 1px; font-family: monospace; font-size: 14px;\">" + ticketNo + "</td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td style=\"padding: 1px; font-weight: bold;\">Subject</td>" +
                    "        <td style=\"padding: 1px; font-weight: bold; width: 2%;\">:</td>" +
                    "        <td style=\"padding: 1px;\">" + title + "</td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td style=\"padding: 1px; font-weight: bold;\">Status</td>" +
                    "        <td style=\"padding: 1px; font-weight: bold; width: 2%;\">:</td>" +
                    "        <td style=\"padding: 1px;\"><span style=\"background-color: #2ecc71; color: white; padding: 3px 8px; border-radius: 3px; font-size: 12px; font-weight: bold;\">CLOSED</span></td>" +
                    "      </tr>" +
                    "    </table>" +
                    "    " +
                    "    <p>Thank you for your patience and cooperation while our team worked on this issue.</p>" +
                    "    <p style=\"font-size: 12px; color: #7f8c8d;\">Best regards,<br>" +
                    "    <strong>IT Support Helpdesk</strong><br>" +
                    "    OpenClass Hub</p>" +
                    "    <hr style=\"border: 0; border-top: 1px solid #e0e0e0; margin: 20px 0;\">" +
                    "    <p style=\"font-size: 11px; color: #7f8c8d; text-align: center;\">This email is generated automatically. Please do not send a response to this email.</p>" +
                    "  </div>" +
                    "</body>" +
                    "</html>";

            // The second parameter 'true' tells Spring to render it as HTML
            helper.setText(htmlContent, true);

            mailSender.send(message);
            System.out.println("Resolution email sent successfully to " + recipientEmail);
        } catch (Exception e) {
            System.err.println("Failed to send close ticket email: " + e.getMessage());
        }
    }
}
