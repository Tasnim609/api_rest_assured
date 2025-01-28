package utils;

public enum ConstantKey  {
BASE_URL("base_url"),
DB_URL("db_url"),
DB_USER("db_user"),
DB_PASS("db_pass");
	
	String  key;

	private ConstantKey(String key) {
		this.key = key;
	}
	
	@Override
	public String toString() { //without this method we can  not get value
		return key;
	}
	/**
	 * Get the original key
	 * @return {@link #key}
	 */
	public String getKey() {
		return key;
	}
}
