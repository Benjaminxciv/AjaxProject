import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.*;

public class Pet {

    // VARIABLES
    public String type;
    public String name;
    public String disease;
    public ArrayList<String> vaccinations;
    public String owner;
    public int amountOwed;

    //Constructor
    public Pet()
    {

        type = "";
        name = "";
        disease = "";
        vaccinations = new ArrayList();
        amountOwed = 0;

    }
    //overloaded constructor
    public Pet(JSONObject obj)
    {

        type = obj.getString("type");
        name = obj.getString("name");
        disease = obj.getString("disease");
        for (String string : obj.getJSONArray.getStringArray("vaccinations")) {
            vaccinations.add(string);
        }
        owner = obj.getString("owner");
        amountOwed = obj.getInt("amountOwed", 0);

    }

    public String PrintName()
    {

        return name;

    }

    public String PrintDisease()
    {

        return disease;

    }

    public int PrintAmtOwed()
    {

        return amountOwed;

    }

    public ArrayList PrintOwnerInfo()
    {

        ArrayList<String> myArr = new ArrayList();
        myArr.add(name);
        myArr.add(Integer.toString(amountOwed));
        return myArr;

    }

    public ArrayList PrintAllInfo()
    {

        ArrayList<ArrayList> myArr = new ArrayList();
        ArrayList<String> typeArr = new ArrayList();
        typeArr.add(type);
        ArrayList<String> nameArr = new ArrayList();
        nameArr.add(name);
        ArrayList<String> disArr = new ArrayList();
        disArr.add(disease);
        ArrayList<String> vacArr = new ArrayList();
        for (String string : vaccinations) {
            vacArr.add(string);
        }
        ArrayList<String> ownArr = new ArrayList();
        ownArr.add(owner);
        ArrayList<String> amtArr = new ArrayList();
        amtArr.add(Integer.toString(amountOwed));

        myArr.add(typeArr);
        myArr.add(nameArr);
        myArr.add(disArr);
        myArr.add(vacArr);
        myArr.add(ownArr);
        myArr.add(amtArr);

        return myArr;

    }

    public JSONObject toJSONObject()
    {

        JSONObject obj = new JSONObject();
        obj.setString("type", type);
        obj.setString("name", name);
        obj.setString("disease", disease);
        JSONArray<String> myJsonArr = new JSONArray();
        for (String string : vaccinations) {
            myJsonArr.append(string);
        }
        obj.setJSONArray(myJsonArr);
        obj.setInt("amountOwed", amountOwed);

    }


}
