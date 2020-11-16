package application.example.iiitmdocs;

public class Guide {

    public static char[] guide= {'a','a','a','a','a','a'};

    public static char d ='a';

    public void setGuide(int position,char Char){
        guide[position] = Char ;
    }
    public char[] getGuide(){

        return guide;
    }
    public void setdesignation(char ch){
        d = ch;
    }
    public char getdesignation(){
        return d;
    }
}
