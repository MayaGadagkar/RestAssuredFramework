package endpoints;

public enum APIEndPoints {
	USERS("/users"),
	LOGIN("/login"),
	AUTH("/auth"),
	BOOKING("/booking");
	
	private final String path;
	
	APIEndPoints(String path)
	{
		this.path = path;
	}
	
	public String path()
	{
		return path;
	}

}
