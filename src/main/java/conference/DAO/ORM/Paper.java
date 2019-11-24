package conference.DAO.ORM;

public class Paper {
    private int id;
    private String paperName;
    private String paperAbstract;
    private String fileUrl;
    private String uploadTime;
    private String updateTime;
    private String isPass;
    private String checkResult;
    private String checkUser;
    private String userEmail;
    private String conferenceName;

    public Paper() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", paperName='" + paperName + '\'' +
                ", paperAbstract='" + paperAbstract + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isPass='" + isPass + '\'' +
                ", checkResult='" + checkResult + '\'' +
                ", checkUser='" + checkUser + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", conferenceName='" + conferenceName + '\'' +
                '}';
    }
}
