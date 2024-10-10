package main.java.com.example.cse360;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OneTimePasswordManager {
    // Map to store OTPs with their expiry times
    private Map<String, LocalDateTime> otpStore = new HashMap<>();
    private static final int OTP_LENGTH = 6; // Length of the OTP
    private static final int EXPIRY_MINUTES = 15; // OTP expiration time in minutes

    // Method to generate a new OTP
    public String generateOTP() {
        String otp = generateRandomOTP();
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(EXPIRY_MINUTES);
        otpStore.put(otp, expiryTime);
        return otp;
    }

    // Method to generate a random OTP
    private String generateRandomOTP() {
        Random random = new Random();
        StringBuilder otpBuilder = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otpBuilder.append(random.nextInt(10)); // Append a random digit
        }
        return otpBuilder.toString();
    }

    // Method to validate the OTP
    public boolean validateOTP(String otp) {
        LocalDateTime expiryTime = otpStore.get(otp);
        if (expiryTime != null) {
            // Check if the OTP is still valid (not expired)
            if (LocalDateTime.now().isBefore(expiryTime)) {
                otpStore.remove(otp); // Remove OTP after successful validation
                return true;
            }
            otpStore.remove(otp); // Remove expired OTP
        }
        return false; // OTP is invalid
    }
}
