import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterfaceManagement
{
    public boolean createAddressBook(String fileName) throws Exception;
    public boolean openAddressBook(String fileName);
    public boolean saveAddressBook(String fileName) throws IOException;
    public boolean saveAsAddresBook(String fileName,String newFileName) throws Exception;
}
