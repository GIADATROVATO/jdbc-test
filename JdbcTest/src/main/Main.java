package main;

import dao.UserDAO;
import entity.User;
import service.UserService;

public class Main {
	public static void main(String[] args){
		
		UserService service = new UserService();			// richiamo user service invece del dao 

        try {
        	
        	User[] utenti = {
            // creazione di un nuovo utente 
        			new User("Mario Rossi","mario@example.com"), 
                    new User("Luigi Bianchi", "luigi@example.com"),
                    new User("Giulia Verdi", "giulia@example.com"),
                    new User("Anna Neri", "anna@example.com"),
                    new User("Paolo Gialli", "paolo@example.com")
              		};
        	for(User u: utenti) {
        		service.createUser(u);
        		System.out.println("inserito nuovo utente: " +u.getName());	
        	}
            
      /*
       * TEST: recupero utente per id 
       */
            User found = service.getProfile(1);
            if( found != null) {
            	System.out.println("Utente trovato: " + found.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
