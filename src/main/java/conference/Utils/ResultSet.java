package conference.Utils;

public class ResultSet<T> {
    private int code;
    private String message;
    private T data;

    public ResultSet(int code, String message, T object) {
        this.code = code;
        this.message = message;
        this.data = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
