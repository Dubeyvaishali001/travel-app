package com.example.voyageverse;

public class Helper {
    String Username,Password,cnfpwd;

    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username =Username;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword() {
        this.Password =Password;
    }
   public String getCnfpwd() {
        return cnfpwd;
   }
   public void setCnfpwd() {
        this.cnfpwd =cnfpwd;
   }
    public Helper(String username, String password, String cnfpwd) {
        Username = username;
        Password = password;
        this.cnfpwd = cnfpwd;
    }
    public Helper() {
    }
}
