package conference.DAO.ORM;

import java.io.Serializable;
import java.util.List;

public class MyUser implements Serializable {

    private int id;
    private String userEmail;
    private String password;
    private String realName;
    private String companyName;
    private String job;
    private String headImgUrl;

    private List<Conference> conferenceList;
    private List<Message> messageList;
    private List<MyOrder> myOrderList;
    private List<Paper> paperList;
    private List<TicketDetail> ticketDetailList;

    public MyUser() {
    }

    public MyUser(String userEmail, String realName, String  password) {
        this.userEmail = userEmail;
        this.password = password;
        this.realName = realName;
    }

    public MyUser(String realName, String headImgUrl) {
        this.realName = realName;
        this.headImgUrl = headImgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public List<Conference> getConferenceList() {
        return conferenceList;
    }

    public void setConferenceList(List<Conference> conferenceList) {
        this.conferenceList = conferenceList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<MyOrder> getMyOrderList() {
        return myOrderList;
    }

    public void setMyOrderList(List<MyOrder> myOrderList) {
        this.myOrderList = myOrderList;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public List<TicketDetail> getTicketDetailList() {
        return ticketDetailList;
    }

    public void setTicketDetailList(List<TicketDetail> ticketDetailList) {
        this.ticketDetailList = ticketDetailList;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", job='" + job + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                '}';
    }
}
