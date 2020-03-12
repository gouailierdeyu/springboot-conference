package conference.DAO.ORM;

public class Report {
    private int id;
    private String inputKey;
    private String category;
    private String insertTime;
    private String conferenceName;

    public Report() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputKey() {
        return inputKey;
    }

    public void setInputKey(String inputKey) {
        this.inputKey = inputKey;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", inputKey='" + inputKey + '\'' +
                ", category='" + category + '\'' +
                ", insertTime='" + insertTime + '\'' +
                ", conferenceName='" + conferenceName + '\'' +
                '}';
    }
}
