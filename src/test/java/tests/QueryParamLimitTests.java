package tests;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.InValidData;
import pojos.QueryParamSearchData;
import pojos.ValidData;

public class QueryParamLimitTests extends QueryParamBaseTest
{
	
	public static final String PARAMTESTDATA_LIMIT = "limitData.json";
	
	@Test
	public void test_queryParam_limit_valid() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		
		QueryParamSearchData rawData = getTestData(PARAMTESTDATA_LIMIT);
		
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
			
			/*
			 * more assertions can be added
			 */
			System.out.println("Done");
			
		}
		
		softAssert.assertAll();
	}
	
	@Test
	public void test_queryParam_limit_invalid() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		
		QueryParamSearchData rawData = getTestData(PARAMTESTDATA_LIMIT);
		
		for (InValidData invalidData : rawData.getInValidData())
		{
			HashMap paramMap = mapper.convertValue(invalidData.getData(), HashMap.class);
			
			Response res = performGet(url, paramMap);
			
			System.out.println(paramMap);
			System.out.println(res.statusLine());
			
			softAssert.assertEquals(String.valueOf(res.statusCode()), invalidData.getStatusCode(), "pararms: ["+ paramMap +"]");
			/*
			 * more assertions can be added
			 */
			
		}
		
		softAssert.assertAll();
		System.out.println("Done");
	}
	
	
}