package at.fh.swenga.plavent.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class UserManager {
	
	private List<UserModel> users = new ArrayList<UserModel>();
	
	public UserManager() {
		// TODO Auto-generated constructor stub
	}
	
	public List<UserModel> getAllUsers() {
		return users;
	}
	
	public void addUser(UserModel newUser) {
		users.add(newUser);
	}
	
	public void removeUser(String username) {
		users.remove(new UserModel(username,null,null));
	}
	
	/**
	 * Returns user object with given username or null when not found
	 * @param username Username to identify user object
	 * @return null or userobject with given name
	 */
	public UserModel getUser(String username) {
		for(UserModel user: users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public List<UserModel> getFilteredUsers(String searchString) {
		List<UserModel> filteredList = new ArrayList<UserModel>();

		for (UserModel model : users) {
			if ((model.getUsername() != null && model.getUsername().contains(searchString))
					|| (model.getFirstname() != null && model.getFirstname().contains(searchString)) 
					|| (model.getLastname() != null && model.getLastname().contains(searchString)) ) {
				filteredList.add(model);
			}
		}
		return filteredList;
	}
}
