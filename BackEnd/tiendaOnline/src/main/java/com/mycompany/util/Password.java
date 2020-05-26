/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

/**
 *
 * @author Enrique
 */
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.digest.DigestUtils;

public class Password {

    private static final Random RANDOM = new SecureRandom();
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    /**
     * Returns a random salt to be used to hash a password.
     *
     * @return a 16 bytes random salt
     */
    public static byte[] getNextSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    /**
     * Returns a salted and hashed password using the provided hash.<br>
     * Note - side effect: the password is destroyed (the char[] is filled with
     * zeros)
     *
     * @param password the password to be hashed
     * @param salt a 16 bytes salt, ideally obtained with the getNextSalt method
     *
     * @return the hashed password with a pinch of salt
     */
    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    /**
     * Returns true if the given password and salt match the hashed value, false
     * otherwise.<br>
     * Note - side effect: the password is destroyed (the char[] is filled with
     * zeros)
     *
     * @param password the password to check
     * @param salt the salt used to hash the password
     * @param expectedHash the expected hashed value of the password
     *
     * @return true if the given password and salt match the hashed value, false
     * otherwise
     */
    public static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash) {
        
        byte[] pwdHash = hash(password, salt);
//        pwdHash =rellenarBytes(hash(password, salt), 200) ;
        System.out.println(pwdHash.toString().length());
        System.out.println(pwdHash.length);
        Arrays.fill(password, Character.MIN_VALUE);
        boolean res = pwdHash.length == expectedHash.length;
        System.out.println("Tama�o esperado " + pwdHash.length);
        System.out.println("Tama�o real " + expectedHash.length);

        for (int i = 0; i < expectedHash.length; i++) {
            res &= pwdHash[i] == expectedHash[i];
        }
        return res;
    }

    /**
     * Generates a random password of a given length, using letters and digits.
     *
     * @param length the length of the password
     *
     * @return a random password
     */
    public static String generateRandomPassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int c = RANDOM.nextInt(62);
            if (c <= 9) {
                sb.append(String.valueOf(c));
            } else if (c < 36) {
                sb.append((char) ('a' + c - 10));
            } else {
                sb.append((char) ('A' + c - 36));
            }
        }
        return sb.toString();
    }

    public static byte[] rellenarBytes(byte[] hash, int tamano) {
        byte[] newHash = new byte[tamano];
        for (int i = 0; i < tamano; i++) {
            if (i < hash.length) {
                newHash[i] = hash[i];
            } else {
                newHash[i] = 0;
            }
        }
        return newHash;
    }

    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String contra;
        password = DigestUtils.sha256Hex(password);
        contra = DigestUtils.shaHex(password);
        contra =  saltearCadena(contra,password);
        contra = DigestUtils.md5Hex(contra);
        return contra;
    }

    public static String saltearCadena(String cadena1, String cadena2) {
        int logMax = cadena1.length() > cadena2.length() ? cadena1.length() : cadena2.length();
        StringBuilder cadenaSalteada = new StringBuilder();
        for (int i = 0; i < logMax; i++) {
            if (i < cadena1.length()) {
                cadenaSalteada.append(cadena1.charAt(i));
            }
            if (i < cadena2.length()) {
                cadenaSalteada.append(cadena2.charAt(i));
            }
        }
        return cadenaSalteada.toString();
    }
    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[32];
        sr.nextBytes(salt);
        for (int i = 0; i < 32; i++) {
            System.out.print(salt[i] & 0x00FF);
        }
        return Base64.encode(salt);
    }

    public static String quitarCaracteresEspeciales(String cadena) {
        StringBuilder nuevaCadena = new StringBuilder();
        for (char c : cadena.toCharArray()) {
            int valorAscii = (int) c;
            if ((valorAscii > 47 && valorAscii < 58) || (valorAscii > 65 && valorAscii < 91) || (valorAscii > 96 && valorAscii < 122)) {
                nuevaCadena.append(c);
            } else {
                nuevaCadena.append("A");
            }
        }
        return nuevaCadena.toString();
    }
}
