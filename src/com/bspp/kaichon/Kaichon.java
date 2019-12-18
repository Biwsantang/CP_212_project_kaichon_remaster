package com.bspp.kaichon;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

public class Kaichon implements Serializable {
	
private String name;
	
	private double age,health,toliet,happiness,hunger,dirty;
	
	private int coin;
	
	private boolean alive;

	public Kaichon(String name) {

		this.name = name;
		this.age = 1;
		this.health = 100;
		this.toliet = 0;
		this.happiness = 50;
		this.hunger = 0;
		this.dirty = 0;
		
		this.coin = 0;
		this.alive = true;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}

	public double getAge() {
		
		return this.age;
		
	}
	public double getHealth() {
		
		return this.health;
		
	}
	public double getToliet() {
	
		return this.toliet;
	
	}
	public double getHappiness() {
	
		return this.happiness;
	
	}
	public double getHunger() {
		
		return this.hunger;
		
	}
	public double getDirty() {
		
		return this.dirty;
		
	}
	public int getCoin() {
		
		return this.coin;
		
	}
	public boolean getAlive() {
		
		return this.alive;
		
	}
	private void setAge(double d) {
		this.age = checkLitmit(d,0,100);
		
	}
	private void setHealth(double d) {
		
		this.health = checkLitmit(d,0,100);
		
	}
	private void setToliet(double d) {
	
		this.toliet = checkLitmit(d,0,100);
	
	}
	private void setHappiness(double d) {
	
		this.happiness = checkLitmit(d,0,100);
	
	}
	private void setHunger(double d) {
		
		this.hunger = checkLitmit(d,0,100);
		
	}
	private void setDirty(double d) {
		
		this.dirty = checkLitmit(d,0,100);
		
	}
	private void setCoin(int i) {
		
		this.coin = (int) checkLitmit(i,0,999999);
		
	}
	private void setAlive(boolean status) {
		
		this.alive = status;
		
	}
	
	public boolean goPoop() {
		
		if (this.getToliet()>20) {
			this.setToliet(0);
			this.setHealth(getHealth()+10);
			return true;
		}
		JOptionPane.showMessageDialog(null,this.getName()+" don't want to pooping");
		return false;
		
		
	}
	
	public boolean goFight() {
		
		this.setDirty(this.getDirty()+new Random().nextInt(30));
		this.setHappiness(this.getHappiness()-new Random().nextInt(40));
		
		if(this.hunger > 60) {
			this.setHealth(getHealth()-new Random().nextInt(30));	
		} else {
			this.setHealth(getHealth()-new Random().nextInt(45));
		}
		if(this.getHappiness() > 60) {
			this.setCoin(this.getCoin()+(new Random().nextInt(6))+2);
		}else {
			this.setCoin(this.getCoin()+(new Random().nextInt(3))+1);
		}
		
		return true;
	}
	
	public boolean goShower() {
		if (this.useCoin(1)) {
			this.setDirty(0);
			this.setHappiness(this.getHappiness()+10);
			return true;
		}
		return false;
		
	}
	
	public boolean goPat() {
		
		if(this.getHunger() < 20) {
			this.setHappiness(this.getHappiness()+new Random().nextInt(20));
			return true;
		}
		JOptionPane.showMessageDialog(null,this.getName()+" is happy now! no need to pat.");
		return false;
		
	}
	
	public void goDeath() {
		
		this.setAlive(false);
		
		double score;
		DecimalFormat formatter = new DecimalFormat("#0.00");
		score = (this.coin*50)+(this.age*100)+(this.health*2)-(this.toliet*2)+(this.happiness*4)-(this.hunger*2)-(this.dirty*2);
		JOptionPane.showMessageDialog(null, "Your Chicken Death and You Score is"+formatter.format(score));
		System.exit(0);
		
	}
	
	public boolean goHunger() {
		
		if (this.useCoin(1)) {
			this.setHunger(this.getHunger()-40);
			this.setToliet(this.getToliet()+30);
			return true;
		}
		return false;
		
	}
	
	public double checkLitmit(double i,int min,int max) {
		
		if (i >= max) {
			return max;
		} else if (i<=min) {
			return min;
		} else {
			return i;
		}
		
	}
	
	public boolean useCoin(int i) {
		
		if (this.getCoin()>=i) {
			this.setCoin(this.getCoin()-i);
			return true;
		} 
		JOptionPane.showMessageDialog(null, "you're not enough Coin");
		return false;
		
	}
	
	public void update() {
		if (this.getAlive()) {
			this.setAge(this.getAge()+0.01);
			this.setHunger(this.getHunger()+0.1);
			this.setDirty(this.getDirty()+0.1);
			this.setToliet(this.getToliet()+0.1);
			this.setHealth(this.getHealth()+0.1);
			
			if (this.getHealth()<=0 || this.getAge()>=100) {
				this.goDeath();
			}
		}
	}
	
}
