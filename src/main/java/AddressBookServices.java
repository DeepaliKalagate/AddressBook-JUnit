import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AddressBookServices implements InterfaceManager
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";
    private String fileName1="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Person.json";
    List<Person> list=new ArrayList<>();
    Person person=new Person();
    Address address=new Address();
    Gson gson=new Gson();
    ObjectMapper objectMapper=new ObjectMapper();
    String json=null;
    Scanner scanner=new Scanner(System.in);

    @Override
    public boolean addUser(String fileName,String firstName, String lastName, String mobNo, String city,String state,String  zip) throws IOException
    {
        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMobNo(mobNo);
        person.setAddress(address);

        Person temp=new Person(fileName,firstName,lastName,mobNo,new Address(city,state,zip));
        list.add(temp);
        System.out.println(list);

        writeToJsonFile(fileName);
        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
        System.out.println("Added Successfully New Person");
        return true;
    }

    public boolean  writeToJsonFile(String FileName) throws IOException
    {
        json=gson.toJson(list);
        FileWriter fileWriter=new FileWriter("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json");
        fileWriter.write(json);
        fileWriter.close();
        System.out.println("Written Successfully");
        return true;
    }

    public boolean readFile(File fileName) throws IOException
    {
        this.list=objectMapper.readValue(fileName, new TypeReference<List<Person>>()
        {
        });
        System.out.println("Read Records From File Successfully");
        return true;
    }


    @Override
    public boolean editPerson(String fileName,String name,String mobNo, String city, String state, String zip) throws IOException
    {

        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));

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
        writeToJsonFile(fileName);
        System.out.println("Edited Person Information Successfully");
        return true;
    }

    @Override
    public boolean deletePerson(String fileName,String name) throws IOException
    {
        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
        list.removeIf(Person->Person.getFirstName().equals(name));
        writeToJsonFile(fileName);
        System.out.println("Person Information Deleted Successfully");
        return true;
    }

    @Override
    public boolean sortByName(String FileName) throws IOException
    {
        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
            for(int i=0;i<list.size()-1;i++)
            {
                for(int j=0;j<list.size()-i-1;j++)
                {
                    if(list.get(j).getFirstName().compareTo(list.get(j+1).getFirstName())>0)
                    {
                        Person temp=list.get(j);
                        list.set(j,list.get(j+1));
                        list.set(j+1,temp);
                    }
                }
            }
            writeToJsonFile(fileName);
        System.out.println("Sorted By Name");
            return true;
    }

    @Override
    public boolean sortByZip(String fileName) throws IOException
    {
        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
        for(int i=0;i<list.size()-1;i++)
        {
            for (int j = 0; j < list.size() - i - 1; j++)
            {
                if (list.get(j).getAddress().getZip().compareTo(list.get(j + 1).getAddress().getZip()) > 0)
                {
                    Person temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
        writeToJsonFile(fileName);
        System.out.println("Sorted By Zip Successfully");
        return true;
    }

    @Override
    public boolean printList(String fileName) throws IOException
    {
        readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
        System.out.println("FirstName   LastName    Mobile_Number       City     State      Zip \n");
        String spaces = " ";
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).getFirstName() + "     " + list.get(i).getLastName() + "     "
                    + list.get(i).getMobNo() + "     " + list.get(i).getAddress().getCity() + "    "
                    + list.get(i).getAddress().getState() + "    "+ list.get(i).getAddress().getZip());
                System.out.println();
        }
        System.out.println("Printed List Successfully");
        return true;
    }




}
