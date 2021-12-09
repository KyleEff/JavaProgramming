package freezingandboilingpoints;

public class Substance {
    // Attributes
    private double
            currentTemp,
            freezePoint,
            boilPoint;
    
    private String
            state,
            name;
    
    // Constructors
    public Substance()
        {currentTemp = freezePoint = boilPoint = 0.0;}
    
    public Substance(double freezePoint, double boilPoint, String name) {
    
        this.freezePoint = freezePoint;
        this.boilPoint = boilPoint;
        this.name = name;
    }
    // Mutator Methods
    public void setTemp(double currentTemp) {
        
        this.currentTemp = currentTemp;
        setState();
    }
    
    public void setFreeze(double freezePoint)
        {this.freezePoint = freezePoint;}
    
    public void setBoil(double boilPoint)
        {this.boilPoint = boilPoint;}
    
    public void setName(String name)
        {this.name = name;}
    
    public void setState() {
        
        if (currentTemp <= freezePoint)
            state = "Solid";
        
        else if (currentTemp >= boilPoint)
            state = "Gas";
        
        else state = "Liquid";
    }
    
    // Accessor Methods
    public double getCurrentTemp()
        {return currentTemp;}
    
    public double getFreeze()
        {return freezePoint;}
    
    public double getBoil()
        {return boilPoint;}
    
    public String getState()
        {return state;}
    
    public String getName()
        {return name;}
}
