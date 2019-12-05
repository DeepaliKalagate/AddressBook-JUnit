import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookServices implements InterfaceManager
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";
    List<Person> list=new ArrayList<>();
    Person person=new Person();
    Address address=new Address();
    Gson gson=new Gson();
    ObjectMapper objectMapper=new ObjectMapper();
    String json=null;
    Scanner scanner=new Scanner(System.in);

    @Override
    public void addUser(String firstName, String lastName, String mobNo, String city,String state,String  zip) throws IOException
    {
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMobNo(mobNo);
        person.setAddress(address);

        Person temp=new Person(firstName,lastName,mobNo,new Address(city,state,zip));
        list.add(temp);
        System.out.println(list);

        writeToJsonFile();
    }

    public void writeToJsonFile() throws IOException
    {
         json=gson.toJson(list);
        FileWriter fileWriter=new FileWriter("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
