package cc.tinker.entity;

/**
 * @author Eagle on 2018/3/27.
 * 接收前端参数
 */

public class KindlePushRequest {

    private String emailAddress;
    private String fileUrl;
    private String filePath;


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
