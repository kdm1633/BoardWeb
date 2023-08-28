package com.ssamz.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssamz.web.controller.board.DeletePostController;
import com.ssamz.web.controller.board.GetPostController;
import com.ssamz.web.controller.board.GetPostListController;
import com.ssamz.web.controller.board.InsertPostController;
import com.ssamz.web.controller.board.InsertPostViewController;
import com.ssamz.web.controller.board.LogoutController;
import com.ssamz.web.controller.board.UpdatePostController;
import com.ssamz.web.controller.user.InsertUserController;
import com.ssamz.web.controller.user.InsertUserViewController;
import com.ssamz.web.controller.user.LoginController;
import com.ssamz.web.controller.user.LoginViewController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/insertUserView.do", new InsertUserViewController());
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/loginView.do", new LoginViewController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/getPostList.do", new GetPostListController());
		mappings.put("/getPost.do", new GetPostController());
		mappings.put("/insertPostView.do", new InsertPostViewController());
		mappings.put("/insertPost.do", new InsertPostController());
		mappings.put("/updatePost.do", new UpdatePostController());
		mappings.put("/deletePost.do", new DeletePostController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
