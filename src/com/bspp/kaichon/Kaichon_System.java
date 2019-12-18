package com.bspp.kaichon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Kaichon_System {
	
public void newKaichon() {
	
	ProcessBuilder pb = new ProcessBuilder("java", "-jar", System.getProperty("java.class.path"));
	//pb.directory(new File((System.getProperty("user.dir"))));
	try {
		Process p = pb.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void openKaichon(String path) {
	
	ProcessBuilder pb = new ProcessBuilder("java", "-jar", System.getProperty("java.class.path"),"-o",path);
	//pb.directory(new File((System.getProperty("user.dir"))));
	try {
		Process p = pb.start();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

public String selectKaichon() {
	
	
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	int result = fileChooser.showOpenDialog(fileChooser);
	if (result == JFileChooser.APPROVE_OPTION) {
	    File selectedFile = fileChooser.getSelectedFile();
	    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
	    return selectedFile.getPath();
		
	} else {
	    System.out.println("Cancel was selected");
	}
	return null;
	
}

public Kaichon readKaichon(String path) {
	try {
		
		FileInputStream fi = new FileInputStream(new File(path));
		ObjectInputStream oi = new ObjectInputStream(fi);
		Kaichon kaichon = (Kaichon) oi.readObject();
		return kaichon;
		
	} catch (ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
	return null;
}
	
public void saveKaichon(Kaichon kaichon) {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showSaveDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    try {
		    	FileOutputStream fo = new FileOutputStream(selectedFile);
				ObjectOutputStream oo = new ObjectOutputStream(fo);
				oo.writeObject(kaichon);
		    } catch (IOException e) {
				e.printStackTrace();
			}
		    
		} else {
		    System.out.println("Cancel was selected");
		}
		
	}

}
