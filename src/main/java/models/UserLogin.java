package models;

public class UserLogin {
    private String email;
    private String password;

    private UserLogin(UserLoginBuilder builder){
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public static UserLoginBuilder builder(){
        return new UserLoginBuilder();
    }

    public static class UserLoginBuilder{
       private String email;
       private String password;

        public UserLoginBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public UserLoginBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public UserLogin build(){
            return new UserLogin(this);
        }
    }
}
