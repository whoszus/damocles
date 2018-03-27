package cc.tinker.controller;

import cc.tinker.service.EmailSender;
import cc.tinker.tools.restrofitTools.JsonResponse;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Map;

/**
 * @author Eagle on 2018/3/27.
 */
@RestController
@RequestMapping("/tinker/kindle")
public class KindleController {

    @Autowired
    private EmailSender emailSender;
    @Value("kindle.sender.subject")
    private String subject;
    @Value("kindle.sender.text")
    private String text;

    @RequestMapping("/push/file")
    public JsonResponse pushFileToKindle(String emailAddress, String filePath) {
        if (Strings.isNullOrEmpty(filePath)) {
            return JsonResponse.newError("filePath is null or empty");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return JsonResponse.newError("file don't exist");
        }
        Map<String, String> map = Maps.newHashMap();
        map.put(file.getName(), file.getAbsolutePath());
        emailSender.sendAttachmentsMailLocalFile(emailAddress, subject, text, map);
        return JsonResponse.newOk();
    }

    @RequestMapping("/push/http/{url}/{email}")
    public JsonResponse pushHttpFileToKindle(@NotNull @RequestParam(value = "httpUrl") String httpUrl, @NotNull @RequestParam(value = "email") String email) {
        if (Strings.isNullOrEmpty(httpUrl)) {
            return JsonResponse.newError("filePath is null or empty");
        }
        if (Strings.isNullOrEmpty(email)) {
            return JsonResponse.newError("email is empty");
        }
        emailSender.sendMailByFileUrl(email, subject, text, httpUrl);
        return JsonResponse.newOk();
    }
}
