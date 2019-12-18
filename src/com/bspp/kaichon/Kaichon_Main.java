package com.bspp.kaichon;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Kaichon_Main {
	
	public static void main(String args[]) {
		
		Kaichon_System system = new Kaichon_System();
		
		if (args.length>0) {
		
			if (args[0].equals("-o") && args.length>1) {
				
				Kaichon kaichon = system.readKaichon(args[1]);
				
				Kaichon_Main main = new Kaichon_Main(kaichon);
				
			} else if (args[0].equals("-n") && args.length>1) {
				
				String name = args[1];
				
				Kaichon kaichon = new Kaichon(name);
				
				Kaichon_Main main = new Kaichon_Main(kaichon);
				
			} else {
			
				JOptionPane.showMessageDialog(null, "You launch game the wrong way");
			
			}
			
		} else {
			
			String name = JOptionPane.showInputDialog(null, "What's your pet name?");
			
			if (name==null) {
				
				System.exit(0);
				
			}
			
			Kaichon kaichon = new Kaichon(name);
			
			Kaichon_Main main = new Kaichon_Main(kaichon);
			
		}
		
		
	}
	
	public Kaichon_Main(Kaichon kaichon) {
		
		//Kaichon kaichon = new Kaichon(name);
		
		Kaichon_Graphic graphic = new Kaichon_Graphic(kaichon);
		graphic.frame.setVisible(true);
		
	}

}
