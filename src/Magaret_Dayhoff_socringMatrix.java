public class Magaret_Dayhoff_socringMatrix {
    String[] scoringSource;
    int sourceDepth;


    public Magaret_Dayhoff_socringMatrix(String type){
        switch (type){
            case "homework": new Magaret_Dayhoff_socringMatrix(9);
            default:
        }
    }
    public Magaret_Dayhoff_socringMatrix(int sourceDepth){
        this.sourceDepth=sourceDepth;
    }
}
