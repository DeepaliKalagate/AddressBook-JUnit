import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManagemant implements InterfaceManagement
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";


    public String createAddressbook(String fileName) throws Exception
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
                throw new Exception("given name addressbook already exist");
            }

        return "New Address Book Created Successfully";
    }


}
