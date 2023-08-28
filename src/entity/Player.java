package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {
GamePanel gp;
KeyHandler keyH;


public final int screenX;
public final int screenY;
public int hasAmmo = 0;
public int hasExp = 0;
public int hasFuel = 0;
public int hasMedal = 0;

public Player(GamePanel gp, KeyHandler keyH) 
{
	this.gp = gp;
	this.keyH = keyH;
	
	screenX = gp.screenWidth/2 - (gp.tileSize/2);
	screenY = gp.screenHeight/2 - (gp.tileSize/2);
	
	solidArea = new Rectangle();
	solidArea.x = 8;
	solidArea.y = 16;
	solidAreaDefaultX = solidArea.x;
	solidAreaDefaultY = solidArea.y;
	solidArea.width = 32;
	solidArea.height = 32;
	
	setDefaultValues();
	getPlayerImage();
}

public void setDefaultValues() 
    {
	worldX = gp.tileSize * 2;
	worldY = gp.tileSize * 2;
	speed = 4;
	direction = "down";
    }

public void getPlayerImage() 
    {
		try {
			
			up1 = ImageIO.read(getClass().getResource("/player/New Piskel-1.png.png"));
			up2 = ImageIO.read(getClass().getResource("/player/New Piskel-5.png.png"));
			down1 = ImageIO.read(getClass().getResource("/player/New Piskel-3.png.png"));
			down2 = ImageIO.read(getClass().getResource("/player/New Piskel-7.png.png"));
			left1 = ImageIO.read(getClass().getResource("/player/New Piskel-2.png.png"));
			left2 = ImageIO.read(getClass().getResource("/player/New Piskel-6.png.png"));
			right1 = ImageIO.read(getClass().getResource("/player/New Piskel-4.png.png"));
			right2 = ImageIO.read(getClass().getResource("/player/New Piskel-8.png.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	

     public void update() 
    {
    	if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) 
    	{
    		if(keyH.upPressed == true) 
     		{
     			direction = "up";
     			
     		}
     		else if(keyH.downPressed == true) 
     		{
     			direction = "down";
     			
     		}
     		else if(keyH.leftPressed == true) 
     		{
     			direction = "left";
     			
     		}
     		else if(keyH.rightPressed == true) 
     		{
     			direction = "right";
     			
     		}
    		//CHECK TILE COLLISION
    		collisionOn = false;
    		gp.cChecker.checkTile(this);
    		
    		//CHECK OBJECT COLLISION
    		int objIndex = gp.cChecker.checkObject(this, true);
    		pickUpObject(objIndex);
    		
    		//IF COLLISION IS FALSE PLAYER CAN MOVE
    		if(collisionOn == false) 
    		{
    			switch(direction) 
    			{
    			case "up":
    				worldY -= speed;
    				break;
    			case "down":
    				worldY += speed;
    				break;
    			case "left":
    				worldX -= speed;
    				break;
    			case "right":
    				worldX += speed;
    				break;
    			}
    			
    		}
    		
    		
     		spriteCounter++;
     		if(spriteCounter > 10) 
     		{
     			if(spriteNum == 1) 
     			{
     				spriteNum = 2;
     			}
     			else if(spriteNum == 2) 
     			{
     				spriteNum = 1;
     			}
     			spriteCounter = 0;
     		}
    		
    	}
	}
     
     
     public void pickUpObject(int i) 
     {
    	 if(i != 999 )
    	 {
    		 String objectName = gp.obj[i].name;
    		 
    		 switch(objectName) 
    		 {
    		 case "Ammo":
    			 gp.playSE(1);
    			 hasAmmo++;
    			 gp.obj[i] = null;
    			 gp.ui.showMessage("Ammo acquired!");
    			 break;
    		 case "Exp":
    			 gp.playSE(2);
    			 hasExp++;
    			 gp.obj[i] = null;
    			 System.out.println("Experience: "+ hasExp);
    			 break;
    		 case "Fuel":
    			 gp.playSE(3);
    			 speed += 3;
    			 gp.obj[i] = null;
    			 break;
    		 case "Medal":
    			 gp.playSE(4);
    			 hasMedal++;
    			 gp.obj[i] = null;
    			 System.out.println("Medals: "+ hasMedal);
    			 break;
    			 
    		 }
    		 
    	 }
     }
     
     public void draw(Graphics2D g2) 
     {
//    		g2.setColor(Color.white);
//    		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
  
    	 BufferedImage image = null;
    	 
    	 switch(direction) 
    	 {
    	 case "up":
    		if(spriteNum == 1) 
    		{
    			 image = up1;
    		}
    	 	if(spriteNum == 2) 
    	 	{
    	 		image = up2;
    	 	}
    	 	break;
    	 case "down":
    		 if(spriteNum == 1) 
     		{
     			 image = down1;
     		}
     	 	if(spriteNum == 2) 
     	 	{
     	 		image = down2;
     	 	}
    	 	break;
    	 case "left":
    		 if(spriteNum == 1) 
     		{
     			 image = left1;
     		}
     	 	if(spriteNum == 2) 
     	 	{
     	 		image = left2;
     	 	}
    		 break;
    	 case "right":
    		 if(spriteNum == 1) 
     		{
     			 image = right1;
     		}
     	 	if(spriteNum == 2) 
     	 	{
     	 		image = right2;
     	 	}
    		 break;
    	 }
    	 g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    	 
     }
}
