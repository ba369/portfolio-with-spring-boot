package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            Model model) {

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(email);
            mail.setTo("yourrealemail@gmail.com");          // ← change to your email
            mail.setSubject("Portfolio Contact: " + name);
            mail.setText("From: " + name + " (" + email + ")\n\n" + message);

            mailSender.send(mail);
            model.addAttribute("success", true);

        } catch (Exception e) {
            // THIS LINE SHOWS THE REAL ERROR ON THE PAGE
            model.addAttribute("error", "Error: " + e.getMessage());
            e.printStackTrace(); // also prints full error in console
        }
        return "contact";
    }
}