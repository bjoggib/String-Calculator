	package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("[")){
			String newDelim = "";
			for(int i = 0; i < text.length(); i++){
				if(text.charAt(i) == '['){
					newDelim += multDelim(text, i+1);
				}
			}
			int i = 0;
			while(!Character.isDigit(text.charAt(i))){
				i++;
			}
			return sum(splitNumbers(text.substring(i),newDelim));	
		}
		else if(text.contains("/") || text.contains(";")){
			String temp = "";
			for(int i = 0; i < text.length(); i++){
				if(text.charAt(i) != '/' && text.charAt(i) != ';'){
					temp += Character.toString(text.charAt(i));
				}
			}
			return sum(splitNumbers(temp, ""));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text, ""));
		}
		return 1;
		
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delim){
	    String temp;
	    if(delim == ""){
	    	temp = ",|\n";
	    }else{
	    	temp = ",|\n" + delim;
	    }
	    return numbers.split(temp);
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

    private static String multDelim(String text, int index){
    	String delim = "|";
    	int i = index;
    	while(text.charAt(i) != ']'){
    		if(text.charAt(i) == '%'){
    			delim += Character.toString(text.charAt(i)); 
    		}else{
    			delim += "\\" + Character.toString(text.charAt(i));	
    		}
    		i++;
    	}
    	return delim;
    }
}