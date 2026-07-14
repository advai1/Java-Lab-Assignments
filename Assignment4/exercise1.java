package Assignment4;

//========== Student Marks Wrapper ==========

public class exercise1 {
    public static void main(String[] args) {
        
        System.out.println("--- Student Marks ---\n");

        //marks as String
        String mark1Str = "67";
        String mark2Str = "98";
        String mark3Str = "78";

        //convert to Integer
        Integer mark1 = Integer.parseInt(mark1Str);
        Integer mark2 = Integer.parseInt(mark2Str);
        Integer mark3 = Integer.parseInt(mark3Str);

        int totalMarks = mark1 + mark2 + mark3;


        System.out.println("CAO Marks:\t" + mark1);
        System.out.println("LA Marks:\t" + mark2);
        System.out.println("PP Marks:\t" + mark3);
        System.out.println("-------------------------");
        System.out.println("Total Marks:\t" + totalMarks);
    }
}
