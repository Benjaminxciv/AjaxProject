import Pet.java;

import java.io.*;

import javax.ws.rs.core.Response;  
import javax.ws.rs.core.MediaType;  

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;

import javax.ws.rs.client.Client;  
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Entity;  
      // This entity class encapsulates message entities 
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.MediaType;

public class myClient {  
  
   public static void main(String [] args) throws Exception {  


      Client client=ClientBuilder.newClient();
      WebTarget theURL = client.target("http://localhost:8080/myrestful/restful/hello");

      InputStreamReader r = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(r);

      String mediaType="";
      String thestuff= "";

      System.out.println("Enter (G)ET,(P)UT,or P(O)ST");
      String message=br.readLine();
      if (message.equals("G") )
        {
          System.out.println("Enter (P)lainText, (H)tml, (X)ML");
          message=br.readLine();
          if (message.equals("X") ) // XML
             mediaType=MediaType.TEXT_XML;
          else if (message.equals("H")  )  // HTML
            mediaType=MediaType.TEXT_HTML;
          else // default to plain text
          {
             mediaType=MediaType.TEXT_PLAIN;
          }
         Response theGetResponse=theURL.request(mediaType).get();
         thestuff = theGetResponse.readEntity(String.class);
        }
      else if ( message.equals("P") )
        {    // PUT


       // The following shows two different ways to send JSON data.
       // Send it as a string, or create a JsonObject (using the 
       // JSON API) and send it that way.  Comment out whichever
       // you don't need
       //  String payload = "{ \"firstName\":\"Joe\", \"lastName\":\"Blow\", \"education\":{\"bachelors\":\"BSCS\",\"masters\":\"MSCS\"}, \"employer\":\"ACME Software\" }";

        JsonObject payload = Json.createObjectBuilder().add("hi","there").build();

         mediaType=MediaType.APPLICATION_JSON;

         // Create a message entity containing the payload data and 
         // the media type
         Entity myentity = Entity.entity(payload,mediaType);

         Response thePutResponse=theURL.request().put(myentity);
         thestuff = thePutResponse.readEntity(String.class);
        }
      else if ( message.equals("O") )
         {   // POST
         File f = new File("./mydata");
         mediaType=MediaType.APPLICATION_JSON;
          
         // Create a message entity containing the file and 
         // the media type
         Entity myentity = Entity.entity(f,mediaType);
         
         Response thePostResponse=theURL.request().post(myentity);
         thestuff = thePostResponse.readEntity(String.class);
        }
      else
          System.out.println("error in input\n");


      System.out.println(thestuff);

  }  
}  
