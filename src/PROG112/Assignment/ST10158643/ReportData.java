package PROG112.Assignment.ST10158643;

public class ReportData 
{//Declaring variables
    private String code ;
    private String name ;
    private String warranty ;
    private String catergory ;    
    private String supplier ;
    private double price ;
    private int stkLvl ;      
   //Class Getters and Setters  
    public String getCode() 
    {
        return code;
    }
    public void setCode(String code) 
    {
        this.code = code.toUpperCase();
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getWarrenty() 
    {
        return warranty;
    }
    public void setWarranty(int warranty)
    {//if inputted  warranty is equal to 1 
      if(1 == warranty)
           this.warranty = "6 Months";
       else
           this.warranty = "2 years";
    }
    public String getCatergory()
    {
        return catergory;
    }
    public void setCatergory(int catergory)
    {
        catergory = catergory - 1;
        String[] categories = new String[5];
        categories[0] = "Desktop Computer";
        categories[1] = "Laptop";
        categories[2] = "Tablet";
        categories[3] = "Printer";
        categories[4] = "Gaming Console";
        this.catergory = categories [catergory];
    }
    public int getStkLvl()
    {
        return stkLvl;
    }
    public void setStkLvl(int stkLvl) 
    {
        this.stkLvl = stkLvl;
    }
    public String getSupplier() 
    {
        return supplier;
    }
    public void setSupplier(String supplier)
    {
        this.supplier = supplier;
        
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
}//end class