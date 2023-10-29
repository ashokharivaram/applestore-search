package tests;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.InValidData;
import pojos.QueryParamSearchData;
import pojos.ValidData;

public class QueryParamCallbackTests extends QueryParamBaseTest
{
	
	public static final String PARAMTESTDATA_CALLBACK = "callbackData.json";
	
	@Test
	public void test_queryParam_callback_valid() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		
		QueryParamSearchData rawData = getTestData(PARAMTESTDATA_CALLBACK);
		
		for (ValidData validData : rawData.getValidData())
		{
			HashMap paramMap = mapper.convertValue(validData.getData(), HashMap.class);
			
			Response res = performGet(url, paramMap);
			
			System.out.println(paramMap);
			System.out.println(res.statusLine());
			
			softAssert.assertEquals(String.valueOf(res.statusCode()), validData.getStatusCode(), "pararms: ["+ paramMap +"]");
			
			JsonPath j = new JsonPath(res.asString());
			int s = j.getInt("results.size()");
			
			for(int i = 0; i < s; i++) {
				String nodeText = j.getString("results["+ i +"]");
				String termValue = paramMap.get(QUERYPARAMKEY_TERM).toString();
				softAssert.assertTrue(nodeText.toLowerCase().contains(termValue.toLowerCase()),
								"expected: ["+ termValue.toLowerCase() +"] in actual: ["+ nodeText.toLowerCase() +"]");
			}
			
			
		}
		
		softAssert.assertAll();
		System.out.println("Done");
	}
	
	@Test
	public void test_queryParam_callback_invalid() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		
		QueryParamSearchData rawData = getTestData(PARAMTESTDATA_CALLBACK);
		
		for (InValidData invalidData : rawData.getInValidData())
		{
			HashMap paramMap = mapper.convertValue(invalidData.getData(), HashMap.class);
			
			Response res = performGet(url, paramMap);
			
			System.out.println(paramMap);
			System.out.println(res.statusLine());
			
			softAssert.assertEquals(String.valueOf(res.statusCode()), invalidData.getStatusCode(), "pararms: ["+ paramMap +"]");
			
		}
		
		softAssert.assertAll();
		System.out.println("Done");
	}
	
	
}
