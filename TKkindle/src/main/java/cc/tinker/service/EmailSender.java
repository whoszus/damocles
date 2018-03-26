package cc.tinker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by Tinker on 3/26/2018.
 */
@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("whoszus@126.com");
        helper.setTo("yeqinglyy_31@kindle.cn");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("I:\\Book&Listening\\kindle人电子书合集\\kindleren自制\\ZZ41-42\\废都 非删节.mobi"));
        helper.addAttachment("废都 非删节.mobi", file);
//        helper.addAttachment("附件-2.png", file);

        mailSender.send(mimeMessage);

    }
}
