package assignment2;
import utils.DomainConstraint;


public class PC {
      @DomainConstraint(type="String",mutable=true,optional=false,length=20)
    private String model;
      @DomainConstraint(type="Integer",mutable=false,optional=false,min=1984)
    private int years;
      @DomainConstraint(type="String",mutable=false,optional=false,length=15)
    private String manufacturer;
     @DomainConstraint(type="Set<String>",mutable=true,optional=false)
    private Set<String> comps;
    @utils.DOpt(type = utils.OptType.Constructor)
    public PC(String model, int years,String manufacturer,Set<String> comps){
        this.model = model;
        this.years= years;
        this.manufacturer = manufacturer;
        this.comps = comps;
    }

    @utils.DOpt(type = utils.OptType.Observer)
    @utils.AttrRef("comps")
    public Set<String> getComps() {
        return comps;
    }
    @utils.DOpt(type = utils.OptType.Mutator) @utils.AttrRef("model")
    public void setModel(String model){
        this.model=model;
    }

    @utils.DOpt(type = utils.OptType.Mutator) @utils.AttrRef("comps")
    public void setComps(Set<String> comps) {
        this.comps = comps;
    }
    @utils.DOpt(type = utils.OptType.Observer)
    @utils.AttrRef("model")
    public String getModel() {
        return model;
    }
    @utils.DOpt(type = utils.OptType.Observer)
    @utils.AttrRef("years")
    public int getYears() {
        return years;
    }
    @utils.DOpt(type = utils.OptType.Observer)
    @utils.AttrRef("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "PC<" +
                 model +"," +
                 years +","+
                 manufacturer + "," +
                  comps.toString() +
                '>';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
