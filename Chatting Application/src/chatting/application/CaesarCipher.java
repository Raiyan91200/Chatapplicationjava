package chatting.application;

public class CaesarCipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    // Encrypts the input text using Caesar Cipher
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(shiftChar(c, shift));
            } else {
                result.append(c); // Leave special characters unchanged
            }
        }
        return result.toString();
    }


    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(shiftChar(c, -shift));
            } else {
                result.append(c); // Leave special characters unchanged
            }
        }
        return result.toString();
    }

    // Helper method to shift characters
    private char shiftChar(char c, int shift) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) ((c - base + shift + 26) % 26 + base);
        } else if (Character.isDigit(c)) {
            return (char) ((c - '0' + shift + 10) % 10 + '0');
        } else {
            return c;
        }
    }

   
  public String vigenereEncrypt(String text, String key) {
    StringBuilder result = new StringBuilder();
    key = key.toUpperCase(); 
    int keyIndex = 0;

    for (char c : text.toCharArray()) {
        if (Character.isLetter(c)) {
           
            int shift = key.charAt(keyIndex % key.length()) - 'A';
            result.append(shiftChar(c, shift));
            keyIndex++; 
        } else {
            result.append(c); // Leave special characters unchanged
        }
    }
    return result.toString();
}

public String vigenereDecrypt(String text, String key) {
    StringBuilder result = new StringBuilder();
    key = key.toUpperCase(); // Use uppercase for consistency
    int keyIndex = 0;

    for (char c : text.toCharArray()) {
        if (Character.isLetter(c)) {
            
            int shift = key.charAt(keyIndex % key.length()) - 'A';
            result.append(shiftChar(c, -shift)); 
            keyIndex++; 
        } else {
            result.append(c); // Leave special characters unchanged
        }
    }
    return result.toString();
}
}
