//Andreas Beimler
 
public class Encryption {
    
    public static int nextInt(int a, int b, int m, int x) {
        x = (a * x + b) % m;
        return x;
    }

    public static void printCharArray(char[] letter) {
        System.out.print("\"");
        for (char c : letter) {
            System.out.print(c);
        }
        System.out.print("\"\n");
    }

    public static int[] encrypt(char[] letters, int[] keys) {
        int[] encrypted_letters = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if (i == 0) {
                encrypted_letters[i] = ((int)letters[i]) ^ keys[i];
            } else {
                encrypted_letters[i] = ((int)letters[i]) ^ keys[i] ^ encrypted_letters[i - 1];
            }
        }
        return encrypted_letters;
    }

    public static char[] decrypt(int[] letters, int[] keys) {
        char[] decrypted_letters = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if (i == 0) {
                decrypted_letters[i] = (char)(letters[i] ^ keys[i]);
            } else {
                decrypted_letters[i] = (char)(letters[i] ^ keys[i] ^ letters[i - 1]);
            }
        }
        return decrypted_letters;
    }

    public static void main(String[] args) {
        //nextInt inatial values
        final int x0 = 3;
        final int a = 7;
        final int b = 28;
        final int m = 256;
        int x = x0;

        //example chars
        char[] letters = {'H','e','l','l','o',' ','W','o','r','l','d',};
        System.out.print("Char array example: ");
        printCharArray(letters);

        //example keys
        int[] keys = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            keys[i] = nextInt(a, b, m, x);
            x = keys[i];
        }
        System.out.print("Keys: ");
        System.out.print("\"");
        for (int key : keys) {
            System.out.print(key);
        }
        System.out.print("\"\n");

        //encrypt letters
        int[] encrypted_letters = encrypt(letters, keys);
        System.out.print("Encrypted chars: ");
        System.out.print("\"");
        for (int i : encrypted_letters) {
            System.out.print(i);
        }
        System.out.print("\"\n");

        //decrypt letters
        char[] decrypted_letters = decrypt(encrypted_letters, keys);
        System.out.print("Decrypted chars: ");
        printCharArray(decrypted_letters);
    }
}
