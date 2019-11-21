import Pet.java;

import java.io.*;

import javax.ws.rs.core.Response;  
import javax.ws.rs.core.MediaType;  

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;

import java.util.ArrayList;

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
      //WebTarget theURL = client.target("http://localhost:8080/myrestful/restful/hello");

      InputStreamReader r = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(r);

      String mediaType="";
      String thestuff= "";

      System.out.println("Enter (P)ost new pet or (G)et pet info");
      String message=br.readLine();
      if (message.equals("P") )
        {
          WebTarget theURL = client.target("http://localhost:8080/myrestful/restful/hello");
          mediaType=MediaType.APPLICATION_JSON;
          System.out.println("Enter (A)ll info via JSON or (O)ne by one");
          message=br.readLine();
          if (message.equals("A") ){ // all info at once
            System.out.println("Please enter the name of your json file with extension");
            String fileName = br.readLine();
            FileReader reader = new FileReader(fileName);
            Object obj = jsonParser.parse(reader);
            JSONObject newPet = (JSONObject) obj;
            Entity myentity = Entity.entity(newPet,mediaType);
            Response thePostResponse=theURL.request().post(myentity);
            thestuff = thePutResponse.readEntity(String.class);
          }
          else if (message.equals("O")  )  // info one at a time
          {

            JsonObject petInfo = new JsonObject();
            String type;
            String name;
            String disease;
            ArrayList<String> vaccine = new ArrayList();
            String owner;
            String amt;
            ArrayList<String> choices = new ArrayList();
            choices.add("type");
            choices.add("name");
            choices.add("disease");
            choices.add("vaccinations");
            choices.add("owner");
            choices.add("amount owed");
            for(int i = 0; i < 6; i++)
            {
              if(i == 3)
              {
                int num;
                System.out.println("Please enter # of vaccinations");
                num = br.readLine();
                for(i = 0; i < num; i++)
                {
                  System.out.println("Enter vaccine " + i);
                  vaccine.add(br.readLine());

                }

              }
              else //i != 3
              {

                System.out.println("Please enter the " + choices.get(i));
                if(i == 0){
                  type = br.readLine();
                }
                else 
                if(i == 1){
                  name = br.readLine();
                }
                else if(i == 2){
                  disease = br.readLine();
                }
                else if(i == 4){
                  owner = br.readLine();
                }
                else{  //i == 5
                  amt = br.readLine();
                } 

              
              }

              petInfo.put("type", type);
              petInfo.put("name", name);
              petInfo.put("disease", disease);
              petInfo.put("vaccine", new JSONArray(vaccine));
              petInfo.put("owner", owner);
              petInfo.put("amtOwed", amt);

            }

            Entity myentity = Entity.entity(petInfo,mediaType);
            Response thePostResponse=theURL.request().post(myentity);
            thestuff = thePostResponse.readEntity(String.class);

          }  
          
        }
        else if ( message.equals("G") )
        {    // GET info
        
          System.out.println("Would you like info on \n (A)nimals");
          System.out.println("(D)iseases");
          System.out.println("Amounts (O)wed");
          System.out.println("All (D)ata for Pets");
          System.out.println("All Data for O(W)ners");

          String msg = br.readLine();

          if(msg == 'A')
          {
            WebTarget theURL = client.target("http://localhost:8080/myrestful/restful/hello/A");
            mediaType=MediaType.TEXT_PLAIN;

            Response theGetResponse=theURL.request().get();
            thestuff = thePutResponse.readEntity(String.class);
            System.out.println(thestuff);
          }
        
        }
      }

}  
 
