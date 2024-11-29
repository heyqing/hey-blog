package top.heyqing.heyblog.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import top.heyqing.heyblog.model.dto.EmailDTO;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * ClassName:EmailUtil
 * Package:top.heyqing.heyblog.util
 * Description:
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailUtil {

    @Value("${spring.mail.username}")
    private String email;


    private final JavaMailSender javaMailSender;


    private final TemplateEngine templateEngine;

    public void sendHtmlMail(EmailDTO emailDTO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            Context context = new Context();
            context.setVariables(emailDTO.getCommentMap());
            String process = templateEngine.process(emailDTO.getTemplate(), context);
            mimeMessageHelper.setFrom(email);
            mimeMessageHelper.setTo(emailDTO.getEmail());
            mimeMessageHelper.setSubject(emailDTO.getSubject());
            mimeMessageHelper.setText(process, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
