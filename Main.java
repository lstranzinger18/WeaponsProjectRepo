/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3b.lstranzinger.WeaponsProjectRepo;

import java.io.FileNotFoundException;

/**
 *
 * @author lukas
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        Weapon wp = new Weapon();
        
        
        wp.ReadFile("weapons.csv");
    }
}
