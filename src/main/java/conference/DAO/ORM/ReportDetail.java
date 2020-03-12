package conference.DAO.ORM;

public class ReportDetail {
    private int id;
    private String inputValue;
    private String insertTime;
    private String conferenceName;
    private String userEmail;
    private String orderId;
    private String statue;

    public ReportDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    @Override
    public String toString() {
        return "ReportDetail{" +
                "id=" + id +
                ", inputValue='" + inputValue + '\'' +
                ", insertTime='" + insertTime + '\'' +
                ", conferenceName='" + conferenceName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", orderId='" + orderId + '\'' +
                ", statue='" + statue + '\'' +
                '}';
    }
}
