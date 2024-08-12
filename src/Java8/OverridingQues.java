package Java8;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Addition{

    public String add(double d, String s){
        return Math.round(d)+s;
    }

    public String add(double d, double dd){

        return getRoundByDecimal(d,2)+getRoundByDecimal(dd,2)+"";
    }

    private double getRoundByDecimal(double d, int place){
      return  BigDecimal.valueOf(d).setScale(place, RoundingMode.FLOOR).doubleValue();
    }

}

public class OverridingQues {
    public static void main(String[] args) {
        Addition a1 = new Addition();
        System.out.println(a1.add(1,"hello"));
        Addition a2 = new Addition();
        System.out.println(a2.add(2.759,3.241));
        System.out.println(String.format("%.2f", 3.548));
        
    }
}
