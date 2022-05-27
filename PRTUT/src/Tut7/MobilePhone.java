package Tut7;
import utils.DomainConstraint;
import utils.OptType;
import utils.AttrRef;

/** @overview MobliePhone is a electric device which help people talk together from long dictance
 * @attribute
 * ManName : String || mutable = false /\ optional = false/\ length =50
 * Model : String || mutable = false /\ optional = false /\ length = 50
 * Color : Character mutable = true /\ optional = false /\ length =1
 * Year : Integer       muatble = false /\ optinal = false /\ min = 190
 * guaranteed : Boolean mutable = true /\ optinal = false
 * @object c = <a,b,c,d,e> where ManName(a), Model(b), Color(c),Year(d),guaranteed(e)
 *
 *
 *
 *
 */


public class MobilePhone {
    @DomainConstraint(type = "String",mutable = false,optional = false,length = 50)
    private String ManName;

    @DomainConstraint(type = "String",mutable = false,optional = false,length = 50)
    private String Model;

    @DomainConstraint(type = "Character",mutable = true,optional = false,length = 1)
    private Color color;

    @DomainConstraint(type = "Boolean",mutable = true,optional = false)
    private boolean guaranteed;

    @DomainConstraint(type = "Integer",mutable = false,optional = false,min = 1970)
    private int year;

    @utils.DOpt(type = OptType.Constructor)
    public MobilePhone(@AttrRef("ManName") String ManName,@AttrRef("Model") String model,@AttrRef("color") Color color,
                       @AttrRef("year") int year,@AttrRef("guaranteed") boolean guaranteed) throws utils.NotPossibleException {
      if(!validateName(ManName)){
          throw new  utils.NotPossibleException("MobilePhone.init : Invalid MobilePhone ManName: " + ManName);

      }
      if(! validateModel(model)){
          throw new  utils.NotPossibleException("MobilePhone.init : Invalid Model ManName: " + Model);
      }
      if(!validateColor(color)){
          throw new  utils.NotPossibleException("MobilePhone.init : Invalid MobilePhone color: " + color);
      }if(!validateYear(year)){
            throw new  utils.NotPossibleException("MobilePhone.init : Invalid MobilePhone year: " + year);
        }
       this.ManName = ManName;
       this.Model = model;
       this.color = color;
       this.year = year;
       this.guaranteed = guaranteed;
    }
    @utils.DOpt(type = OptType.Mutator)
    @AttrRef("ManName")
    public boolean setManName(String ManName){
        if(validateName(ManName)){
            this.ManName = ManName;
            return true;
        }
        return false;
    }
    @utils.DOpt(type = OptType.Mutator)
    @AttrRef("Model")
    public boolean setModel(String Model){
        if(validateName(Model)){
            this.Model= Model;
            return true;
        }
        return false;
    }

    @utils.DOpt(type = OptType.Mutator)
    @AttrRef("color")
    public void setColor(Color color) {
        if (validateColor(color)) {
            this.color = color;
        }
    }
    @utils.DOpt(type = OptType.Mutator)
    @AttrRef("guaranteed")
    public void setGuaranteed(boolean guaranteed) {
        this.guaranteed = guaranteed;
    }


    @utils.DOpt(type = OptType.Observer)
    @AttrRef("manName")
    public String getManName() {
        return ManName;
    }
    @utils.DOpt(type = OptType.Observer)
    @AttrRef("model")
    public String getModel() {
        return Model;
    }
    @utils.DOpt(type = OptType.Observer)
    @AttrRef("color")
    public Color getColor() {
        return color  ;
    }
    @utils.DOpt(type = OptType.Observer)
    @AttrRef("year")
    public int getYear() {
        return year;
    }
    @utils.DOpt(type = OptType.Observer)
    @AttrRef("guaranteed")
    public boolean isGuaranteed() {
        return guaranteed;
    }
    @utils.DOpt(type = OptType.Helper)
    private boolean validateName(String ManName){
        return (ManName != null && ManName.length()>0 && ManName.length()<50);
    }
    private boolean validateModel(String Model){
        return (Model != null && Model.length()>0&& Model.length()<50);
    }
    private boolean validateYear(int year){
        return (year> 1970);
    }
    private boolean validateColor(Color color){
        return color == Color.R ||color == Color.B || color == Color.O || color == Color.P || color == Color.Y;

    }
    @utils.DOpt(type = OptType.Default)
    public String toString(){
        return String.format("Model : %s \nManName : %s \nyear : %d \ncolor : %S",this.Model,this.ManName,this.year,this.color);
    }
    @utils.DOpt(type = OptType.Default)
    public boolean equals(Object o) {
        if(o == null || !(o instanceof MobilePhone)){
            return false;
        }
        return true;
    }


}


