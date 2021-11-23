package collections;

public class Person implements Comparable{

    protected String FirstName;
    protected String LastName;
    protected int Age;
    protected String Job;


    Person(String FirstName, String LastName, int Age, String Job)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.Job = Job;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public int getAge()
    {
        return Age;
    }

    public String getJob()
    {
        return Job;
    }

    @Override
    public int compareTo(Object o) {
        return getLastName().compareTo(((Person) o).getLastName());
    }
}
