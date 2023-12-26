package usersPackage;

import java.util.Vector;
import researchPackage.ResearchJournal;
/**
 * The User class represents a basic user in the system with common attributes and functionalities.
 * It is an abstract class that implements the Comparable interface.
 */
public abstract class User implements Comparable<User>
{   /** The unique identifier for the user. */
    public int id;
    
    /** The first name of the user. */
    public String name;
    
    /** The last name of the user. */
    public String lastName;
    
    /** The hashed password of the user. */
    private int password;
    
    /** The preferred language of the user. */
    public Languages language;
    
    /** The list of research journals to which the user is subscribed. */
    public Vector<ResearchJournal> subscriptions = new Vector<>();;
    
    /** Default language for a new user. */
    {
        language = Languages.EN;
    }

    /**
     * Default constructor for the User class.
     */
    public User()
    {

    }

    /**
     * Constructor for creating a user with a specified name.
    *
    * @param name The first name of the user.
    */
    public User(String name) {
        this.name = name; 
    }

    /**
     * Constructor for creating a user with specified first and last names.
     *
     * @param name     The first name of the user.
     * @param lastName The last name of the user.
     */
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        }
   

    /**
     * Constructor for creating a user with specified first and last names and ID.
     *
     * @param name     The first name of the user.
     * @param lastName The last name of the user.
     * @param id       The unique identifier for the user.
     */
    public User(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * Gets the unique identifier for the user.
    *
    * @return The user's ID.
    */
    public int getId() {
        return id;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The user's first name.
     */
    public String getName() {
        return name;
    }

    
    /**
     * Sets the first name of the user.
     *
     * @param name The new first name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        
    }


    /**
     * Sets a new password for the user.
     *
     * @param oldPassword The old password for verification.
     * @param newPassword The new password to be set.
     */
    public void setPassword(String oldPassword, String newPassword) {
        if (oldPassword.hashCode() != password) {
            System.out.println("Incorrect old password");
            return;
        }

        password = newPassword.hashCode();
    }

    /**
     * Sets the preferred language of the user.
     *
     * @param language The new preferred language.
     */
        public void setLanguage(Languages language) {
        this.language = language;
    }    
    

    	/**
         * Subscribes the user to a research journal.
         *
         * @param r The research journal to subscribe to.
         */
    public void subscribeToJournal(ResearchJournal r) {
    	r.addObserver(this);
    }
    
    /**
     * Unsubscribes the user from a research journal.
     *
     * @param r The research journal to unsubscribe from.
     */
    public void unsubscribeToJournal(ResearchJournal r) {
    r.removeObserver(this);	
    }
    public boolean equals(User o) {
        if (this == o) return true;
        return id == o.getId();
        /**
         * Checks if the given object is equal to the user.
         *
         * @param o The object to compare with the user.
         * @return true if the objects are equal, false otherwise.
         */
    }
    

    /**
     * Compares this user to another user based on their IDs.
     *
     * @param o The user to compare with.
     * @return A negative integer, zero, or a positive integer as this user is less than, equal to,
     *         or greater than the specified user.
     */
    public int compareTo(User o) {
        if (id > o.getId()) return 1;
        if (id < o.getId()) return -1;
        return 0;
    }


	/**
     * Returns a string representation of the user.
    *
    * @return A string containing the user's ID, first name, and last name.
    */
    public String toString() { 
            return id + " " + name + " " + lastName;
    }
}
