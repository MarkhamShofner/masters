/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment11_1;

import java.io.*;
import java.util.*;

/**
 * program that uses one of the Map classes to implement a contact list
 * @author mark8604
 */
public class Assignment11_1 {
    public static void main(String[] args) {
        Assignment11_1 contactListManager = new Assignment11_1();
        contactListManager.init();
    }

    public void init () {
        TreeMap<String, Contact> contactsTM = new TreeMap<String, Contact>();

        try ( FileReader fr = new FileReader("../ContactList.txt"))
        {
            int c;
            Scanner read = new Scanner (fr);
            read.useDelimiter(",");

            String firstName, lastName, phone, email;
            Contact contact;
            while (read.hasNext()) {
                firstName = read.next();
                lastName = read.next();
                phone = read.next();
                email= read.next();
                contact = new Contact(firstName, lastName, phone, email);
                contactsTM.put(contact.lastName, contact);
            }
        }
        catch (Exception e) {
            System.out.println("I/O Error: " + e);
        }

        Set<Map.Entry<String, Contact>> set = contactsTM.entrySet();
        for (Map.Entry<String, Contact> entry:set) {
            System.out.println(entry.getValue());
        }
    }

    public class Contact {
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        Contact (String first, String last, String phone, String email) {
            this.firstName = first;
            this.lastName = last;
            this.phone = phone;
            this.email = email;
        }

        public String toString() {
            return "{" + lastName + "}" + firstName + " " + phone + " " + email;
        }
    }

    /**
    * The list should be stored on your computer’s file system and entries sorted
    alphabetically according to a person’s last name.
    * The program should prompt the user for the name of the file where the information is stored,
    *   and allow the user to add a contact from the list,
    *   delete a contact from the list,
    *   and display the entire contact list.
    */
}
