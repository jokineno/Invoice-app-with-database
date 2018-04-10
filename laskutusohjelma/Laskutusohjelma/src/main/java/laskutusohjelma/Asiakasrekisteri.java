/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma;

/**
 *
 * @author ollijokinen
 */
import java.util.List;
public class Asiakasrekisteri {
    List<Asiakas> asiakasrekisteri;
    
    public Asiakasrekisteri (List asiakasrekisteri) {
        this.asiakasrekisteri = asiakasrekisteri;
    }
    
    public void lisaaAsiakas (Asiakas asiakas) {
        this.asiakasrekisteri.add(asiakas);
    }
}
