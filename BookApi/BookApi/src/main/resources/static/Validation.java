package com;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validation { 
  
   
    public static boolean validateString(String name) 
    { 
  
        
    	Pattern pattern = Pattern.compile(new String ("^[a-zA-Z\\s]*$"));
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
             return false;
        }
}
    
    public static boolean isValidNum(String num) 
    { 
  
        String regex="^\\d{10}$";
    	
       
        if(num.matches(regex))
        {
            return true;
        }
        else
        {
             return false;
        }
}

}