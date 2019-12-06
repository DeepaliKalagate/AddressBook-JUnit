import java.io.IOException;

public interface InterfaceManagement
{
    public String createAddressBook(String fileName) throws Exception;
    public void openAddressBook(String fileName);
    public void saveAddressBook(String fileName) throws IOException;
}
