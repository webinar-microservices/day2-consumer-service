package in.webinar;

import java.util.List;

public class UserPost {

	private List<Post> postList;
	private int totalPosts;

	public UserPost() {
		super();
	}

	public UserPost(List<Post> postList, int totalPosts) {
		super();
		this.postList = postList;
		this.totalPosts = totalPosts;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}

}
