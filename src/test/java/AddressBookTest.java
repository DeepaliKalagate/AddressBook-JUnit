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
        String result=addressBookServices.addUser("Deepak","Gavali","9898765432","Bhandup","Goa","456987");
        System.out.println(result);
    }

    @Test
    public void givePersonList_ReadList_ShouldReturnList() throws IOException
    {
        String result=addressBookServices.readFile(fileName);
        System.out.println(result);
    }

    @Test
    public void givePersonName_EditUser_ShouldEditInFile() throws IOException
    {
        String result=addressBookServices.editPerson("Guru","9898798987","Dadar","Maharashtra","400088");
        System.out.println(result);
    }

    @Test
    public void givePersonName_CheckUserInFile_ShouldDeleteFromFile() throws IOException
    {
        String result=addressBookServices.deletePerson("Deepak");
        System.out.println(result);
    }

    @Test
    public void givePersonList_CheckList_ShouldReturnSortByName() throws IOException
    {
        String result=addressBookServices.sortByName();
        System.out.println(result);
    }
}
