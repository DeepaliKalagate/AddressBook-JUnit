import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManagemant implements InterfaceManagement
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";
    private  String filePath="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/";

    List<Person> list=new ArrayList<>();
    Person person=new Person();
    Address address=new Address();
    ObjectMapper objectMapper=new ObjectMapper();
    AddressBookServices addressBookServices=new AddressBookServices();

    public String createAddressBook(String fileName) throws Exception
    {
            String fileName1="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/"+fileName+".json";
            File file =new File(fileName1);
            if(file.createNewFile())
            {
                FileWriter fw=new FileWriter(fileName1);
                String object="[{"+'"'+"personList"+'"'+":0}]";
                fw.write(object);
                fw.close();
            }
            else
            {
                throw new Exception("Given Name of Address Book already Exist");
            }

        return "New Address Book Created Successfully";
    }

    @Override
    public void openAddressBook(String fileName)
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
                addressBookServices.printList();
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
    }

    @Override
    public void saveAddressBook(String fileName) throws IOException
    {

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
                addressBookServices.printList();
                addressBookServices.writeToJsonFile();
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                System.out.println("File Saved Successfully");
            }
        }
        else
        {
            System.out.println("Oh-ho,File Not Saved!");
        }
    }


    @Override
    public boolean saveAsAddressBook(String oldName, String newName)
    {
        if (oldName.length()>0 && newName.length()>0)
        {
            File file=new File(filePath+"/"+oldName+".json");
            if(file.exists())
            {
                File renameFile=new File(filePath+"/"+newName+".json");
                file.renameTo(renameFile);
                return true;
            }
        }
        return false;
    }
}
