package Tut7;

public class GreetingConservation {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("Samsung","A-123",Color.B,2014,true);
        Person person = new Person("giang", 2013);
        person.setPhone(phone);
        System.out.println(person.toString());
    }
}
