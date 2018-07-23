import java.util.List;
import java.util.Scanner;

public class Magaret_Dayhoff_socringMatrix {
    String[] scoringSource;
    int sourceDepth;
    char[] syllabus;


    public Magaret_Dayhoff_socringMatrix(String type){
        switch (type){
            case "homework": new Magaret_Dayhoff_socringMatrix(9);
            default:
        }
    }

    public Magaret_Dayhoff_socringMatrix(int sourceDepth){
        this.sourceDepth=sourceDepth;
        scoringSource=new String[sourceDepth];
        Scanner s=new Scanner(System.in);
        try{
            System.out.println("Please input syllabus: (separate them with space, end inputting with enter)");
            String rawSyllabus=s.nextLine();
            rawSyllabus.replaceAll(" ","");
            syllabus=new char[rawSyllabus.length()];
            for(int i=0;i<rawSyllabus.length();i++){
                syllabus[i]=rawSyllabus.charAt(i);
            }
            System.out.println("Please input source: (separate them with enter)");
            for(int i=0;i<scoringSource.length;i++) scoringSource[i]=s.nextLine();
        }catch (Exception e){

        }finally {
            System.out.println("All inputs are accepted, object constructed");
        }
    }

    private void 
}
