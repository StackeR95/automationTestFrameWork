package General;

public class Utilities {

    public static  int extractNumber (String text) {
        String output = "" ;
        for ( int i =0  ; i < text.length() ; i ++ ){
            if((int)text.charAt(i)>=48 &&(int)text.charAt(i)<=57 )
                output += text.charAt(i) ;
        }
        if(output.equals(""))
            return -1;
        return Integer.parseInt(output) ;
    }
}
