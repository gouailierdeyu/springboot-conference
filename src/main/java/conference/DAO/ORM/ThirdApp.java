package conference.DAO.ORM;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/14 20:24
 */
public class ThirdApp {
	private String thirdName;

	private String thirdAppId;
	private String callback;

	public ThirdApp(String thirdName, String thirdAppId) {
		this.thirdName = thirdName;
		this.thirdAppId = thirdAppId;
	}

	public ThirdApp() {
	}

	public String getThirdName() {
		return thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	public String getThirdAppId() {
		return thirdAppId;
	}

	public void setThirdAppId(String thirdAppId) {
		this.thirdAppId = thirdAppId;
	}

	public ThirdApp(String thirdName, String thirdAppId, String callback) {
		this.thirdName = thirdName;
		this.thirdAppId = thirdAppId;
		this.callback = callback;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}
}
