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
public class AlgoritmoRC4 {
    
    public static void main(String[] args) {
        try {

            RC4 rc4 = new RC4("testkey");
            char[] textoCriptografado = rc4.criptografa("Teste de Mensagem de Texto Puro".toCharArray());
            System.out.println("Texto Criptografado:\n" + new String(textoCriptografado));
            System.out.println("Texto Decriptografado:\n"
                    + new String(rc4.decriptografa(textoCriptografado)));

        } catch (InvalidKeyException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // esse aqui mudou !! FABINHO
}
