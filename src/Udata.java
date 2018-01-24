// u.data is the  full dataset userid|itemid|ratings|timestamp
public class Udata {

	int userId;
	int itemId;
	int rating;
	int timestamp;
	
	public Udata(int userId, int itemId, int rating, int timestamp) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", itemId=" + itemId + ", rating=" + rating + ", timestamp=" + timestamp
				+ "]";
	}

	public int getAverageRating() {
		// TODO Auto-generated method stub
		return 0;
	}

}

	
	
	

