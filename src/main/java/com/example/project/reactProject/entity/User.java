package com.example.project.reactProject.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String email;
	private LocalDate regDate;
    private boolean isDeleted;
    private String profile;
    private String github;
    private String insta;
    private String location;
	
}