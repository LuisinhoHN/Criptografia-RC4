/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmorc4;

import java.security.InvalidKeyException;

/**
 *
 * @author Henrique
 */
public class RC4 {

    private char[] key;
    private int[] sbox;
    private static final int SBOX_LENGTH = 256;
    private static final int TAM_MIN_CHAVE = 5;

    public RC4(String key) throws InvalidKeyException {
        //Etapa 3
        setKey(key);
        //imprimeKey();
    }

    public RC4() {

    }

    public char[] decriptografa(final char[] msg) {
        return criptografa(msg);
    }

    public char[] criptografa(final char[] msg) {
        
        //Etapa 2
        sbox = initSBox(key);
        
        //Etapa 6
        char[] code = new char[msg.length];
        int i = 0;
        int j = 0;
        
        //Etapa 7
        for (int n = 0; n < msg.length; n++) {
            i = (i + 1) % SBOX_LENGTH;
            //System.out.println("valor de i ="+i);
            j = (j + sbox[i]) % SBOX_LENGTH;
            //System.out.println("valor de j ="+j);
            swap(i, j, sbox);
            int rand = sbox[(sbox[i] + sbox[j]) % SBOX_LENGTH];
            //System.out.println("valor de rand ="+rand);
            
            //Etapa 8
            code[n] = (char) (rand ^ (int) msg[n]);
        }
        
        return code;
    }

    private int[] initSBox(char[] key) {
        
        //Etapa 1
        int[] sbox = new int[SBOX_LENGTH];
        
        //Etapa 4
        int j = 0;

        //Etapa 2
        for (int i = 0; i < SBOX_LENGTH; i++) {
            sbox[i] = i;
        }
        
        for (int i = 0; i < SBOX_LENGTH; i++) {
            //Etapa 5
            j = (j + sbox[i] + key[i % key.length]) % SBOX_LENGTH;
            swap(i, j, sbox);
        }
        return sbox;
    }

    private void swap(int i, int j, int[] sbox) {
        //Etapa 5
        int temp = sbox[i];
        sbox[i] = sbox[j];
        sbox[j] = temp;
    }

    //Etapa 3
    public void setKey(String key) throws InvalidKeyException {
        if (!(key.length() >= TAM_MIN_CHAVE && key.length() < SBOX_LENGTH)) {
            throw new InvalidKeyException("Tamanho da chave deve ser entre "
                    + TAM_MIN_CHAVE + " e " + (SBOX_LENGTH - 1));
        }

        this.key = key.toCharArray(); 
    }
    
    public void imprimeKey(){
        for (int i = 0; i < SBOX_LENGTH; i++) {
            System.out.print("Valor de Key[");
            System.out.print(i);
            System.out.print("]=");
            System.out.print(key[i]);
            System.out.println("");
        }
    }
}

