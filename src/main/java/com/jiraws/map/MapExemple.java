package com.jiraws.map;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiraws.person.Person;

public class MapExemple {
	
	/**
	 *  Author: @JirAWS
	 *  
	 *  Simple example of Map use case: grouping a User List by their birth month date
	 * 
	 *  You can follow & share my social medias below :)
	 *  
	 *  ► @Discord: https://discord.gg/HDQG7KfSsn
	 *	► @Formations Java & AWS: https://www.jiraws.com/formations
	 *	► @Coaching GRATUIT: https://www.jiraws.com/session-consei...
	 *	► @Coaching Java & AWS: https://www.jiraws.com/coaching
	 *	► @Newsletters JirAWS: https://www.jiraws.com/newsletters
	 *
	 */

	
	public static void main(String[] args) {
		
		/**
		 *  The following code is @Overdetailed for beginner - Many comments & Many lines that could be optimized
		 */
		
		// Map that will contain dispatched users per month of birth
		Map<String, ArrayList<Person>> birthMonthPersonMap = new HashMap<>();
		
		// Place them into a List
		List<Person> personList = generatePersonList();
		
		for(Person currentPerson : personList) {
			
			// Load current birthday date as a LocalDate object 
			LocalDate localDate = currentPerson.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			// Get the current month name (JANUARY, FEBRUARY, etc...)
			String currentMonth = localDate.getMonth().toString();
			
			// Does our map already contain the current month of birth?
			if(birthMonthPersonMap.containsKey(currentMonth) == false) {
				
				// Add the current month to our Map with a default empty List
				birthMonthPersonMap.put(currentMonth, new ArrayList<Person>());
			}
			
			/**
			 *  Our Map is like Map<String, ArrayList<Person>> so if we do "Map.get(month)" on it, the return value is an ArrayList (a List)
			 *  Then, as we get a List, we can directly do the ".add" method, to add the current analyzed Person inside it
			 *  
			 *  (With your cursor you can aim on the "get(currentMonth)" method below, you'll see that the "return type" is "ArrayList<Person>")
			 */
			birthMonthPersonMap.get(currentMonth).add(currentPerson);
		}
		
		/**
		 *  Displaying in the console the final result
		 *  
		 *  Expected output is
		 *  - February: [Margaret]
		 *  - June: [Graven]
		 *  - July: [Elon]
		 *  - August: [JirAWS, Cocadmin]
		 *  
		 */
		System.out.println(birthMonthPersonMap);
	}
	
	@SuppressWarnings("deprecation")
	public static List<Person> generatePersonList() {
		
		// Create some random users
		Person firstPerson  = new Person("LEARNING"		 , "JirAWS"	  , new Date(1994, 7, 30));
		Person secondPerson = new Person("DEVELOPPEMENT" , "Graven"	  , new Date(1997, 5, 24));
		Person thirdPerson  = new Person("ADMIN"		 , "Cocadmin" , new Date(1960, 7, 2 ));
		Person fourthPerson = new Person("MUSK"			 , "Elon"	  , new Date(1971, 6, 29));
		Person fifthPerson  = new Person("HAMILTON" 	 , "Margaret" , new Date(1985, 1, 15));
		
		// Return a List containing our users
		return Arrays.asList(firstPerson, secondPerson, thirdPerson, fourthPerson, fifthPerson);
	}

}
