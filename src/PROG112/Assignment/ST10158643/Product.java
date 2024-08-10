
package PROG112.Assignment.ST10158643;
import java.util.ArrayList;
import java.util.Scanner;


public class Product
{  //Declaring variables 
    static private int count;
    static private double totalVal;
    // Declaring an ArrayList of ReportData data type
    static ArrayList<ReportData> items = new ArrayList<ReportData>();
    //Instancing ReportData Class Object 
    static ReportData it = new ReportData(); 
    
    //Method to capture product details  ______________________________________________________________________________________________________________
     public static void CaptureProduct()
     { //Delcaring Variables
        int input ;
        int cate;
        String prodName;
        String strInput;
        String suppier;
        //Instancing Scanner Class Object
        Scanner in = new Scanner(System.in);  
        //output message
        System.out.print("CAPTURE A NEW PRODUCT"
                + "\n*************************************\n");
        //Output to request user input
         System.out.print("Please enter the product code: ");
         strInput = in.next();
         //Setting ReportData Object's code
         it.setCode(strInput);
         //Output to request user input
         System.out.print("Please enter the product name: ");
         prodName = in.next();
         //Setting ReportData Object's product name
         it.setName(prodName);
        /*do while loop, will loop while inputted category integer is less than
         1 or greater then 5*/
        do
        {//output to display product categories
            System.out.print("Select the product category:"
                 + "\nDesktop Computer - 1"
                 + "\nLaptop - 2"
                 + "\nTablet - 3"
                 + "\nPrinter - 4"
                 + "\nGaming Console - 5");
            //output to request user input 
             System.out.print("\n\nProduct Category >>");
             cate = in.nextInt();
           //if-else statement, if inputted category integer is below 0 or higher then 6
           if(cate > 0 && cate < 6 )
           {//Setting ReportData Object's category
               it.setCatergory(cate);
               break;
           }
           //Output message for invalid input
           System.out.println("\nInvalid Input!\n");           
        }while(cate < 1 || cate > 5);
        /*do while loop, will loop while user input is equal to 0 */
       //output to request user input 
        System.out.print("Indicate the product warranty. Enter(1) for 6 "
                + "months or any other key for 2 years.");
        strInput = in.next(); 
        //try catch to set warranty to 6 months or 2 Years 
        try{
        //Setting ReportData Object's warranty
        it.setWarranty(Integer.parseInt(strInput));
        }catch(NumberFormatException e)
        {//Setting ReportData Object's warranty for any inputted key
           it.setWarranty(2); 
        }
       /*do while loop, will loop while user input is equal to 0 */
       do{//output to request user input 
        System.out.print("Enter the price for "+prodName+" >>");
        input = in.nextInt();
         //Setting ReportData Object's price
        it.setPrice(input);
         }while(input==0);
        /*do while loop, will loop while user input is equal to 0 */
       do{//output to request user input 
        System.out.print("Enter the stock level for "+prodName+" >>");
        input = in.nextInt();
         //Setting ReportData Object's stock level
        it.setStkLvl(input);
         }while(input==0);
         /*do while loop, will loop while user input is equal to 0 */ 
        //output to request user input
        do{System.out.print("Enter the suppier for "+prodName+" >>");
        suppier = in.nextLine().replaceAll("\\s+", "_");
        }while(suppier.isEmpty());
       //Setting ReportData Object's supplier
        it.setSupplier(suppier);
       //Method call to save Report Data Object
       SaveProduct(cate); 
       //Output to indicate Product has been saved
       System.out.println("Product details has been saved successfully!!!");
     }
     //Method to Search Products ______________________________________________________________________________________________________________
     public static void SearchProduct()
     {  //Declaring variables 
        String strInput ;
        Scanner in = new Scanner(System.in);
        /*do while loop, will loop while user input is empty*/
        do{ //output to request user input 
            System.out.print("Please enter the product code to search: ");
            strInput = in.next();
          }while(strInput.isEmpty());
        //For loop, iterates through entire ArrayList  
        for (int i = 0; i < count; i++)
         {/*if statement, if inputted code is equal to the current ArrayList objects code */
            if (strInput.equalsIgnoreCase(items.get(i).getCode()))
            { //Printing searched products details
                System.out.println("*************************************************************************"
                +"\nPRODUCT SEARCH RESULTS"
                + "\n*************************************************************************");
                System.out.printf("%-15s\t\t%s %n","PRODUCT CODE:" ,items.get(i).getCode());
                System.out.printf("%-15s\t\t%s %n","PRODUCT NAME:" ,items.get(i).getName());
                System.out.printf("%-15s\t%s %n","PRODUCT WARRANTY:",items.get(i).getWarrenty());
                System.out.printf("%-15s\t%s %n","PRODUCT CATEGORY:" ,items.get(i).getCatergory());
                System.out.printf("%-15s\t\t%s %1.0f %n","PRODUCT PRICE:" , "R", items.get(i).getPrice());
                System.out.printf("%-15s\t%d %n","PRODUCT STOCK LEVELS:" ,items.get(i).getStkLvl());
                System.out.printf("%-15s\t%s %n","PRODUCT SUPPLIER:" ,items.get(i).getSupplier());
                System.out.println("*************************************************************************");  
                break;
            }
         }
        //Output message for invalid input
          System.out.println("The product cannot be located. Invalid Product");
            
        }
     //Method to update to a product ______________________________________________________________________________________________________________
     public static void UpdateProduct()
     {//Declaring variables
       int input ;
       String strInput;
    //Declaring Scanner Object 
       Scanner in = new Scanner(System.in);
    /*do while loop, will loop while user input is empty*/
    do{//output to request user input 
        System.out.println("Please enter the product code to update: ");    
        strInput = in.next();
      }while(strInput.isEmpty());
     //For loop, iterates through entire ArrayList  
         for (int i = 0; i < count; i++)
         { /*if statement, if inputted code is equal to the current ArrayList 
             objects code */
            if (strInput.equalsIgnoreCase(items.get(i).getCode()))
               { 
                do{ //output to request user input 
                System.out.println("Update the product warranty? (y) Yes, (n) No");
                strInput = in.next();
                }while(strInput.isEmpty());                
                //if user input is equal to yes/ y char 
                if("y".equals(strInput))
                   { //output to request user input                           
                    System.out.print("Indicate the new product warranty. Enter(1) for 6 "
                    + "months or any other key for 2 years.");
                   strInput = in.next();
                   //try catch to set warranty to 6 months or 2 Years 
                   try{//Setting ReportData Object's warranty
                        items.get(i).setWarranty(Integer.parseInt(strInput));
                       }catch(NumberFormatException e)
                       {//Setting ReportData Object's warranty for any inputted key
                        items.get(i).setWarranty(2); 
                       }
                     //Output to indicate Product has been updated
                     System.out.println("Product details has been updated successfully!!!");   
                    } 
                /*do while loop, will loop while user input is empty*/
                    do{//output to request user input 
                      System.out.println("Update the product price? (y) Yes, (n) No");
                      strInput = in.next();
                     }while(strInput.isEmpty());
                     //if user input is equal to yes/ y char 
                      if("y".equals(strInput))
                      {
                       do{//output to request user input 
                        System.out.println("Enter the new price for PRODUCT");  
                       input = in.nextInt();
                        }while(input== 0); 
                       //Setting ArrayList Report Data Objects new price
                       items.get(i).setPrice(input);  
                    //Output to indicate Product has been updated
                    System.out.println("Product details has been updated successfully!!!");                     
                      }
                    do{//output to request user input 
                      System.out.println("Update the stock level ? (y) Yes, (n) No");
                      strInput = in.next();
                      }while(strInput.isEmpty());
                     //if user input is equal to yes/ y char  
                      if("y".equals(strInput))
                      {
                      do{//output to request user input 
                         System.out.println("Enter the new stock level for PRODUCT");  
                         input = in.nextInt();
                        }while(input== 0);
                       //Setting ArrayList Report Data Objects new stock level
                       items.get(i).setStkLvl(input);
                       //Output to indicate Product has been updated
                       System.out.println("Product details has been updated successfully!!!");                      
                      }
                  }
             }
     }
    //Method to delete a product ______________________________________________________________________________________________________________
    public static void DeleteProduct()
    {//Declaing String variable
        String strInput ;
    //Declaing Scanner Object
        Scanner in = new Scanner(System.in);
    /*do while loop, will loop while user input is empty*/
        do{//output to request user input 
         System.out.println("Please enter the product code to delete: ");
         strInput = in.next();
          }while(strInput.isEmpty());
       //For loop, iterates through entire ArrayList  
         for (int i = 0; i < count; i++)
            { /*if statement, if inputted code is equal to the current ArrayList 
             objects code */
                if (strInput.equalsIgnoreCase(items.get(i).getCode()))
                { //Subtracting Deleted Report Data Object's price from price total  
                   totalVal = totalVal - items.get(i).getPrice();
                  //Decrementing product count
                   count--;
                 //call to ArrayList method to remove Array List element
                   items.remove(i);
                //Output to indicate Product has been deleted
                   System.out.println("Product has been deleted successfully!!!");                      
                }
             }
    }
    //Method to display report ______________________________________________________________________________________________________________
    public static void DisplayReport()
    {//Printing All Product Details
        System.out.println("PRODUCT REPORT"
            +"\n=================================================================================================");
        //For loop, iterates through entire ArrayList
        for ( int i = 0 ; i < count ; i++)
        {
            System.out.println("PRODUCT "+ (i+1)
            + "\n-------------------------------------------------------------------------------------------------");
            System.out.printf("%-15s\t\t%s %n","PRODUCT CODE >>" ,items.get(i).getCode());
            System.out.printf("%-15s\t\t%s %n","PRODUCT NAME >>" ,items.get(i).getName());
            System.out.printf("%-15s\t%s %n","PRODUCT WARRANTY >>" ,items.get(i).getWarrenty());
            System.out.printf("%-15s\t%s %n","PRODUCT CATEGORY >>" ,items.get(i).getCatergory());
            System.out.printf("%-15s\t%s %1.0f %n","PRODUCT PRICE >>","R",items.get(i).getPrice());
            System.out.printf("%-15s\t%d %n","PRODUCT LEVEL >>" ,items.get(i).getStkLvl());
            System.out.printf("%-15s\t%s %n","PRODUCT SUPPLIER >>" ,items.get(i).getSupplier());
            System.out.println("\n-------------------------------------------------------------------------------------------------");
         }
           System.out.println("\n=================================================================================================");
          System.out.printf(" %s %d ","TOTAL PRODUCT COUNT: ", count);
           System.out.printf("%n %s %1s %.1f","TOTAL PRODUCT VALUE: ","R" , totalVal);
           System.out.printf("%n %s %1s %.0f","AVERAGE PRODUCT VALUE: ","R" , totalVal/count);
           System.out.println("\n=================================================================================================");
               
    }
    //Method to Exit Application ______________________________________________________________________________________________________________
     public static void ExitApplication()
    {//exit programming
      System.exit(0);
    }
   //Method to Save Product  ______________________________________________________________________________________________________________
    public static void SaveProduct( int cat)
    {//Instancing ReportData Object
      ReportData newProd = new ReportData(); 
      //if statement, ReportData Object's Warranty is equal to String
        if(it.getWarrenty().equals("6 Months"))
        {//Setting Method's ReportData Object's warranty 
            newProd.setWarranty(1);
        }//else, if ReportData Object's Warranty is equal to String
        else if(it.getWarrenty().equals("2 years"))
        {//Setting Method ReportData Object's warranty 
            newProd.setWarranty(2);
        }
        if(it.getWarrenty().equals("6 Months"))
            newProd.setCatergory(1);
        //Setting Method's ReportData Object's Details 
        newProd.setCatergory(cat);
        newProd.setCode(it.getCode());
        newProd.setName(it.getName());
        newProd.setPrice(it.getPrice());
        newProd.setStkLvl(it.getStkLvl());
        newProd.setSupplier(it.getSupplier());
      //Incrementing product count
        count++;
      //Adding new product price to total prices of all products
        totalVal = (int) (totalVal + it.getPrice());
      //Adding new ReportData object to items ArrayList
        items.add(newProd);       
    }
    //Method to Display Menu ______________________________________________________________________________________________________________ 
    public static void DisplayMenu()
    {//Declaring variables
        int input ;
    //Declaring Scanner Object 
        Scanner in = new Scanner(System.in);
    /*do while loop, will loop while user input is equal to 0 */
    do{
        System.out.print("BRIGHT FUTURE TECHNILOGIES APLICATION"
                + "\n*************************************"
                +"\nEnter (1) to lauch menu or any other key to exit"
                + "\nPlease select one of the following menu items: "
                + "\n(1) Capture a new product. "
                + "\n(2) Search for a product. "
                + "\n(3) Update a product. "
                + "\n(4) Delete a product. "
                + "\n(5) Print report."
                + "\n(6) Exit Application. ");
        input = in.nextInt();
     //Switch statement, to evaluate user selection 
            switch(input)
            {
            //caps no caps for naming of methods???
                case 1:
                   CaptureProduct();
                    break;
                case 2:
                   SearchProduct();
                    break;
                case 3:
                   UpdateProduct();
                    break;
                case 4:
                   DeleteProduct();
                    break;
                case 5:
                   DisplayReport();
                    break;
                case 6:
                    ExitApplication();
                    break; 
            }
         //output rto request user input
         System.out.println("Enter (1) to lauch menu or any other key to exit"); 
         input = in.nextInt();
        }while(input==1);
    //Method call to exist appliaction
    ExitApplication();
  }
}//end class  











