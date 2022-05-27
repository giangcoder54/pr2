package Tut7;

import utils.OptType;


/** @overview
 * @attribute
 *  name : String
 *  age : Integer
 *  phone : MobilePhone
 * @object A  typical  Person is c=<d,b> where d = name, b = age
 * @abstract_properties
 *  mutable(age)=false /\ optional(id)=false /\ min(id)=1 /\
 *  mutable(name)=false /\ optional(name)=false /\ length(name)
 * =50
 * mutable = true /\ optional(phone) = true
 *  @author giang
 */
public class Person {
    @utils.DomainConstraint(type="String",mutable = true,optional = false,length=  50 )
    private String name;
    @utils.DomainConstraint(type = "Integer",mutable = false,optional = false,min =1)
    private  int id;
    @utils.DomainConstraint(type = "MobilePhone", mutable = true,optional = true)
    private MobilePhone phone;

    @utils.DOpt(type = OptType.Constructor)
    public Person(@utils.AttrRef("name") String name, @utils.AttrRef("id") int id) throws utils.NotPossibleException {
        if (!validateId(id)) {
             throw new utils.NotPossibleException("Person.init: Invalid  Person id: " + id);
                   
             }

         if (!validateName(name)) {
             throw new utils.NotPossibleException("Person.init: Invalid  Person name: " + name);
                   
             }
        this.name = name;
        this.id = id ;
    }
@utils.DOpt(type = OptType.Mutator) @utils.AttrRef("name")
public boolean setName(String name){
        if(validateName(name)){
            this.name = name;
            return true;
        }
        return false;
}
@utils.DOpt(type = OptType.Mutator) @utils.AttrRef("id")
public boolean setId(int id){
        if(validateId(id)){
            this.id= id;
            return true;
        }
        return false;
}

@utils.DOpt(type = OptType.Observer) @utils.AttrRef("id")
    public int getId() {
        return id;
    }
@utils.DOpt(type = OptType.Observer) @utils.AttrRef("name")
   public String getName(){
        return name;
}
@utils.DOpt(type = OptType.Mutator) @utils.AttrRef("phone")
    public void setPhone(MobilePhone phone){
        this.phone = phone;
    }

   @utils.DOpt(type = OptType.ObserverContains) @utils.AttrRef("phone")
    public MobilePhone getPhone(){
       return phone;
   }

@utils.DOpt(type =OptType.Default)
        public String toString(){
    if(phone != null) {
        return String.format("Name: %s \n id: %d \nMobilePhone: %s ", this.name,this.id,this.phone.getManName());
    }
    return String.format("Name: %s \n id: %d ", this.name,this.id);
       }
    @utils.DOpt(type = OptType.Default)
    public boolean equals(Object o) {
      if(o == null || ! (o instanceof Person)){
          return false;
      }
      return true;
    }
    @utils.DOpt(type = OptType.Helper)
    private boolean repOk() {
        return validateId(id) && validateName(name);
    }

    @utils.DOpt(type = OptType.Helper)
    private boolean validateName(String name) {
        return (name != null && name.length()>0 && name.length()<50);
    }
    private boolean validateId  (int id) {
        return id >1;
    }
    private boolean validatePhone(MobilePhone phone){
        return true;
    }

}
