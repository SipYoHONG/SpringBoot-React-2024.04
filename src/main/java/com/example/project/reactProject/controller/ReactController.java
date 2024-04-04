package com.example.project.reactProject.controller;

import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.reactProject.entity.User;
import com.example.project.reactProject.Service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController			// rendering 하지 않고, 데이터를 보내는 (@Controller에 @ResponseBody가 추가) 형태입니다!
@RequestMapping("/react")
@RequiredArgsConstructor
public class ReactController {
	private final UserService uSvc;
	
	@GetMapping("/data")
	public String data() {
		return "스프링부트에서 보낸 데이터";
	}
	
	@GetMapping("/json")
	public String json() {
		JSONObject jObj = new JSONObject();
		jObj.put("uid", "james");
		jObj.put("uname", "제임스");
		return jObj.toString();
	}
	@PostMapping("/form")
	public String form(String uid, String uname) {
		System.out.println("uid=" + uid + ", uname=" + uname);
		return "uid=" + uid + ", uname=" + uname;
	}
	
	@PostMapping("/multi")
	public String form(String uid, String uname, MultipartFile file) {
		String msg = "uid=" + uid + ", uname=" + uname + ", fname=" + file.getOriginalFilename();
		System.out.println(msg);
		return msg;
	}
	
	@GetMapping("/users")
	public String users() {
		List<User> list = uSvc.getUserList(1);
		JSONObject jObj = new JSONObject();
		JSONArray jArr = new JSONArray();
		for (User user: list) {
			JSONObject jUser = new JSONObject();
			jUser.put("uid", user.getUid());
			jUser.put("pwd", user.getPwd());
			jUser.put("uname", user.getUname());
			jUser.put("email", user.getEmail());
			jUser.put("regDate", user.getRegDate().toString());
			jUser.put("profile", user.getProfile());
			jUser.put("github", user.getGithub());
			jUser.put("insta", user.getInsta());
			jUser.put("location", user.getLocation());
			jArr.add(jUser);
		} 
		return jArr.toString();
	}
	
	@PostMapping("/cookie")
	public String cookie(String uid, String uname, HttpServletResponse resp) throws Exception {
		String msg = "uid=" + uid + ", uname=" + uname;
		String kmsg = URLEncoder.encode(msg, "utf-8");
		System.out.println(msg);
		Cookie ck = new Cookie("msg", kmsg);
		ck.setMaxAge(60*60);		// 1 시간
		resp.addCookie(ck);
		return msg;
	}
}
