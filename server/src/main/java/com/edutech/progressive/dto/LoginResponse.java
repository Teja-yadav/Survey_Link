package com.edutech.progressive.dto;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
   private String token;
   private String roles;
   private Integer userId;

   @JsonCreator
   public LoginResponse(@JsonProperty("token") String token , String roles, Integer userId) {
      this.token = token;
      this.roles=roles;
      this.userId=userId;
   }


   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }
   public String getRoles()
   {
      return this.roles;
   }

   public void setRole(String roles)
   {
      this.roles = roles;
   }
   public void setUserId(Integer userId)
   {
      this.userId=userId;
   }

   public long getUserId()
   {
      return this.userId;
   }
}
=======
public class LoginResponse {


   private String token;
   private String roles;
   private Integer userId;
   public String getToken() {
      return token;
   }
   public void setToken(String token) {
      this.token = token;
   }
   public String getRoles() {
      return roles;
   }
   public void setRoles(String roles) {
      this.roles = roles;
   }
   public Integer getUserId() {
      return userId;
   }
   public void setUserId(Integer userId) {
      this.userId = userId;
   }
   public LoginResponse(String token, String roles, Integer userId) {
      this.token = token;
      this.roles = roles;
      this.userId = userId;
   }
   public LoginResponse() {
   }
   public LoginResponse(String token) {
      this.token = token;
   }

   

   
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
