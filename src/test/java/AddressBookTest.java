import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";
    AddressBookServices addressBookServices=new AddressBookServices();
    @Test
    public void givePersonDetails_checkDetails_ShouldAddInList() throws IOException
    {
        addressBookServices.addUser("Deepak","Gavali","9898765432","Bhandup","Goa","456987");
    }

    @Test
    public void givePersonList_ReadList_ShouldReturnList() throws IOException
    {
        addressBookServices.readFile(fileName);
    }

    @Test
    public void giveEditOption_EditUser_ShouldEditInFile() throws IOException
    {
        String result=addressBookServices.editPerson("Guru","9898798987","Dadar","Maharashtra","400088");
        System.out.println(result);
    }
}
