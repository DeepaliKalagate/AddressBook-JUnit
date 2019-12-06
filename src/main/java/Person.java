public class Person
{
    private String firstName;
    private String lastName;
    private String mobNo;
    private Address address;

    public Person()
    {
    }

    public Person(String firstName, String lastName, String mobno, Address address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobNo = mobno;
        this.address = address;
    }

    public Person(String fileName, String firstName, String lastName, String mobNo, Address address)
    {
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMobNo()
    {
        return mobNo;
    }

    public void setMobNo(String mobNo)
    {
        this.mobNo = mobNo;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Person" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobno='" + mobNo + '\'' +
                ", address=" + address +
                "\n";
    }
}
