package example.restful;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response;  
import javax.ws.rs.Produces;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;  
import javax.ws.rs.core.MediaType;
import Pet.java;
import jdk.nashorn.internal.objects.annotations.Getter;  

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@Path("/hello")  
public class Hello {  
 

  /**  
   * 
   * Accepts ping for initial connection
   * Populates a list with existing database
   * 
  */
  @Get
  @Consumes(MediaType.TEXT_PLAIN)
  public void populateData(char ping)
  {

      FileReader reader = new FileReader("petDB.json");
      Object obj = jsonParser.parse(reader);

      JSONArray petList = (JSONArray) obj;


  }
  // called when request sends a PUT with JSON data  
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)  
  public String received_JSON_PUT(String msg) {  
    return "PUT: got a JSON file "+msg+"\n";  
  }  
  // called when request sends a POST with JSON data and 
  // must return more interesting response
  //@POST
  //@Consumes(MediaType.APPLICATION_JSON)  
  //public Response received_JSON_POST(String msg) { 
   // if (!msg.isEmpty()) 
    //{
      //String mymessage = "POST: got a JSON file " + msg + "\n";
      //return Response.status(200).entity(mymessage).build();
    //}
   //else {
      //return Response.status(Response.Status.NOT_FOUND).entity("Null String Received\n\n").build();
   //}
  //}

    // called when request sends a POST with JSON Pet data
    // and will return a response to confirm the file was received
   @POST
   @Path("/pet")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response received_Pet_Posting(String msg)
   {
      if(!msg.isEmpty())
      {
        String mymessage = "POST: got a Pet JSON Object file " + msg + "\n";
        FileReader reader = new FileReader("petDB.json");
        Object obj = jsonParser.parse(reader);

        JSONArray petList = (JSONArray) obj;
        JsonObject jsonObj = new JsonObject(msg);

      }
      else
      {
        return Response.status(Response.Status.NOT_FOUND).entity("Null String Received\n\n").build();
      }




      return Response.status(200).entity(mymessage).build();

   }
    
}  

