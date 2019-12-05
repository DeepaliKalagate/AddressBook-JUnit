import java.io.IOException;

public interface InterfaceManager
{
    public void addUser(String firstName,String lastName,String mobNo,String city,String state,String zip) throws IOException;
    public String editPerson(String name,String mobNo, String city,String state,String  zip) throws IOException;
}
