	package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("/") || text.contains(";")){
			String temp = "";
			for(int i = 0; i < text.length(); i++){
				if(text.charAt(i) != '/' && text.charAt(i) != ';'){
					temp += Character.toString(text.charAt(i));
				}
			}
			return sum(splitNumbers(temp));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[,\n]");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        int pos = 0;
        for(String number : numbers){
		    if(toInt(number) < 0){
		    	String msg = "Negatives not allowed: ";
		    	for(int i = pos; i < numbers.length; i++){
		    		if(toInt(numbers[i]) < 0){
		    			msg += numbers[i] + ", ";
		    		}
		    	}
		    	throw new IllegalArgumentException(msg);
		    } 
		    else {
		    	if(toInt(number) < 1001){
		    		total += toInt(number);
		    	}
		    	pos++;
			}
		}	
		return total;
    }
}