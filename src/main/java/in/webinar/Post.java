package in.webinar;

public class Post {

	private int id;
	private String postData;
	private int userid;

	public Post() {
		super();
	}

	public Post(int id, String postData, int userid) {
		super();
		this.id = id;
		this.postData = postData;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
