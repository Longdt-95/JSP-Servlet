package javaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tclass)
	{
		try {
			return new ObjectMapper().readValue(value, tclass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static HttpUtil of(BufferedReader reader) 
	{
		  StringBuilder sb = new StringBuilder();
		    String line;
		    try {
				while ((line = reader.readLine()) != null) {
				    sb.append(line);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	return new HttpUtil(sb.toString());	
	}
}
