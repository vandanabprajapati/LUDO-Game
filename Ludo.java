import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Ludo extends Applet implements MouseListener, MouseMotionListener
{
	int playerone   [][] = new int [45][6];
	int playertwo   [][] = new int [45][6];
	int playerthree [][] = new int [45][6];
	int playerfour  [][] = new int [45][6];
	int roll;
	int width = 50;
	int height = 50;
	int Counter;
	int xPos;
	int yPos;
	int XPos;
	int YPos;
	int winner;
	int picNumber;

	boolean playerturn;
	boolean oneturn;
	boolean twoturn;
	boolean gameWon;
	boolean counterMoved;
	boolean Pressed;

	Image img, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24, img25, img26;

	public void init()
	{
		setSize(700,700);
		fillarray();
		playerone[0][2] = 1;
		playertwo[0][2] = 1;
		playerthree[0][2] = 1;
		playerfour[0][2] = 1;
		Counter = 0;
		addMouseListener(this);
		winner = 0;
		counterMoved = true;
		Pressed = false;
		picNumber = 0;
	}

	public void paint (Graphics graf)
	{
		img = getImage(getCodeBase(), "square.JPG");
		img1 = getImage(getCodeBase(), "red.JPG");
		img2 = getImage(getCodeBase(), "yellow.JPG");
		img3 = getImage(getCodeBase(), "green.JPG");
		img4 = getImage(getCodeBase(), "blue4.JPG");
		img5 = getImage(getCodeBase(), "center.JPG");
		img6 = getImage(getCodeBase(), "dice3.JPG");
		img7 = getImage(getCodeBase(), "ludo.JPG");
		img8 = getImage(getCodeBase(), "roll sign.JPG");
		img9 = getImage(getCodeBase(), "one4.JPG");
		img10 = getImage(getCodeBase(), "two4.JPG");
		img11 = getImage(getCodeBase(), "three4.JPG");
		img12 = getImage(getCodeBase(), "four4.JPG");
		img13 = getImage(getCodeBase(), "five4.JPG");
		img14 = getImage(getCodeBase(), "six4.JPG");
		img15 = getImage(getCodeBase(), "gameover4.JPG");
		img16 = getImage(getCodeBase(), "onewin4.JPG");
		img17 = getImage(getCodeBase(), "twowin4.JPG");
		img18 = getImage(getCodeBase(), "threewin.JPG");
		img19 = getImage(getCodeBase(), "fourwin.JPG");
		img20 = getImage(getCodeBase(), "redstart.JPG");
		img21 = getImage(getCodeBase(), "yellowstart.JPG");
		img22 = getImage(getCodeBase(), "greenstart.JPG");
		img23 = getImage(getCodeBase(), "bluestart.JPG");
		img24 = getImage(getCodeBase(), "yellow roll.JPG");
		img25 = getImage(getCodeBase(), "green roll.JPG");
		img26 = getImage(getCodeBase(), "blue roll.JPG");

		for(int i=0; i<=39; i++)
		{

		//------------------- draw grid -----------------------------
			graf.drawImage(img, playerone[i][0], playerone[i][1], this);
		}
		for(int i=40; i<=43; i++)
		{
			graf.drawImage(img1, playerone[i][0], playerone[i][1], this);
			graf.drawImage(img2, playertwo[i][0], playertwo[i][1], this);
			graf.drawImage(img3, playerthree[i][0], playerthree[i][1], this);
			graf.drawImage(img4, playerfour[i][0], playerfour[i][1], this);
		}
		graf.drawImage(img5, 300, 300, this);
		graf.drawImage(img7, 100, 100, this);
		graf.drawImage(img20, 50, 250, this);
		graf.drawImage(img21, 250, 550, this);
		graf.drawImage(img22, 550, 350, this);
		graf.drawImage(img23, 350, 50, this);

		if(gameWon == false)
		{
			graf.drawImage(img6, 450, 100, this);
		}

		if(counterMoved == false)
		{
			graf.drawImage(img8, 400, 400, this);
		}
		if(picNumber == 1)
		{
			graf.drawImage(img8, 400, 400, this);
		}
		if(picNumber == 2)
		{
			graf.drawImage(img24, 400, 400, this);
		}
		if(picNumber == 3)
		{
			graf.drawImage(img25, 400, 400, this);
		}
		if(picNumber == 4)
		{
			graf.drawImage(img26, 400, 400, this);
		}

	//------------------- draw counters -----------------------------
		for (int i=0; i<=43; i++)
		{
			if(playerone[i][3] == 1 & counterMoved == false)
			{
				graf.setColor(Color.red);
				graf.fillOval(playerone[i][0] + 10, playerone[i][1] + 10,30,30);
			}
			if(playerone[i][2] == 1 & counterMoved == true)
			{
				graf.setColor(Color.red);
				graf.fillOval(playerone[i][0] + 10, playerone[i][1] + 10,30,30);
			}

			if(playertwo[i][2] == 1)
			{
				graf.setColor(Color.yellow);
				graf.fillOval(playertwo[i][0] + 10, playertwo[i][1] + 10,30,30);
			}

			if(playerthree[i][2] == 1)
			{
				graf.setColor(Color.green);
				graf.fillOval(playerthree[i][0] + 10, playerthree[i][1] + 10,30,30);
			}

			if(playerfour[i][2] == 1)
			{
				graf.setColor(Color.blue);
				graf.fillOval(playerfour[i][0] + 10, playerfour[i][1] + 10,30,30);
			}
		}

		if(playerone[44][2] == 1 & counterMoved == true)
		{
			graf.setColor(Color.red);
			graf.fillOval(298, 298,30,30);
		}
		if(playertwo[44][2] == 1)
		{
			graf.setColor(Color.yellow);
			graf.fillOval(298, 322,30,30);
		}
		if(playerthree[44][2] == 1)
		{
			graf.setColor(Color.green);
			graf.fillOval(322, 322,30,30);
		}
		if(playerfour[44][2] == 1)
		{
			graf.setColor(Color.blue);
			graf.fillOval(322, 298,30,30);
		}

	//---------------------- Draw dice roll --------------------------
		if(roll == 1)
		{
			graf.drawImage(img9, 450, 455, this);
		}
		if(roll == 2)
		{
			graf.drawImage(img10, 450, 455, this);
		}
		if(roll == 3)
		{
			graf.drawImage(img11, 450, 455, this);
		}
		if(roll == 4)
		{
			graf.drawImage(img12, 450, 455, this);
		}
		if(roll == 5)
		{
			graf.drawImage(img13, 450, 455, this);
		}
		if(roll == 6)
		{
			graf.drawImage(img14, 450, 455, this);
		}


	//---------------------- display winner --------------------------
		if(winner == 1 & counterMoved == true)
		{
			graf.drawImage(img16, 50, 425, this);
		}
		if(winner == 2)
		{
			graf.drawImage(img17, 50, 425, this);
		}
		if(winner == 3)
		{
			graf.drawImage(img18, 50, 425, this);
		}
		if(winner == 4)
		{
			graf.drawImage(img19, 50, 425, this);
		}

		if(gameWon == true & counterMoved == true)
		{
			graf.drawImage(img15, 450, 100, this);
			graf.setColor(Color.white);
			graf.fillRect(400,400,400,400);
			picNumber = 0;
		}
	}



	//---------------------- Create grid --------------------------
	public void fillarray()
	{
		int xCoord = 50;
		int yCoord = 250;

		for(int i=0; i<=4; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i+10][0] = xCoord;
			playertwo[i+10][1] = yCoord;
			playerthree[i+20][0] = xCoord;
			playerthree[i+20][1] = yCoord;
			playerfour[i+30][0] = xCoord;
			playerfour[i+30][1] = yCoord;
			xCoord = xCoord + 50;
		}

		yCoord = yCoord - 50;
		xCoord = xCoord - 50;
		for(int i=5; i<=8; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i+10][0] = xCoord;
			playertwo[i+10][1] = yCoord;
			playerthree[i+20][0] = xCoord;
			playerthree[i+20][1] = yCoord;
			playerfour[i+30][0] = xCoord;
			playerfour[i+30][1] = yCoord;
			yCoord = yCoord - 50;
		}

		playerone[9][0] = 300;
		playertwo[19][0] = 300;
		playerthree[29][0] = 300;
		playerfour[39][0] = 300;
		playerone[9][1] = 50;
		playertwo[19][1] = 50;
		playerthree[29][1] = 50;
		playerfour[39][1] = 50;

		yCoord = 50;
		xCoord = 350;
		for(int i=10; i<=14; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i+10][0] = xCoord;
			playertwo[i+10][1] = yCoord;
			playerthree[i+20][0] = xCoord;
			playerthree[i+20][1] = yCoord;
			playerfour[i-10][0] = xCoord;
			playerfour[i-10][1] = yCoord;
			yCoord = yCoord + 50;
		}

		yCoord = 250;
		xCoord = 400;
		for(int i=15; i<=18; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i+10][0] = xCoord;
			playertwo[i+10][1] = yCoord;
			playerthree[i+20][0] = xCoord;
			playerthree[i+20][1] = yCoord;
			playerfour[i-10][0] = xCoord;
			playerfour[i-10][1] = yCoord;
			xCoord = xCoord + 50;
		}

		playerone[19][0] = 550;
		playertwo[29][0] = 550;
		playerthree[39][0] = 550;
		playerfour[9][0] = 550;
		playerone[19][1] = 300;
		playertwo[29][1] = 300;
		playerthree[39][1] = 300;
		playerfour[9][1] = 300;

		xCoord = 550;
		yCoord = 350;
		for(int i=20; i<=24; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i+10][0] = xCoord;
			playertwo[i+10][1] = yCoord;
			playerthree[i-20][0] = xCoord;
			playerthree[i-20][1] = yCoord;
			playerfour[i-10][0] = xCoord;
			playerfour[i-10][1] = yCoord;
			xCoord = xCoord - 50;
		}

		xCoord = 350;
		yCoord = 400;
		for(int i=25; i<=28; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i+10][0] = xCoord;
			playertwo[i+10][1] = yCoord;
			playerthree[i-20][0] = xCoord;
			playerthree[i-20][1] = yCoord;
			playerfour[i-10][0] = xCoord;
			playerfour[i-10][1] = yCoord;
			yCoord = yCoord + 50;
		}

		playerone[29][0] = 300;
		playertwo[39][0] = 300;
		playerthree[9][0] = 300;
		playerfour[19][0] = 300;
		playerone[29][1] = 550;
		playertwo[39][1] = 550;
		playerthree[9][1] = 550;
		playerfour[19][1] = 550;

		xCoord = 250;
		yCoord = 550;
		for(int i=30; i<=34; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i-30][0] = xCoord;
			playertwo[i-30][1] = yCoord;
			playerthree[i-20][0] = xCoord;
			playerthree[i-20][1] = yCoord;
			playerfour[i-10][0] = xCoord;
			playerfour[i-10][1] = yCoord;
			yCoord = yCoord - 50;
		}

		xCoord = 200;
		yCoord = 350;
		for(int i=35; i<=38; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			playertwo[i-30][0] = xCoord;
			playertwo[i-30][1] = yCoord;
			playerthree[i-20][0] = xCoord;
			playerthree[i-20][1] = yCoord;
			playerfour[i-10][0] = xCoord;
			playerfour[i-10][1] = yCoord;
			xCoord = xCoord - 50;
		}

		playerone[39][0] = 50;
		playertwo[9][0] = 50;
		playerthree[19][0] = 50;
		playerfour[29][0] = 50;
		playerone[39][1] = 300;
		playertwo[9][1] = 300;
		playerthree[19][1] = 300;
		playerfour[29][1] = 300;

		xCoord = 100;
		yCoord = 300;
		for(int i=40; i<=44; i++)
		{
			playerone[i][0] = xCoord;
			playerone[i][1] = yCoord;
			xCoord = xCoord + 50;
		}

		xCoord = 300;
		yCoord = 500;
		for(int i=40; i<=44; i++)
		{
			playertwo[i][0] = xCoord;
			playertwo[i][1] = yCoord;
			yCoord = yCoord - 50;
		}

		xCoord = 500;
		yCoord = 300;
		for(int i=40; i<=44; i++)
		{
			playerthree[i][0] = xCoord;
			playerthree[i][1] = yCoord;
			xCoord = xCoord - 50;
		}

		xCoord = 300;
		yCoord = 100;
		for(int i=40; i<=44; i++)
		{
			playerfour[i][0] = xCoord;
			playerfour[i][1] = yCoord;
			yCoord = yCoord + 50;
		}


	}

	private void setValues (int x, int y)
	{
		xPos = x;
		yPos = y;
	}

	private void setvalues (int x, int y)
	{
		XPos = x;
		YPos = y;
		rollDice();
		repaint();
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
		setValues(e.getX(), e.getY() );
	}

	public void mouseReleased(MouseEvent e)
	{
		setvalues(e.getX(), e.getY() );
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseDragged(MouseEvent e)
	{
	}

	public void mouseMoved(MouseEvent e)
	{
	}



	public void rollDice()
	{
		if (xPos >= 450 & xPos <= 550 & yPos >= 100 & yPos <= 200)
		{
			if(Counter == 0)
			{
				for(int i=0; i<playerone.length; i++)
				{
					playerone[i][3] = 0;
					if(playerone[i][2] == 1)
					{
						playerone[i][3] = 1;
					}
				}


				//-------------------- Making the move -------------------------

				roll = 1 + (int)(Math.random() * 6);
				picNumber = 1;
				oneturn = true;
				for(int i=39; i<45; i++)
				{
					if (playerone[39][2] == 1)
					{
						if (roll<6)
						{
							playerone[39][2] = 0;
							playerone[39+roll][2] = 1;
							if(gameWon == false)
							{
								counterMoved = false;
							}
						}
						oneturn = false;
					}
					else
					if (playerone[40][2] == 1 & oneturn == true)
					{
						if (roll<5)
						{
							playerone[40][2] = 0;
							playerone[40+roll][2] = 1;
							if(gameWon == false)
							{
								counterMoved = false;
							}
						}
						oneturn = false;
					}
					else
					if (playerone[41][2] == 1 & oneturn == true)
					{
						if (roll<4)
						{
							playerone[41][2] = 0;
							playerone[41+roll][2] = 1;
							if(gameWon == false)
							{
								counterMoved = false;
							}
						}
						oneturn = false;
					}
					else
					if (playerone[42][2] == 1 & oneturn == true)
					{
						if (roll<3)
						{
							playerone[42][2] = 0;
							playerone[42+roll][2] = 1;
							if(gameWon == false)
							{
								counterMoved = false;
							}
						}
						oneturn = false;
					}
					else
					if (playerone[43][2] == 1 & oneturn == true)
					{
						if (roll<2)
						{
							playerone[43][2] = 0;
							playerone[43+roll][2] = 1;
							if(gameWon == false)
							{
								counterMoved = false;
							}
						}
						oneturn = false;
					}
					else
					if (playerone[44][2] == 1 & oneturn == true)
					{
						oneturn = false;
					}
				}
				if(oneturn == true)
				{
					for(int i=43; i>=0; i--)
					{
						if (playerone[i][2] == 1)
						{
							playerone[i][2] = 0;
							playerone[i+roll][2] = 1;
							if(gameWon == false)
							{
								counterMoved = false;
							}
						}
					}
				}

				if(playertwo[44][2] == 1 & counterMoved == true)
				{
					Counter = 2;
				}
				if(playertwo[44][2] == 1 & playerthree[44][2] == 1 & counterMoved == true)
				{
					Counter = 3;
				}
				if(playertwo[44][2] == 1 & playerthree[44][2] == 1 & playerfour[44][2] == 1 & counterMoved == true)
				{
					Counter = 0;
				}
				if(counterMoved == false)
				{
					Counter = 5;
				}
				if(counterMoved == true & playertwo[44][2] != 1)
				{
					Counter = 1;
				}
			}
			else
			if(Counter == 1)
			{
				roll = 1 + (int)(Math.random() * 6);
				picNumber = 2;
				oneturn = true;
				for(int i=39; i<45; i++)
				{
					if (playertwo[39][2] == 1)
					{
						if (roll<6)
						{
							playertwo[39][2] = 0;
							playertwo[39+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playertwo[40][2] == 1 & oneturn == true)
					{
						if (roll<5)
						{
							playertwo[40][2] = 0;
							playertwo[40+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playertwo[41][2] == 1 & oneturn == true)
					{
						if (roll<4)
						{
							playertwo[41][2] = 0;
							playertwo[41+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playertwo[42][2] == 1 & oneturn == true)
					{
						if (roll<3)
						{
							playertwo[42][2] = 0;
							playertwo[42+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playertwo[43][2] == 1 & oneturn == true)
					{
						if (roll<2)
						{
							playertwo[43][2] = 0;
							playertwo[43+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playertwo[44][2] == 1 & oneturn == true)
					{
						oneturn = false;
					}
				}
				if(oneturn == true)
				{
					for(int i=43; i>=0; i--)
					{
						if (playertwo[i][2] == 1)
						{
							playertwo[i][2] = 0;
							playertwo[i+roll][2] = 1;
						}
					}

					for(int i=0; i<44; i++)
					{
						if(playertwo[i][2] == 1)
						{
							for(int j=0; j<playertwo.length; j++)
							{
									if(playerone[j][2] == 1)
									{
										if(playertwo[i][0] == playerone[j][0] & playertwo[i][1] == playerone[j][1])
										{
											playerone[j][2] = 0;
											playerone[0][2] = 1;
										}
									}
							}
							for(int j=0; j<playerthree.length; j++)
							{
								if(playerthree[j][2] == 1)
								{
									if(playertwo[i][0] == playerthree[j][0] & playertwo[i][1] == playerthree[j][1])
									{
										playerthree[j][2] = 0;
										playerthree[0][2] = 1;
									}
								}
							}
							for(int j=0; j<playerfour.length; j++)
							{
								if(playerfour[j][2] == 1)
								{
									if(playertwo[i][0] == playerfour[j][0] & playertwo[i][1] == playerfour[j][1])
									{
										playerfour[j][2] = 0;
										playerfour[0][2] = 1;
									}
								}
							}
						}
					}
				}
				Counter = 2;

				if(playerthree[44][2] == 1)
				{
					Counter = 3;
				}
				if(playerthree[44][2] == 1 & playerfour[44][2] == 1)
				{
					Counter = 0;
				}
				if(playerthree[44][2] == 1 & playerfour[44][2] == 1 & playerone[44][2] == 1)
				{
					Counter = 1;
					if(playertwo[44][2] == 1)
					{
						if(playerthree[44][2] != 1)
						{
							Counter = 2;
						}
						else
						if(playerfour[44][2] != 1)
						{
							Counter = 3;
						}
						else
						Counter = 0;
					}
				}
			}
			else
			if(Counter == 2)
			{
				roll = 1 + (int)(Math.random() * 6);
				picNumber = 3;
				oneturn = true;
				for(int i=39; i<45; i++)
				{
					if (playerthree[39][2] == 1 & oneturn == true)
					{
						if (roll<6)
						{
							playerthree[39][2] = 0;
							playerthree[39+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerthree[40][2] == 1 & oneturn == true)
					{
						if (roll<5)
						{
							playerthree[40][2] = 0;
							playerthree[40+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerthree[41][2] == 1 & oneturn == true)
					{
						if (roll<4)
						{
							playerthree[41][2] = 0;
							playerthree[41+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerthree[42][2] == 1 & oneturn == true)
					{
						if (roll<3)
						{
							playerthree[42][2] = 0;
							playerthree[42+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerthree[43][2] == 1 & oneturn == true)
					{
						if (roll<2)
						{
							playerthree[43][2] = 0;
							playerthree[43+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerthree[44][2] == 1 & oneturn == true)
					{
						oneturn = false;
					}
				}
				if(oneturn == true)
				{
					for(int i=43; i>=0; i--)
					{
						if (playerthree[i][2] == 1)
						{
							playerthree[i][2] = 0;
							playerthree[i+roll][2] = 1;
						}
					}

					for(int i=0; i<44; i++)
					{
						if(playerthree[i][2] == 1)
						{
							for(int j=0; j<playertwo.length; j++)
							{
									if(playertwo[j][2] == 1)
									{
										if(playerthree[i][0] == playertwo[j][0] & playerthree[i][1] == playertwo[j][1])
										{
											playertwo[j][2] = 0;
											playertwo[0][2] = 1;
										}
									}
							}
							for(int j=0; j<playerone.length; j++)
							{
								if(playerone[j][2] == 1)
								{
									if(playerthree[i][0] == playerone[j][0] & playerthree[i][1] == playerone[j][1])
									{
										playerone[j][2] = 0;
										playerone[0][2] = 1;
									}
								}
							}
							for(int j=0; j<playerfour.length; j++)
							{
								if(playerfour[j][2] == 1)
								{
									if(playerthree[i][0] == playerfour[j][0] & playerthree[i][1] == playerfour[j][1])
									{
										playerfour[j][2] = 0;
										playerfour[0][2] = 1;
									}
								}
							}
						}
					}
				}
				Counter = 3;


				if(playerfour[44][2] == 1)
				{
					Counter = 0;
				}
				if(playerfour[44][2] == 1 & playerone[44][2] == 1)
				{
					Counter = 1;
				}
				if(playerfour[44][2] == 1 & playerone[44][2] == 1 & playertwo[44][2] == 1)
				{
					Counter = 2;
				}
			}
			else
			if(Counter == 3)
			{
				roll = 1 + (int)(Math.random() * 6);
				picNumber = 4;
				oneturn = true;
				for(int i=39; i<45; i++)
				{
					if (playerfour[39][2] == 1 & oneturn == true)
					{
						if (roll<6)
						{
							playerfour[39][2] = 0;
							playerfour[39+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerfour[40][2] == 1 & oneturn == true)
					{
						if (roll<5)
						{
							playerfour[40][2] = 0;
							playerfour[40+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerfour[41][2] == 1 & oneturn == true)
					{
						if (roll<4)
						{
							playerfour[41][2] = 0;
							playerfour[41+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerfour[42][2] == 1 & oneturn == true)
					{
						if (roll<3)
						{
							playerfour[42][2] = 0;
							playerfour[42+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerfour[43][2] == 1 & oneturn == true)
					{
						if (roll<2)
						{
							playerfour[43][2] = 0;
							playerfour[43+roll][2] = 1;
						}
						oneturn = false;
					}
					else
					if (playerfour[44][2] == 1 & oneturn == true)
					{
						oneturn = false;
					}
				}
				if(oneturn == true)
				{
					for(int i=43; i>=0; i--)
					{
						if (playerfour[i][2] == 1)
						{
							playerfour[i][2] = 0;
							playerfour[i+roll][2] = 1;
						}
					}

					for(int i=0; i<44; i++)
					{
						if(playerfour[i][2] == 1)
						{
							for(int j=0; j<playertwo.length; j++)
							{
									if(playertwo[j][2] == 1)
									{
										if(playerfour[i][0] == playertwo[j][0] & playerfour[i][1] == playertwo[j][1])
										{
											playertwo[j][2] = 0;
											playertwo[0][2] = 1;
										}
									}
							}
							for(int j=0; j<playerthree.length; j++)
							{
								if(playerthree[j][2] == 1)
								{
									if(playerfour[i][0] == playerthree[j][0] & playerfour[i][1] == playerthree[j][1])
									{
										playerthree[j][2] = 0;
										playerthree[0][2] = 1;
									}
								}
							}
							for(int j=0; j<playerone.length; j++)
							{
								if(playerone[j][2] == 1)
								{
									if(playerfour[i][0] == playerone[j][0] & playerfour[i][1] == playerone[j][1])
									{
										playerone[j][2] = 0;
										playerone[0][2] = 1;
									}
								}
							}
						}
					}
				}
				Counter = 0;

				if(playerone[44][2] == 1)
				{
					Counter = 1;
				}
				if(playerone[44][2] == 1 & playertwo[44][2] == 1)
				{
					Counter = 2;
				}
				if(playerone[44][2] == 1 & playertwo[44][2] == 1 & playerthree[44][2] == 1)
				{
					Counter = 3;
				}
			}
		}

		if(Counter == 5)
		{
			for(int i=0; i<playerone.length; i++)
			{
				if(playerone[i][3] == 1)
				{
					if(xPos >= playerone[i][0] & xPos <= playerone[i][0]+50 & yPos >= playerone[i][1] & yPos <= playerone[i][1]+50)
					{
					  Pressed = true;
					}
				}
				if(playerone[i][2] == 1)
				{
					if(XPos >= playerone[i][0] & XPos <= playerone[i][0]+50 & YPos >= playerone[i][1] & YPos <= playerone[i][1]+50)
					{
					  counterMoved = true;
					  Pressed = false;
					  Counter = 1;
					}

					if(counterMoved == true) //If ontop send bottom counter back to start
					{
						for(int j=0; j<44; j++)
						{
							if(playertwo[j][2] == 1)
							{
								if(playerone[i][0] == playertwo[j][0] & playerone[i][1] == playertwo[j][1])
								{
									playertwo[j][2] = 0;
									playertwo[0][2] = 1;
								}
							}
						}
						for(int j=0; j<44; j++)
						{
							if(playerthree[j][2] == 1)
							{
								if(playerone[i][0] == playerthree[j][0] & playerone[i][1] == playerthree[j][1])
								{
									playerthree[j][2] = 0;
									playerthree[0][2] = 1;
								}
							}
						}
						for(int j=0; j<44; j++)
						{
							if(playerfour[j][2] == 1)
							{
								if(playerone[i][0] == playerfour[j][0] & playerone[i][1] == playerfour[j][1])
								{
									playerfour[j][2] = 0;
									playerfour[0][2] = 1;
								}
							}
						}
					}


				}
			}

		}

		if(playerone[44][2] == 1 & winner == 0)
		{
			winner = 1;
		}
		if(playertwo[44][2] == 1 & winner == 0)
		{
			winner = 2;
		}
		if(playerthree[44][2] == 1 & winner == 0)
		{
			winner = 3;
		}
		if(playerfour[44][2] == 1 & winner == 0)
		{
			winner = 4;
		}

		if(playerone[44][2] == 1 & playertwo[44][2] == 1 & playerthree[44][2] == 1 & playerfour[44][2] == 1)
		{
			gameWon = true;
		}
	}
}