package pojo;

public class User {
		private String fname;
		private String lname;
    	private String username;
	    private String password;
	    private String email;
	    private String address1;
	    private String address2;
	    private String city;
	    private String state;
	    private String zip;
	    private String num;
	    
	    public String getUsername() {
	    	return username;
	    }
	    
	    public void setUsername(String username) {
	    	this.username = username;
	    }
	 
	    public String getPassword() {
	    	return password;
	    }
	 
	    public void setPassword(String password) {
	    	this.password = password;
	    }

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getNum() {
			return num;
		}

		public void setNum(String num) {
			this.num = num;
		}
}