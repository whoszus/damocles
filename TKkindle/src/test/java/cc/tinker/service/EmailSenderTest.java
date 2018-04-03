package cc.tinker.service;

import cc.tinker.tools.restrofitTools.JsonResponse;
import cc.tinker.tools.restrofitTools.RestrofitTools;
import cc.tinker.tools.restrofitTools.RetrofitFactory;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import retrofit2.Call;

import static org.junit.Assert.*;

/**
 * Created by Tinker on 3/26/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailSender emailSender;
    private static final String pushUrl = "http://localhost:8080/tinker/kindle/push/file/";

    @Test
    public void sendAttachmentsMail() throws Exception {
        RestrofitTools restrofitTools = RetrofitFactory.create(pushUrl, RestrofitTools.class);
        Call<JsonResponse> jsonResponseCall = restrofitTools.pushFileToKindle("E:\\资治通鉴-胡三省.mobi", "yeqinglyy_31@kindle.cn");

    }

}