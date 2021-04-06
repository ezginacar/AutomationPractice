package helpers;

import static utils.LogUtil.logger;

public class JavaHelpers {

    public static String onlyTheFirtsLetter(String text){
        String ch = text.substring(0,1).toUpperCase();
        String text2 = text.substring(1).toLowerCase();
        text2 = ch + text2;
        logger.info(String.format("' %s ' is arranged as ' %s '", text, text2 ));
        return  text2;
    }


    public static void main(String[] args) {
        onlyTheFirtsLetter("T-SHIRTS");
    }
}
