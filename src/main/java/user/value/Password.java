package user.value;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Password extends ValueObject<String> {
        private static final int SALT_LENGTH = 16; // 16 bytes
        private static final int ITERATIONS = 65536;
        private static final int KEY_LENGTH = 256; // bits
        private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

        public Password(String password) {
            super(hashPassword(password.toCharArray(), generateSalt()));
        }

        // Генерация соли
        private static byte[] generateSalt() {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);
            return salt;
        }

        // Хеширование пароля с использованием соли
        private static String hashPassword(char[] password, byte[] salt) {
            try {
                PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
                SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
                byte[] hash = skf.generateSecret(spec).getEncoded();

                // Возвращаем Base64(соль):Base64(хеш)
                return Base64.getEncoder().encodeToString(salt) + ":" +
                        Base64.getEncoder().encodeToString(hash);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException("Ошибка при хешировании пароля", e);
            }
        }

        // Проверка соответствия пароля хешу
        public static boolean verifyPassword(char[] password, String stored) {
            String[] parts = stored.split(":");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Неверный формат хеша");
            }

            byte[] salt = Base64.getDecoder().decode(parts[0]);
            String newHash = hashPassword(password, salt);
            return stored.equals(newHash);
        }
    }
