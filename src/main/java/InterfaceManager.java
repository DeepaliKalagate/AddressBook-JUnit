import java.io.IOException;

public interface InterfaceManager
{
    public String addUser(String firstName,String lastName,String mobNo,String city,String state,String zip) throws IOException;
    public String editPerson(String name,String mobNo, String city,String state,String  zip) throws IOException;
    public String deletePerson(String name) throws IOException;
    public String sortByName() throws IOException;
    public String sortByZip() throws IOException;
}
