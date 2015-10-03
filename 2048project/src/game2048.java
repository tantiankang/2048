
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class game2048 {
	
	JPanel [] panel = new JPanel[16];
	JButton [] button = new JButton[16];
	JFrame mainFrame = new JFrame("2048");
	Random randomGenerator = new Random();
	public game2048()
	{
		
		KeyListener key =new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == 38)
				{
					System.out.println("up ");
					addNumber();
					//moveUp();
					checkCell();
				}
				if(e.getKeyCode() == 40 )
				{
					System.out.println("Down ");
					addNumber();
					//moveDown();
					checkCell();
				}
				if(e.getKeyCode() == 39)
				{
					System.out.println("right ");
					addNumber();
					//moveRight();
					checkCell();
				}
				if(e.getKeyCode() == 37)
				{
					System.out.println("left ");
					addNumber();
					//moveLeft();
					checkCell();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		mainFrame.setLayout(new GridLayout(4,4,0,0));
		mainFrame.setSize(600, 600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

		for(int i=0;i<16;i++)
		{
			panel[i]=new JPanel();
			button[i]=new JButton("");
			button[i].setBackground(Color.GRAY);
			panel[i].setLayout(new GridLayout(1,1));
			panel[i].setMaximumSize(new Dimension(150,150));
			panel[i].requestFocusInWindow();
			panel[i].setBorder(BorderFactory.createLineBorder(Color.black));
			panel[i].add(button[i]);
			button[i].addKeyListener(key);
			mainFrame.add(panel[i]);
		}
	}
	protected boolean checkCell()
	{
		boolean win=true;
		for(int i=0;i<16;i++)
		{
			if(button[i].getText()==(""))
			{
				win=false;
			}
		}
		if(win)
		{
			System.out.println("you lose");
		}
		return false;
	}
	
	protected void addNumber()
	{
		boolean randomBoo = randomGenerator.nextBoolean();
		int randomInt = randomGenerator.nextInt(15);
		if(button[randomInt].getText().equals(""))
		{
			if(randomBoo==true)
			{
				button[randomInt].setText("2");
			}
			else
			{
				button[randomInt].setText("4");
			}
		}
		else
		{
			for(int i=0;i<16;i++)
			if(button[i].getText()==(""))
			{
				if(randomBoo==true)
				{
					button[i].setText("2");
					break;
				}
				else
				{
					button[i].setText("4");
					break;
				}	
			}
			
			
			
		}
		
	}
	
}

