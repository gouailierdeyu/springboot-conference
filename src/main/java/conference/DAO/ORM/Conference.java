package conference.DAO.ORM;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("conference")
public class Conference {
    @TableId("id")
    private int id;
    private String conferenceName;
    private String startTime;
    private String endTime;
    private String field;
    private String address;
    private String imageUrl;
    private String detail;
    private String userEmail;
    private String updateTime;
    private String topIndex;
    private String middleIndex;
    private String bottomIndex;
    @TableField("myshow")
    private Integer myShow;
    private String checkResult;

    public Conference() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTopIndex() {
        return topIndex;
    }

    public void setTopIndex(String topIndex) {
        this.topIndex = topIndex;
    }

    public String getMiddleIndex() {
        return middleIndex;
    }

    public void setMiddleIndex(String middleIndex) {
        this.middleIndex = middleIndex;
    }

    public String getBottomIndex() {
        return bottomIndex;
    }

    public void setBottomIndex(String bottomIndex) {
        this.bottomIndex = bottomIndex;
    }

    public Integer getMyShow() {
        return myShow;
    }

    public void setMyShow(Integer myShow) {
        this.myShow = myShow;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", conferenceName='" + conferenceName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", field='" + field + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", detail='" + detail + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", topIndex='" + topIndex + '\'' +
                ", myShow=" + myShow +
                '}';
    }
}
