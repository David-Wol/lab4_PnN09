package collections;

public class BetterPerson extends Person{

    BetterPerson(String FirstName, String LastName, int Age, String Job) {
        super(FirstName, LastName, Age, Job);
    }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BetterPerson that = (BetterPerson) o;

            if (Age != that.Age) return false;
            if (!FirstName.equals(that.FirstName)) return false;
            return LastName.equals(that.LastName);
        }

        @Override
        public int hashCode()
        {
            int result = FirstName.hashCode();
            result = 31 * result + LastName.hashCode();
            result = 31 * result + Age;
            return result;
        }
}
