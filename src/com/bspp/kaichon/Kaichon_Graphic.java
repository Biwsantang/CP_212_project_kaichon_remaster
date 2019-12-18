package com.bspp.kaichon;

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.event.*;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//import java.lang.System;
import java.util.Timer;
import java.util.TimerTask;

public class Kaichon_Graphic {
	
	private boolean runCount = false;
	private int count = 0;
	
	JFrame frame;
	
	private JProgressBar textHealth,textHappiness,textHunger,textDirty,textAge,textToliet;
	
	private JLabel textCoin;
	
	public Kaichon_Graphic(Kaichon kaichon) {
		
		Kaichon_System kaichon_system = new Kaichon_System();
		
		frame = new JFrame();
		frame.setTitle(kaichon.getName());  
		frame.setBounds(100, 100, 450, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		GridBagLayout experimentLayout = new GridBagLayout();
		panel.setLayout(experimentLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel img = new JLabel("");
		//img.setBounds(11, 62, 370, 300);
		img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/chicken.gif")));
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = 0.0;
		c.gridx = 0;
		c.gridwidth = 3;
		c.gridy = 0;
		panel.add(img,c);
		
		JLabel labelCoin = new JLabel("Coin :");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		panel.add(labelCoin,c);
		
		textCoin = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		panel.add(textCoin,c);
		
		JLabel labelHealth = new JLabel("Healthy : ");
		//labelHealth.setBounds(11, 11, 56, 14);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 2;
		panel.add(labelHealth,c);
		
		//textHealth = new JLabel("");
		textHealth = new JProgressBar();
		textHealth.setStringPainted(true); 
		//textHealth.setBounds(56, 11, 46, 14);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 2;
		panel.add(textHealth,c);
		
		JLabel labelHappieness = new JLabel("Happieness : ");
		//labelHappieness.setBounds(129, 11, 83, 14);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 3;
		panel.add(labelHappieness,c);
		
		textHappiness = new JProgressBar();
		//textHappiness.setBounds(207, 11, 46, 14);
		textHappiness.setStringPainted(true); 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 3;
		panel.add(textHappiness,c);
		
		JLabel labelHunger = new JLabel("Hungry : ");
		//labelHunger.setBounds(276, 11, 46, 14);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 4;
		panel.add(labelHunger,c);
		
		textHunger = new JProgressBar();
		//textHunger.setBounds(332, 11, 46, 14);
		textHunger.setStringPainted(true); 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 4;
		panel.add(textHunger,c);
		
		JLabel labelDirty = new JLabel("Dirty : ");
		//labelDirty.setBounds(21, 42, 46, 14);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 5;
		panel.add(labelDirty,c);
		
		textDirty = new JProgressBar();
		//textDirty.setBounds(66, 42, 46, 14);
		textDirty.setStringPainted(true); 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 5;
		panel.add(textDirty,c);
		
		JLabel labelAge = new JLabel("Age : ");
		//labelAge.setBounds(129, 42, 46, 14);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 6;
		panel.add(labelAge,c);
		
		textAge = new JProgressBar();
		//textAge.setBounds(167, 42, 46, 14);
		textAge.setStringPainted(true); 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 6;
		panel.add(textAge,c);
		
		JLabel labelToilet = new JLabel("Toilet : ");
		//labelToilet.setBounds(276, 42, 46, 14);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 7;
		panel.add(labelToilet,c);
		
		textToliet = new JProgressBar();
		//textToliet.setBounds(320, 42, 46, 14);
		textToliet.setStringPainted(true); 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 7;
		panel.add(textToliet,c);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);
		
		newMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	kaichon_system.newKaichon();
            }
		});
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		
		openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
  
				String path = kaichon_system.selectKaichon();
				if (path!=null) {
					kaichon_system.openKaichon(path);
				}
				
            }
		});
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		fileMenu.add(saveMenuItem);
		
		saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
				kaichon_system.saveKaichon(kaichon);
            }
		});
		
		
		JMenu petMenu = new JMenu("Pet");
		menuBar.add(petMenu);
		
		JMenuItem feedMenuItem = new JMenuItem("Feed");
		petMenu.add(feedMenuItem);
		
		feedMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(kaichon.goHunger()) {
	            	runCount = true;
	            	PlaySound(Kaichon_Graphic.class.getResource("/sound/Feed.wav"));
	            	img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/feed.gif")));
	                JOptionPane.showMessageDialog(null,"Feeding "+kaichon.getName(),"Feed",JOptionPane.PLAIN_MESSAGE);
	                updateStatus(kaichon);
            	} 
            }
		});
		
		JMenuItem poopMenuItem = new JMenuItem("Poop");
		petMenu.add(poopMenuItem);
		
		poopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(kaichon.goPoop()){
	            	runCount = true;
	            	PlaySound(Kaichon_Graphic.class.getResource("/sound/Poop.wav"));
	            	img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/poop.gif")));
	                JOptionPane.showMessageDialog(null,kaichon.getName()+" is pooping","Poop",JOptionPane.PLAIN_MESSAGE);
	                updateStatus(kaichon);
            	}
            }
		});
		
		JMenuItem patMenuItem = new JMenuItem("Pat");
		petMenu.add(patMenuItem);
		
		patMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(kaichon.goPat()) {
	            	runCount = true;
	            	PlaySound(Kaichon_Graphic.class.getResource("/sound/Pat.wav"));
	            	img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/pat.gif")));
	                JOptionPane.showMessageDialog(null,"Pating "+kaichon.getName(),"Pat",JOptionPane.PLAIN_MESSAGE);
	                updateStatus(kaichon);
            	}
            }
		});
		
		JMenuItem showerMenuItem = new JMenuItem("Shower");
		petMenu.add(showerMenuItem);
		
		showerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (kaichon.goShower()) {
	            	runCount = true;
	            	PlaySound(Kaichon_Graphic.class.getResource("/sound/Shower.wav"));
	            	img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/shower.gif")));
	                JOptionPane.showMessageDialog(null,"Showering "+kaichon.getName(),"Shower",JOptionPane.PLAIN_MESSAGE);
	                updateStatus(kaichon);
            	}
            }
		});
		
		JMenuItem fightMenuItem = new JMenuItem("Fight");
		petMenu.add(fightMenuItem);
		
		fightMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (kaichon.goFight()) {
	            	runCount = true;
	            	PlaySound(Kaichon_Graphic.class.getResource("/sound/Fight.wav"));
	            	img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/fight.gif")));
	                JOptionPane.showMessageDialog(null,kaichon.getName()+" is fighting","Fight",JOptionPane.PLAIN_MESSAGE);
	                updateStatus(kaichon);
            	}
            }
		});
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);
		
		aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Kaichon\n"+
							    					"Version 1.0.0\n"+
							    					"Copyright ©2019 BSPP","About",JOptionPane.PLAIN_MESSAGE);
            }
		});
		
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		    @Override
		    public void run() {
		    	updateStatus(kaichon);
		    	if(runCount) {
					if(count > 8) {
						img.setIcon(new ImageIcon(Kaichon_Graphic.class.getResource("/image/chicken.gif")));
						count = 0;
						runCount = false;
					}
					System.out.print(count);
					count++;
		    	}
		    }
		}, 0, 1000);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void updateStatus(Kaichon kaichon) {
		
		textCoin.setText(Integer.toString(kaichon.getCoin()));
		textHealth.setValue((int) kaichon.getHealth());
		textHappiness.setValue((int) kaichon.getHappiness());
		textHunger.setValue((int) kaichon.getHunger());
		textDirty.setValue((int) kaichon.getDirty());
		textAge.setValue((int) kaichon.getAge());
		textToliet.setValue((int) kaichon.getToliet());
		kaichon.update();
	}
	
	
	static void PlaySound(URL url) {
		
			try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip c = AudioSystem.getClip();
			Clip clip = AudioSystem.getClip();
	        // Open audio clip and load samples from the audio input stream.
	        clip.open(audioIn);
	        clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			//Thread.sleep(c.getMicrosecondLength()/1000);
	}
}
