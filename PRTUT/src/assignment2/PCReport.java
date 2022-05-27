package assignment2;

public class PCReport {
    public PCReport(){

    }
    public String displayReport(PC[] objs){
        if(objs.length==0){
            return null;
        }
        String horizontalLines = "";
        for(int i = 1;i<99;i++){
            horizontalLines+="-";
        }
        String s = horizontalLines+ String.format("\n%50s\n","PCPROG REPORT")+horizontalLines;
        for(int i =0;i<objs.length;i++){
            s = s+  String.format("\n%3d ",i+1)+ String.format("%s ",objs[i].getModel())+

                    String.format("%6d ",objs[i].getYears())+
                    String.format("%s ",objs[i].getManufacturer())+
                    String.format("%-1s",objs[i].getComps().getElements());
        }
        s = s+"\n"+ horizontalLines;
//        System.out.println(s);

            return s;






//


    }




}
