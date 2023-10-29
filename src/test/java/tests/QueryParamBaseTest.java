package tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.QueryParamSearchData;

public class QueryParamBaseTest
{
	
	public static final String QUERYPARAMKEY_TERM = "term";
	String url = "https://itunes.apple.com/search";
	
	public ObjectMapper mapper = new ObjectMapper();
	
	
	
	
	
	public QueryParamSearchData getTestData(String fileNameInSourcePath) throws Exception
	{
		return mapper.readValue(this.getClass().getClassLoader().getResourceAsStream(fileNameInSourcePath), QueryParamSearchData.class);
		
	}
	
	
	
	
	public Response performGet(String url, Map<String, String> paramMap) throws UnsupportedEncodingException
	{
		return RestAssured.given().
				//queryParams(parseInputQueryParamData(params))
				queryParams(paramMap)
			.when()
				.get(url)
			.then()
				.extract().response();
	}
	
	
	public Map<String, String> parseInputQueryParamData(String queryParams) throws UnsupportedEncodingException
	{
		Map<String, String> map = new HashMap<String, String>();
		
		for (String param : queryParams.split(","))
		{
			String key = param.split(":")[0];
			String val = param.split(":")[1];
			
			if (key.equalsIgnoreCase(QUERYPARAMKEY_TERM)) {
				key = key.replace(" ", "+");
			}
			URLEncoder.encode(key, StandardCharsets.UTF_8.toString());
			
			map.put(key, val);
		}
		
		return map;
	}
}
