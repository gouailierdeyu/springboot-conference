package conference.DAO.ORM;

import java.math.BigDecimal;

public class TicketDetail {
    private int id;
    private String name;
    private int sum;
    private BigDecimal price;
    private BigDecimal sumPrice;
    private String updateTime;
    private String orderId;
    private String payStatue;
    private String userEmail;
    private String conferenceName;

    public TicketDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayStatue() {
        return payStatue;
    }

    public void setPayStatue(String payStatue) {
        this.payStatue = payStatue;
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
        return "TicketDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                ", price=" + price +
                ", sumPrice=" + sumPrice +
                ", updateTime='" + updateTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", payStatue='" + payStatue + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", conferenceName='" + conferenceName + '\'' +
                '}';
    }
}
