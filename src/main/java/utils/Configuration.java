package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Configuration {

	// The Properties class represents a persistent set of properties.
	
	// This is a default Constructor
	// Why I am putting loadProperty () method inside constructor
	// because when Configuration class is instantiated (means when it will create
	// object)
	// then default Constructor will be initialized, the method loadproperty()
	// present inside the Constructor will also be initialized,
	// and help to load the config.properties file
	
private final static String FILE_NAME=("config.properties");
	

	private String url;
	private String dburl;
	private String dbuser;
	private String dbpass;

	public Configuration() {
		loadProperties();
	}
	private void loadProperties() {
		 Properties properties = new Properties();
		InputStream istream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
try {
	properties.load(istream);
	url =properties.getProperty(ConstantKey.BASE_URL.getKey());
	dburl =properties.getProperty(ConstantKey.DB_URL.getKey());
	dbuser =properties.getProperty(ConstantKey.DB_USER.getKey());
	dbpass =properties.getProperty(ConstantKey.DB_PASS.getKey());
}
catch (IOException e) {
	
	e.printStackTrace();
}
	}

	public String getUrl() {
		return url;
	}

	public String getBdurl() {
		return dburl;
	}

	public String getBduser() {
		return dbuser;
	}

	public String getBdpass() {
		return dbpass;
	}

}
