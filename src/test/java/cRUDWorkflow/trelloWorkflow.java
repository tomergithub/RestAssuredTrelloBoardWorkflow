package cRUDWorkflow;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class trelloWorkflow {
	public  String BoardID;
	public String List1ID;
	public String List2ID;
	public String List3ID;
	public String List4ID;
	public Object CardID;
	@Test(priority=1)
	public void createBoardReq1()
		{	
		    RestAssured.baseURI = "https://api.trello.com";  		    
		    JsonPath jsonPath=
	        given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
	        .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
	        .queryParam("name", "Automation Board24").queryParam("defaultLists", false)
	        .contentType(ContentType.JSON)
	        .when().post("/1/boards/")
	        .then().log().all().assertThat().statusCode(200).extract().jsonPath();
		    this.BoardID=jsonPath.get("id");        
	        
		}
	@Test(priority=4)
	public void createListReq1()
	{	
	    RestAssured.baseURI = "https://api.trello.com";    
	    JsonPath jsonPath=
        given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
        .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
        .queryParam("name", "To Do")
        .queryParam("idBoard", this.BoardID)
        .contentType(ContentType.JSON)
        .when().post("/1/lists")
        .then().log().all().assertThat().statusCode(200).extract().jsonPath();
	    this.List1ID=jsonPath.get("id");      
	}
	@Test(priority=3)
	public void createListReq2()
	{	
	    RestAssured.baseURI = "https://api.trello.com";    
	    JsonPath jsonPath= 
        given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
        .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
        .queryParam("name", "Doing")
        .queryParam("idBoard", this.BoardID)
        .contentType(ContentType.JSON)
        .when().post("/1/lists")
        .then().log().all().assertThat().statusCode(200).extract().jsonPath();
	    this.List2ID=jsonPath.get("id");            
	}
   @Test(priority=2)
	public void createListReq3()
		{	
	    RestAssured.baseURI = "https://api.trello.com";    
	    JsonPath jsonPath=
        given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")//Your Key
        .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")//Your Token
        .queryParam("name", "Done")
        .queryParam("idBoard", this.BoardID)//Your automation board Id
        .contentType(ContentType.JSON)
        .when().post("/1/lists")
        .then().log().all().assertThat().statusCode(200).extract().jsonPath();
	    this.List3ID=jsonPath.get("id");                  
	}
  @Test(priority=5)
	public void createListReq4()//"60f01d3f83c6785a4a631e1f"
	{	
	    RestAssured.baseURI = "https://api.trello.com";    
	    JsonPath jsonPath=
        given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
        .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
        .queryParam("name", "Backlog")
        .queryParam("idBoard", this.BoardID)
        .contentType(ContentType.JSON)
        .when().post("/1/lists")
        .then().log().all().assertThat().statusCode(200).extract().jsonPath();
	    this.List4ID=jsonPath.get("id");                
	}
  @Test(priority=6)
	public void createCardToDoList()
	{	
	    RestAssured.baseURI = "https://api.trello.com";    
       
      given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
      .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
      .queryParam("name", "Washing")
      .queryParam("idList", this.List1ID)
      .contentType(ContentType.JSON)
      .when().post("/1/cards")
      .then().log().all().assertThat().statusCode(200);      
	}
	@Test(priority=7)
	public void createCardDoingList()
	{	
	    RestAssured.baseURI = "https://api.trello.com";    
       
      given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
      .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
      .queryParam("name", "Ironing")
      .queryParam("idList", this.List2ID)
      .contentType(ContentType.JSON)
      .when().post("/1/cards")
      .then().log().all().assertThat().statusCode(200);      
	}
@Test(priority=8)
	public void createCardDoneList()
	{	
	    RestAssured.baseURI = "https://api.trello.com";    
       
      given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")//Your key
      .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")// Your token
      .queryParam("name", "Wardrobe")//name of card in the list
      .queryParam("idList", this.List3ID)//Your List id of DoneList
      .contentType(ContentType.JSON)
      .when().post("/1/cards") // Post Request
      .then().log().all().assertThat().statusCode(200);      
	}
	@Test(priority=9)
	public void createCardBacklogList() throws InterruptedException
	{	Thread.sleep(5000);
	    RestAssured.baseURI = "https://api.trello.com";    
       
      given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
      .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
      .queryParam("name", "Archive")
      .queryParam("idList", this.List4ID)
      .contentType(ContentType.JSON)
      .when().post("/1/cards")
      .then().log().all().assertThat().statusCode(200);      
	}
	@Test(priority=10)
	public void createCardDone2List() throws InterruptedException//60f047160e10b885e31474fa
	{	Thread.sleep(5000);
	    RestAssured.baseURI = "https://api.trello.com";    
	    JsonPath jsonPath=
      given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
      .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")
      .queryParam("name", "Homework")
      .queryParam("idList", this.List3ID)
      .contentType(ContentType.JSON)
      .when().post("/1/cards")
      .then().log().all().assertThat().statusCode(200).extract().jsonPath();
	   this.CardID=jsonPath.get("id");   	
	}
	@Test(priority=11)
	public void deleteBoard() throws InterruptedException
	{  
        //Thread.sleep(5000);		
		RestAssured.baseURI = "https://api.trello.com";   
	    given().log().all().queryParam("key", "da98f4b210e8907844125cef65cdab02")
	    .queryParam("token", "949c0fdbb4617791e9d69071ee81ebcc010d521a294d4908c605ccfcf9560e3d")	        	     
	    .contentType(ContentType.JSON)
	    .when().delete("/1/boards/{BoardID}", this.BoardID)	     
	    .then().log().all().assertThat().statusCode(200);   	
	}
		
}

