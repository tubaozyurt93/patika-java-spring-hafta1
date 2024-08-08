package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreateHashPassword {

    // Şifreyi hashler
    public static String hashPassword(String plainPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(plainPassword.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}