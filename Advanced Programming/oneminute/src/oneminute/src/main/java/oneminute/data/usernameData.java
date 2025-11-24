package oneminute.data;

import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import oneminute.classes.Player;

public class usernameData {

    public static String fileName = "src/main/resources/oneminute/database/Player.txt";
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "MySuperSecretKey".getBytes(); // Must be 16 bytes for AES-128

    // Load player data from the database
    public static List<Player> loadPlayerDataFromDatabase() {
        List<Player> playerList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] playerData = line.split(",");
                if (playerData.length >= 2) {
                    String playerUserId = playerData[0].trim();
                    String passwordOrEncrypted = playerData[1].trim();
                    String playerPassword;

                    if (isBase64Encoded(passwordOrEncrypted)) {
                        try {
                            playerPassword = decrypt(passwordOrEncrypted);
                            System.out.println("Decryption successful for user: " + playerUserId);
                        } catch (Exception e) {
                            playerPassword = passwordOrEncrypted; // Treat as plain text if decryption fails
                            System.out.println("Decryption failed for user: " + playerUserId + ". Treating password as plain text.");
                        }
                    } else {
                        playerPassword = passwordOrEncrypted;
                        System.out.println("Plain text password detected for user: " + playerUserId);
                    }

                    Player newPlayer = new Player(playerUserId, playerPassword);
                    playerList.add(newPlayer);
                } else {
                    System.err.println("Invalid data format in Player.txt: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading player data from Player.txt: " + e.getMessage());
            e.printStackTrace();
        }
        return playerList;
    }

    public static boolean isUserIdRegistered(String userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] playerData = line.split(",");
                if (playerData.length >= 1) {
                    String playerUserId = playerData[0].trim();
                    if (playerUserId.equals(userId)) {
                        return true;
                    }
                } else {
                    System.err.println("Invalid data format in Player.txt: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading player data from Player.txt: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static void updatePassword(String userId, String newPassword) {
        System.out.println("Updating password for user ID: " + userId);
        List<Player> players = loadPlayerDataFromDatabase();
        for (Player player : players) {
            if (player.getUserId().equals(userId)) {
                System.out.println("Updating password from '" + player.getPassword() + "' to '" + newPassword + "'");
                player.setPassword(newPassword); // Store plain text password temporarily
                savePlayerDataToDatabase(players); // Save updated passwords
                break;
            }
        }
        System.out.println("Password update completed.");
    }

    public static void savePlayerDataToDatabase(List<Player> playerList) {
        try (FileWriter account = new FileWriter(fileName, false)) {
            PrintWriter accountWriter = new PrintWriter(account);

            for (Player player : playerList) {
                accountWriter.println(player.getUserId() + "," + encrypt(player.getPassword()));
            }
            accountWriter.close();
        } catch (IOException e) {
            System.err.println("Error saving player data to Player.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Initialize a Player object that can be used for reference elsewhere
    public static Player initPlayerData = new Player(null, null);

    // Encrypt a string using AES algorithm
    public static String encrypt(String value) {
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedValue = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedValue);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting", e);
        }
    }

    // Decrypt a string using AES algorithm
    public static String decrypt(String value) {
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedValue = Base64.getDecoder().decode(value);
            byte[] decryptedValue = cipher.doFinal(decodedValue);
            return new String(decryptedValue);
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting", e);
        }
    }

    private static Key generateKey() {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }

    private static boolean isBase64Encoded(String value) {
        try {
            Base64.getDecoder().decode(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
