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
    public String addUser(String firstName, String lastName, String mobNo, String city,String state,String  zip) throws IOException
    {
        readFile(fileName);
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
        readFile(fileName);
        return "Added Successfully New Person";
    }

    public String  writeToJsonFile() throws IOException
    {
        json=gson.toJson(list);
        FileWriter fileWriter=new FileWriter("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json");
        fileWriter.write(json);
        fileWriter.close();
        return "Written Successfully";
    }

    public String readFile(String fileName) throws IOException
    {
        this.fileName=fileName;
        this.list=objectMapper.readValue(new File(this.fileName), new TypeReference<List<Person>>()
        {
        });
        return "Records From File Readed Successfully";
    }


    @Override
    public String editPerson(String name,String mobNo, String city, String state, String zip) throws IOException
    {

        readFile(fileName);

        for (int i=0;i<list.size();i++)
        {
            if (list.get(i).getFirstName().equals(name))
            {
                list.get(i).setMobNo(mobNo);
                list.get(i).getAddress().setCity(city);
                list.get(i).getAddress().setState(state);
                list.get(i).getAddress().setZip(zip);
            }
        }
        writeToJsonFile();
        return "Edited Person Information Successfully";
    }

    @Override
    public String deletePerson(String name) throws IOException
    {
        readFile(fileName);
        list.removeIf(Person->Person.getFirstName().equals(name));
        writeToJsonFile();
        return "Person Information Deleted Successfully";
    }
}
