package main.java.com.example.cse360;

public class Invitation {
    private String invitationCode;
    private UserRole role;

    public Invitation(String invitationCode, UserRole role) {
        this.invitationCode = invitationCode;
        this.role = role;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public UserRole getRole() {
        return role;
    }
}