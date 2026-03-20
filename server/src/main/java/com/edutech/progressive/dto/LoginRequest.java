package com.edutech.progressive.dto;

<<<<<<< HEAD
public class LoginRequest {
   private String username;
   private String password;

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
=======
import org.springframework.lang.NonNull;

public class LoginRequest {
   @NonNull
   private String username;
   @NonNull
   private String password;
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public LoginRequest() {
   }
   public LoginRequest(String username, String password) {
      this.username = username;
      this.password = password;
   }

   


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}