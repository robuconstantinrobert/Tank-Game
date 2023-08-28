package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Ammo;

public class UI {
	GamePanel gp;
	Font imperial_28;
	BufferedImage ammoImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	
	public UI(GamePanel gp) 
	{
		this.gp = gp;
		imperial_28 = new Font("Imperial", Font.BOLD, 28);
		OBJ_Ammo ammo = new OBJ_Ammo();
		ammoImage = ammo.image;
	}
	public void showMessage(String text) 
	{
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2)
	{
		g2.setFont(imperial_28);
		g2.setColor(Color.yellow);
		g2.drawImage(ammoImage,gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
		g2.drawString("x " + gp.player.hasAmmo, 74, 65);
		
		//MESSAGE
		if(messageOn == true) 
		{
			g2.setFont(g2.getFont().deriveFont(18F));
			g2.drawString(message, gp.tileSize/2, gp.tileSize * 5);
			
			messageCounter++;
			if(messageCounter > 120) 
			{
				messageCounter = 0;
				messageOn = false;
			}
		}
	}
}
