package in.webinar;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/consumer")
public class ConsumerService {
	
	// singleton
	@Autowired
	private RestTemplate restTemplate;

	
	/**
	 * http://localhost:8082/consumer/
	 * @return
	 */
	@GetMapping("/")
	public String helloTest() {
		return "ConsumerService!!";
	}
	
	
	
	/**
	 * http://localhost:8082/consumer/combined/1
	 * @param userid
	 * @return
	 */
	@GetMapping("/combined/{userid}")
	public Map<String, Object> consumingProfileAndPostsServices(@PathVariable int userid) {

		// call to Profile Service
		String url = "http://localhost:8080/user/" + userid;
		User user = restTemplate.getForObject(url, User.class);
		
		// Call to Posts Service
		String url1 = "http://localhost:8081/posts/v1/" + userid;
		UserPost userPost =  restTemplate.getForObject(url1, UserPost.class);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("posts", userPost);
		
		
		return map;
	}
	
	
	
	
	
	/**
	 * http://localhost:8082/consumer/v1/1
	 * @param userid
	 * @return
	 */
	@GetMapping("/v1/{userid}")
	public User getProfileServiceV1(@PathVariable int userid) {
		
		String url = "http://localhost:8080/user/" + userid;
		User user =  restTemplate.getForObject(url, User.class);
		
		return user;
	}
	
	
	/**
	 * http://localhost:8082/consumer/v2/1
	 * @param userid
	 * @return
	 */
	@GetMapping("/v2/{userid}")
	public User getProfileServiceV2(@PathVariable int userid) {
		
		String url = "http://localhost:8080/user/" + userid;
		
		User user =  WebClient.builder().build()
							.get()
							.uri(url)
							.retrieve()
							.bodyToMono(User.class)
							.block();
		
		
		return user;
	}
	
	
	
	
	/**
	 * Call Profile Service :: Microservice 1
	 * http://localhost:8080/user/1
	 * 
	 * http://localhost:8082/consumer/{userid}
	 * http://localhost:8082/consumer/1
	 * http://localhost:8082/consumer/2
	 * @return
	 */
	@GetMapping("/{userid}")
	public User getProfileService(@PathVariable int userid) {
		RestTemplate restTemplateHardCode = new RestTemplate();
		
		String url = "http://localhost:8080/user/" + userid;
		User user =  restTemplateHardCode.getForObject(url, User.class);
		
		return user;
	}
	
	
	
	
}

















