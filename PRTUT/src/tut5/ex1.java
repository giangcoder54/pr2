package tut5;

public class ex1 {
    public static void main(String[] args) {

phone phone = new phone("iphone", "g5566");
        Name name = new Name("giang", phone);
        name.greet();
    }
}
 class phone{
    private String name;
    private String model;
    public phone(){

    }
    public phone(String name, String model){
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }
}
class  Name {
    private String name;
    public Name(String name0, phone name){
        this.name = name0;
    }

    public String getName() {
        return name;
    }
    public void greet(){
        System.out.println("Hello my name is "+ name +" using " + new phone().getName() );
    }
}
