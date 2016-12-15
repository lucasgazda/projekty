
public class User {

	private String user;
	private String password;
	private String role;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		if(role.matches("(administrator|user)"))
		{
			this.role = role;
		}
		else
		{
			System.out.println("Incorrect role");
			this.role = "user";
		}
	}

	public User() {
		
	}

	public User(String user, String password, String role) {
		this.user = user;
		this.password = password;
		setRole(role);
	}

	@Override
		public String toString() {
			String text = "";
			text += "USER = " + getUser() + "\n";
			text += "PASSWORD = " + getPassword() + "\n";
			text += "ROLE = " + getRole() + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
