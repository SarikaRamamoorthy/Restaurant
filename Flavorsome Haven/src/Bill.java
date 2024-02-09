public class Bill {
    static int[] price = new int [110];
    static String[] price1 = new String [110];
    static String[] name = new String [110];
    static int index = 0 , total = 0;
    static String total1;
    public static boolean specialCustomerFlag = false;

    public void billGeneration(String[] name,int[] price){
        int length = price.length;
        for(int i=0;i<length;i++,Bill.index++){
            if(price[i] == 0)
            break;
            Bill.name[Bill.index] = name[i];
            Bill.price[Bill.index] = price[i];
        }
    }

    public void billDisplay(){
        int length = name.length;
        System.out.println("       +==========================================+==================+    ");
        System.out.println("       |                  ITEM                    |      PRICE       |    ");
        System.out.println("       |==========================================|==================+    ");
        System.out.println("       |                                          |                  |    ");
        for(int i=0;i<length;i++){
            if(price[i] == 0)
            break;
            name[i] = String.format("%-37s",name[i]);
            total += price[i];
            price1[i] = String.format("%-12s",price[i]+"");
            System.out.println("       |     "+name[i]+"|      "+price1[i]+"|");
        }
        total1 = String.format("%-12s",total+"");
        System.out.println("       |__________________________________________|__________________|    ");
        System.out.println("       |                                          |                  |    ");
        System.out.println("       |               "+"TOTAL"+"                      |      "+total1+"|    ");
        System.out.println("       |__________________________________________|__________________|    ");
        System.out.println();
        if(specialCustomerFlag){
            System.out.println("       Congrats!! You avail 10% coupon");
            total -= (10*total)/100;
            System.out.println("       Your bill amount is "+total);
        }
        else{
            System.out.println("       OOPS!! No coupons available");
        }
    }
}
