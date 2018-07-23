import java.util.List;
import java.util.Scanner;

public class Magaret_Dayhoff_socringMatrix {
    private String[] scoringSource;
    private int sourceDepth;
    private char[] syllabus;  //elements in this array need to be sorted in order of English alphabet

    //the three arrays below contains data in order of English alphabet
    private float[] observedFreq;
    private float[] expectedFreq;
    private float[] presentFreq;
    private float[] logLokelyhood_ratio;


    public Magaret_Dayhoff_socringMatrix(String type){
        switch (type){
            case "homework": new Magaret_Dayhoff_socringMatrix(9);
            default:
        }
    }

    /**
     * defult constructor for homework
     * @param sourceDepth
     */
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
            presentFreq=new float[syllabus.length];
            expectedFreq=new float[((1+syllabus.length)*syllabus.length/2)];
            observedFreq=new float[expectedFreq.length];
            logLokelyhood_ratio=new float[expectedFreq.length];
            for(int i=0;i<observedFreq.length;i++)
                observedFreq[i]=0;
        }catch (Exception e){

        }finally {
            System.out.println("All inputs are accepted, object constructed");
        }
    }

    /**
     * the main method for matrix calculation
     */
    public void scoringMatrix_calculation(){
        presentFreq();
        expectFreq();
        observedFreq();
        logLikelyhood_ratio();
    }

    /**
     * presented frequency calculation
     */
    private void presentFreq(){
        for(int i=0;i<syllabus.length;i++){
            char character=syllabus[i];
            int tempCount=0;
            for(int k=0;k<scoringSource.length;k++)
                for(int m=0;m<scoringSource[0].length();m++){
                    if(scoringSource[k].charAt(m)==character) tempCount++;
                }
            presentFreq[i]=tempCount/(scoringSource.length*scoringSource[0].length());
        }
    }

    /**
     * expected frequency calculation
     */
    private void expectFreq(){
        for(int i=0;i<syllabus.length;i++)
            for(int j=i;j<syllabus.length;j++){
                expectedFreq[i+j]=presentFreq[i]*presentFreq[j];
            }
    }

    /**
     * observed frequency calculation
     */
    private void observedFreq(){
        //int[] tempCount=new int[expectedFreq.length];
        for(int m=0;m<syllabus.length;m++)
            for(int n=m;n<syllabus.length;n++){
                int tempCount=0;
                for(int i=0;i<scoringSource.length;i++)
                    for(int j=0;j<scoringSource[0].length();j++)
                        for(int k=i;k<scoringSource.length;k++){
                            if(scoringSource[i].charAt(j)==syllabus[m]&&scoringSource[k].charAt(j)==syllabus[n])
                                tempCount++;
                        }
                observedFreq[m+n]=tempCount;
            }
    }

    /**
     * log likelihood ratio calculation
     */
    private void logLikelyhood_ratio(){
        for(int i=0;i<logLokelyhood_ratio.length;i++){
            logLokelyhood_ratio[i]=(float)(2*(Math.log(observedFreq[i]/expectedFreq[i])));
            System.out.println(logLokelyhood_ratio[i]);
        }
    }
}
