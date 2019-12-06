import java.io.IOException;
import java.util.List;

public interface InterfaceManager
{
    public boolean addUser(String fileName,String firstName,String lastName,String mobNo,String city,String state,String zip) throws IOException;
    public boolean editPerson(String fileName,String name,String mobNo, String city,String state,String  zip) throws IOException;
    public boolean deletePerson(String fileName,String name) throws IOException;
    public boolean sortByName(String fileName) throws IOException;
    public boolean sortByZip(String fileName) throws IOException;
    public boolean printList(String fileName) throws IOException;

}
