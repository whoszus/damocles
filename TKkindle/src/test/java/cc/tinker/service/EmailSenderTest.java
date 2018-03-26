package cc.tinker.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;

import static org.junit.Assert.*;

/**
 * Created by Tinker on 3/26/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailSender emailSender;

    @Test
    public void sendAttachmentsMail() throws Exception {
        emailSender.sendAttachmentsMail();
    }

}