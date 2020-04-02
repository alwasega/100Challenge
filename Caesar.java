/*A class that demonstrates Arrays using the Caesar's cipher

The Caesar cipher involves replacing each letter in a message with the letter that is a certain number of letters after it in the alphabet. So, for example, we might replace A with D, and B with E, and so on, if shifting by 3 characters. We then let the substution wrap around, so that we replace X with A, and Y with B...

Given that Strings in Java are immutable, we cannot directly edit an instance to encrypt it. Instead, we generate a new string by creating an equivalent array of characters, edit the array, and then reassemble a 9new) string based on the array. 

We can achieve this using the S.toCharArray() method, where S is a given string. For example, if S= "bird", S.toCharArray() produces an array A = {'b', 'i', 'r', 'd'}. Conversely, the syntax new Sring(A) produces "bird" */

//class for doing encryption/ decryption using the Caesar Cipher
public class Caesar{
    protected char[] encoder = new char[26];  //encryption array
    protected char[] decoder = new char[26];  //decryption array

    //constructor that initializes the encryption and decryption arrays
    /*Notes
      This constructor builds the encoder and decoder translation arrays for a given translation using the modular arithmetic operator. A Caesor cipher with a rotation of r encodes the letter having index k with the letter having index (k+r) mod 26. The decoder array is just the opposite - we replace each letter with the one r places before it, with a wraparound. Therefore, we replace the letter having code k with the letter having code (k-r + 26) mod 26. */
    public Caesar(int rotation)
    {
	for (int k =0; k<26; k++){
		encoder[k] = (char)('A' + (k + rotation) %26);
		decoder[k] = (char)('A' + (k -  rotation + 26) %26);
		
	}
    }

    //Returning a String representation of the encrypted message
    public String encrypt(String message){
	return transform(message, encoder);
    }

    // Returning decrypted message given an encrypted secret
	public String decrypt(String secret){
	return transform(secret, decoder);
    }

    //Returning transfromation  of original String using given code
    private String transform(String original, char[] code){
	char[] msg = original.toCharArray();
	for (int k =0; k<msg.length; k++)
	    if(Character.isUpperCase(msg[k])){
		int j = msg[k] -'A';
		msg[k] = code[j];
	    }
	    return new String(msg);
    }
    

    //main method
    public static void main (String[] args){
	Caesar cipher = new Caesar(3);
	System.out.println("Encryption code = " + new String(cipher.encoder));
	System.out.println("Decryption code = " + new String(cipher.decoder));
	String message = "THE EAGLE IS ON THE MOVE; MEET AT NJUGUNA'S.";
	String coded = cipher.encrypt(message);
	System.out.println("Secret: "+ coded);
	String answer = cipher.decrypt(coded);
	System.out.println("Message: " + answer);
    }
}
