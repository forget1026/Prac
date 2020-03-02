package com.example.demo.dto;

public class UserDto {
     private int no;
     private int age;
     private String username;
     private String gender;

     public int getNo() {
         return no;
     }

     public void setNo(int no) {
         this.no = no;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getGender() {
         return gender;
     }

     public void setGender(String gender) {
         this.gender = gender;
     }

     @Override
     public String toString() {
         return "UserDto [age=" + age + ", gender=" + gender + ", no=" + no + ", username=" + username + "]";
     }
}