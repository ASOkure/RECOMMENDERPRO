
//demographic information about users.
//user id | age | gender | occupation | zip code


public class Uuser {

	private int userId;
    private int age;
    private char gender;
    private String occupation;
    private int zipcode;

    public Uuser(int userId, int age, char gender, String occupation, int zipcode) {
		super();
		this.userId = userId;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipcode = zipcode;
	}
        
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


@Override
public String toString() {
	return "UserInfo [userId=" + userId + ", age=" + age + ", gender=" + gender + ", occupation=" + occupation
			+ ", zipcode=" + zipcode + "]";
}


}





	
	

