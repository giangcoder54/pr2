package assignment2;

public class PCFactory {

    private PCFactory(){

    }

    public static PC createPC(String model,int years, String manufacturer,Set<String> comps ){
        PC pc = new PC(model,years,manufacturer,comps);
        return pc;
    }


}
