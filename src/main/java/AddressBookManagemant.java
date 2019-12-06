import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManagemant implements InterfaceManagement
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";
    private  String newFile="home/admin1/Documents/AddressBook/src/test/resources";
    List<Person> list=new ArrayList<>();
    Person person=new Person();
    Address address=new Address();
    ObjectMapper objectMapper=new ObjectMapper();
    AddressBookServices addressBookServices=new AddressBookServices();

    public boolean createAddressBook(String fileName) throws Exception
    {
            File fileName1=new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json");

            boolean file=fileName1.createNewFile();
            if (file)
            {
                System.out.println( "New Address Book Created Successfully");
            }
            else
            {
                throw new Exception("Given Name of Address Book already Exist");
            }
            return true;
    }

    @Override
    public boolean openAddressBook(String fileName)
    {
        File folder = new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles)
        {
            if (file.isFile())
            {
                System.out.println(file.getName());
            }
        }

        if (new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/" + fileName + ".json")
                .exists())
        {
            try
            {
                list = objectMapper.readValue(new File(
                                "/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/" + fileName + ".json"),
                        new TypeReference<List<Person>>()
                        {
                        });
                addressBookServices.printList(fileName);
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                System.out.println("File Opened Successfully");
            }
        }
        else
        {
            System.out.println("Oh-ho,File Not Found!");
        }
        return true;
    }

    @Override
    public boolean saveAddressBook(String fileName) throws IOException
    {

        if (new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/" + fileName + ".json")
                .exists())
        {
            addressBookServices.printList(fileName);
            System.out.println("File Saved Successfully");
        }
        else
        {
            System.out.println("Oh-ho,File Not Saved!");
        }
        return true;
    }

    @Override

    public boolean saveAsAddresBook(String fileName,String newFileName) throws Exception
    {
        File oldFile=new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json");
        if (oldFile.exists())
        {
            addressBookServices.readFile(new File("/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json"));
            createAddressBook(newFileName);
            addressBookServices.writeToJsonFile(newFileName);
            addressBookServices.printList(newFileName);
        }
        return true;
    }
}
