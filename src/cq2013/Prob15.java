package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by RobertPC on 8/7/2017.
 */
public class Prob15 {
    //String to filePath
    public static final String filePath = "inputs/2013/Prob15.in.txt";

    public static class User{
        //Instance variables
        private String username;
        private String salt;
        private String digest;

        /**
         * Constructs a User object
         *
         * @param username the username for that specific instantiation
         * @param salt the salt for that specific instantiation
         * @param digest the digest for that specific instantiation
         */
        public User(String username, String salt, String digest){
            this.username = username;
            this.salt = salt;
            this.digest = digest;
        }

        /**
         * getter method to return the username
         *
         * @return the username of the current instantiation
         */
        public String getUsername(){ return username; }

        /**
         * getter method to return the salt
         *
         * @return the salt of the current instantiation
         */
        public String getSalt(){ return salt; }

        /**
         * getter method to return the digest
         *
         * @return the digest of the current instantiation
         */
        public String getDigest(){ return digest; }
    }

    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab amtLogins
            int amtLogins = Integer.parseInt(br.readLine());
            //Create hashmap for username and user object to retrieve an instantiation easier
            Map<String, User> userMappings = new HashMap<>();
            //Create array of User objects
            User[] users = new User[amtLogins];
            //Loop through amtLogins
            for(int i = 0; i < amtLogins; i++){
                //Grab that line
                inLine = br.readLine();
                //Split into tokens
                String[] tokens = inLine.split(", ");
                //Set name
                String name = tokens[0];
                //Split into salt and digest
                String[] saltAndDigest = tokens[1].split(":");
                //Set salt and digest
                String salt = saltAndDigest[0];
                String digest = saltAndDigest[1];
                //Add that into the users array
                users[i] = new User(name, salt, digest);
                //Add that into the hashmap
                userMappings.put(name, users[i]);
            }
            //Skip that empty line
            br.readLine();
            //Now loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Create new MessageDigest instance
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Split into tokens
                String[] tokens = inLine.split(", ");
                //If the name we just got exists in the users array, continue
                if(exists(users, tokens[0])){
                    //Use our hashmap to retrieve the current user based off the name(we already know that they exist)
                    User curUser = userMappings.get(tokens[0]);
                    //Concatenate the salt and password together into a string
                    String concatSaltAndPass = curUser.getSalt().concat(tokens[1]);
                    //Transform that string into an array of bytes using the UTF-8 encoding
                    byte[] byteArray = concatSaltAndPass.getBytes(StandardCharsets.UTF_8);
                    //Update the MessageDigest
                    md.update(byteArray);
                    //Retrieve hashed bytes array from the MessageDigest instance
                    byte[] hashedBytes = md.digest();
                    //Create new StringBuffer
                    StringBuffer buf = new StringBuffer();
                    //Loop through hashed bytes array
                    for(int i = 0; i < hashedBytes.length; i++){
                        //Code given in problem
                        buf.append(Integer.toHexString((hashedBytes[i] >>> 4) & 0x0F));
                        buf.append(Integer.toHexString(0x0F & hashedBytes[i]));
                    }
                    //Assign hashed string(use this to check with the digest for the user to authenticate)
                    String hashedString = buf.toString();
                    //Check if the digest is equals to the current user's digest
                    if(curUser.getDigest().equals(hashedString)){
                        System.out.println(tokens[0] + " Authorized");
                    }
                    else{
                        System.out.println(tokens[0] + " Authorized Denied");
                    }
                }else{
                    //If they don't exist, straight up deny them
                    System.out.println(tokens[0] + " Denied");
                }
            }
            //Clean up
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * returns a boolean based on if a user in the array's username is equal to the string
     *
     * @param users the array of users to check
     * @param s the username you are checking for
     * @return true of false based on if the user actually exists
     */
    public static boolean exists(User[] users, String s){
        for(User u : users){
            if(u.getUsername().equals(s)){
                return true;
            }
        }
        return false;
    }
}