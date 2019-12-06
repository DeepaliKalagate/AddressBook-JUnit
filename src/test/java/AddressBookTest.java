import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest
{
    private String fileName="/home/admin1/Desktop/AddressBook-JUnit/src/main/resources/Address.json";
    AddressBookServices addressBookServices=new AddressBookServices();
    AddressBookManagemant addressBookManagemant=new AddressBookManagemant();

    @Test
    public void givePersonDetails_checkDetails_ShouldAddInList() throws IOException
    {
        Assert.assertTrue(addressBookServices.addUser("Address","Deepak","Gavali","9898765432","Bhandup","Goa","456987"));
    }

    @Test
    public void givePersonName_EditUser_ShouldEditInFile() throws IOException
    {
        Assert.assertTrue(addressBookServices.editPerson("Address","Guru","9898798987","Dadar","Maharashtra","400088"));
    }

    @Test
    public void givePersonName_CheckUserInFile_ShouldDeleteFromFile() throws IOException
    {
        Assert.assertTrue(addressBookServices.deletePerson("Address","Deepak"));
    }

    @Test
    public void givePersonList_CheckList_ShouldReturnSortByName() throws IOException
    {
        Assert.assertTrue(addressBookServices.sortByName("Address"));
    }

    @Test
    public void givePersonList_CheckList_ShouldReturnSortByZip() throws IOException
    {
        Assert.assertTrue(addressBookServices.sortByZip("Address"));
    }

    @Test
    public void givePersonList_ReadList_ShouldPrintAllEntries() throws IOException
    {
        Assert.assertTrue(addressBookServices.printList("Address"));
    }

    @Test
    public void giveNewFile_CheckFiles_ShouldCreateNewAddressBook() throws Exception
    {
        Assert.assertTrue(addressBookManagemant.createAddressBook("Person"));
    }

    @Test
    public void giveFileName_checkFiles_ShouldOpenFile()
    {
        Assert.assertTrue(addressBookManagemant.openAddressBook("Address"));
    }

    @Test
    public void giveFileName_WriteOneEntry_ShouldSaveFile() throws IOException
    {
        Assert.assertTrue(addressBookServices.addUser("Address","Anuska","Kalagate","8097453222","Ichalkaranji","Maharashtra","416115"));
        Assert.assertTrue(addressBookManagemant.saveAddressBook("Address"));
    }

    @Test
    public void giveFileName_FetchData_ShouldSaveInGivenFileName() throws Exception
    {
       Assert.assertTrue(addressBookManagemant.saveAsAddresBook("NewAddress","Abc"));
    }

}
