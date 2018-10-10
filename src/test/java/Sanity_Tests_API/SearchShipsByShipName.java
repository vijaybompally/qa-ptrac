package Sanity_Tests_API;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptrac.qa.baseclass.PTRAC_API_TestBase;
import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.utilities.Utilities;
import com.ptrac.qa.utilities.WebServices;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SearchShipsByShipName extends PTRAC_TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	SearchShipsByShipName() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiSanTestDataFile, "ShipName");
		String ship_name=(String) data[0][2];
		api=baseURL+"/api/v1/sisship?"+"ship_name__istartswith=="+ship_name+"&api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		System.out.println(api);
		response=WebServices.Get(api);
		jsonPathEvaluator = response.jsonPath();
	}

	@Test
	void SearchShipsByShipName() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode(response);
		getResponseTime(response);
		getShipIDs();
		getResponse(response);
	}

	void getShipIDs() throws IOException {
		String totalCount=""+jsonPathEvaluator.get("meta.total_count");
		addInfoToReport("Total Ship count: "+totalCount);
	}	
}