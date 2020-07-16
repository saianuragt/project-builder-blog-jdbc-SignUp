package dao;

import model.User;

public interface UserDaoInterface{
	
	public void signUp(User user);
	public boolean loginUser(User user);
}