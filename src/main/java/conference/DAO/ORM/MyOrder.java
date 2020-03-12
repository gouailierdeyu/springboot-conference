package conference.DAO.ORM;

import java.math.BigDecimal;

public class MyOrder {
    private int id;
    private String orderId;
    private String orderSubject;
    private String orderBody;
    private BigDecimal amount;
    private String sellerId;
    private String payNo;
    private String status;
    private BigDecimal refundMoney;
    private String createTime;
    private String updateTime;
    private String userEmail;
    private String conferenceName;

    public MyOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderSubject() {
        return orderSubject;
    }

    public void setOrderSubject(String orderSubject) {
        this.orderSubject = orderSubject;
    }

    public String getOrderBody() {
        return orderBody;
    }

    public void setOrderBody(String orderBody) {
        this.orderBody = orderBody;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
        return "MyOrder{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", orderSubject='" + orderSubject + '\'' +
                ", orderBody='" + orderBody + '\'' +
                ", amount=" + amount +
                ", sellerId='" + sellerId + '\'' +
                ", payNo='" + payNo + '\'' +
                ", status='" + status + '\'' +
                ", refundMoney=" + refundMoney +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", conferenceName='" + conferenceName + '\'' +
                '}';
    }
}
