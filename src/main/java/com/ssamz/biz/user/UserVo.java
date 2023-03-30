package com.ssamz.biz.user;

import lombok.Data;

@Data
public class UserVo {
	private String id;
	private String password;
	private String name;
	private String role;
}
