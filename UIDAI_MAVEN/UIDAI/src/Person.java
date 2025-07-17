import java.util.List;
public class Person {

    private String name;
    private int age;
    private double balance;
    private List<String> intrest;

    public Person()
    {}

    public Person(String name, int age, double balance, List<String> intrest) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.intrest = intrest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public List<String> getIntrest(){
        return intrest;
    }

    public void setIntrest(List<String> intrest){
        this.intrest = intrest;
    }
}
