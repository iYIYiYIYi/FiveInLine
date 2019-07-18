import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class GUI implements ItemListener {
	
	static int GM;//选择游戏模式，1是人机，2是人人
	static int CT;
	
	ImageIcon title = new ImageIcon(this.getClass().getResource("/Image/title.png"));
	ImageIcon MainGUIBackground = new ImageIcon(this.getClass().getResource("/Image/MainGUIBackground.png"));
	JFrame Main = new JFrame("五子棋 by Y-i");
	JRadioButton black = new JRadioButton("黑方（后手）");
	JRadioButton white = new JRadioButton("白方（先手）");
	
	public void  MainInter() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		JLabel bk = new JLabel();
		JPanel panel = new JPanel();
		
		JFrame.setDefaultLookAndFeelDecorated(false);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Point location =new Point();
		location.setLocation(555, 255);
			
		Main.setIconImage(title.getImage());
		Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.setSize(400, 390);
		Main.setLocation(location);
		Main.setFont(new Font("宋体",Font.PLAIN,20));
				
		bk.setIcon(MainGUIBackground);
		bk.setBounds(0, 0, MainGUIBackground.getIconWidth(), MainGUIBackground.getIconHeight());
			
		panel.setLayout(new FlowLayout());
				
		white.setLocation(220, 90);
		black.setLocation(220, 110);
		white.setPreferredSize(new Dimension(210,30));
		black.setPreferredSize(new Dimension(130,30));
		white.addItemListener(this);
		black.addItemListener(this);
		ButtonGroup chesstype = new ButtonGroup();
		chesstype.add(white);
		chesstype.add(black);
		
		JButton ManVSRob = new JButton("人机对决");
		ManVSRob.setBounds(60, 180, 180, 80);
		ManVSRob.addActionListener(new ActionListener() {			
			private ChessMap nCM;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setGameMode(1);
				setnCM(new ChessMap(CT));
				Main.dispose();
			}

			public ChessMap getnCM() {
				return nCM;
			}

			public void setnCM(ChessMap nCM) {
				this.nCM = nCM;
			}
		});
		
		JButton ManVSMan = new JButton("两人对战");
		ManVSMan.setBounds(220, 180, 180, 80);
		ManVSMan.addActionListener(new ActionListener() {			
			private ChessMap nCM;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setGameMode(2);
				setnCM(new ChessMap(CT));
				Main.dispose();
			}

			public ChessMap getnCM() {
				return nCM;
			}

			public void setnCM(ChessMap nCM) {
				this.nCM = nCM;
			}
		});
			
		panel.add(bk);
		panel.add(white);
		panel.add(black);
		panel.add(ManVSMan);
		panel.add(ManVSRob);
		ManVSRob.repaint();
		ManVSMan.repaint();
		white.repaint();
		black.repaint();
		Main.add(panel);
		Main.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==white) {
			setChessType(BasicRules.white);
		}else if(e.getSource()==black) {
			setChessType(BasicRules.black);
		}
	}
	
	public  void setGameMode(int GM) {
		GUI.GM = GM;
	}
	
	public  void setChessType(int CT) {
		GUI.CT= CT;
	}
}

class ChessMap implements MouseListener,MouseMotionListener{
	
	ImageIcon title = new ImageIcon(this.getClass().getResource("Image/title.png"));
	ImageIcon MainGUIBackground = new ImageIcon(this.getClass().getResource("Image/MainGUIBackground.png"));
	ImageIcon ChessMap = new ImageIcon(this.getClass().getResource("Image/chessMap.jpg"));
	int chesstype;
	
	public ChessMap(int chesstype) {
		this.MainChessMap();
		this.chesstype=chesstype;
		System.out.println(GUI.GM+" "+chesstype);
		if(GUI.GM==1) {
			if(chesstype==-1) {
			ai3 = new AIplayer(-chesstype);
			}
		}
	}
	
	static int x=0;static int y=0;
	static JFrame CM = new JFrame("Y-i");
	private AIplayer ai;
	private AIplayer ai2;
	private endGame end;
	private AIplayer ai3;
	public void MainChessMap(){		
		CM.setSize(850, 900);
		CM.getContentPane();
		CM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CM.setIconImage(title.getImage());
		CM.setResizable(false);
		CM.setLocation(500, 60);
		
		@SuppressWarnings("serial")
		JPanel draw = new JPanel() {
			public void paint(Graphics g) {
				//super.paint(g);
				Graphics2D g2 =(Graphics2D) g;
				new Thread(){
					public void run() {
						g2.drawImage(ChessMap.getImage(), 0, 0, CM.getWidth() ,CM.getHeight(),null);
						g2.fillOval(44, 47, 20, 20);
						for(int i=44;i<=800;i+=53) {
							for(int j=47;j<=840;j+=56) {
								if(BasicRules.chessMap[(i-44)/53][(j-47)/56]==BasicRules.black) {
									g2.setColor(Color.BLACK);
									g2.fillOval(i, j, 20, 20);
						//			System.out.println(i+" black "+j);
								}else if(BasicRules.chessMap[(i-44)/53][(j-47)/56]==BasicRules.white) {
									g2.setColor(Color.LIGHT_GRAY);
									g2.fillOval(i, j, 20, 20);
						//			System.out.println(i+" white "+j);
								}					
							}
						}
						try {   
					          Thread.sleep(100);   
					    } catch(InterruptedException ex) {  
					    }   
					     //  repaint();  
						}  
				}.start();	
			}
		};
		
		JLabel bk = new JLabel();
		bk.setIcon(ChessMap);
		//draw.add(bk);
		draw.addMouseListener((MouseListener) this);
		draw.addMouseMotionListener((MouseMotionListener) this);
		
		CM.add(draw);
		draw.validate();
		CM.setVisible(true);
	}
	
	public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        System.out.println(x+" "+y);
        int startx=44;
		int starty=47;
		int dx = 53;
		int dy = 56;
		int endx = (x-startx)/dx;
		int endy = (y-starty)/dy;
		System.out.println(endx+" "+endy);
		setAI(endx,endy);
		
    }

	private void setAI(int x,int y) {
		BasicRules br = new BasicRules();	
		
		if(chesstype==BasicRules.black) {
			setAi(new AIplayer(-chesstype));
			br.setMap(chesstype, x, y);
		}else if(chesstype==BasicRules.white) {
			br.setMap(chesstype, x, y);
			setAi2(new AIplayer(-chesstype));
		}
		if(br.resOfScan()) {
			setEnd(new endGame());
		}
	}
	
	static void closeFrame() {
		CM.dispose();
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public endGame getEnd() {
		return end;
	}

	public void setEnd(endGame end) {
		this.end = end;
	}

	public AIplayer getAi2() {
		return ai2;
	}

	public void setAi2(AIplayer ai2) {
		this.ai2 = ai2;
	}

	public AIplayer getAi() {
		return ai;
	}

	public void setAi(AIplayer ai) {
		this.ai = ai;
	}
}

class endGame extends JFrame {
	public endGame() {
		JFrame main = new JFrame();
		ImageIcon title = new ImageIcon(this.getClass().getClassLoader().getResource("Image/title.png"));
		main.setIconImage(title.getImage());
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(320, 140);
		main.setLocation(500,520);
		main.setFont(new Font("宋体",Font.PLAIN,50));
		main.setTitle("游戏结束");
		
		JPanel end = new JPanel();
		end.setLayout(new FlowLayout());
		
		JLabel endOfGame = new JLabel();
		endOfGame.setFont(new Font("宋体",Font.PLAIN,30));
		//endOfGame.setPreferredSize(new Dimension(250,50));
		BasicRules br = new BasicRules();
		int res = br.scan();
		if(res==BasicRules.black) {
			endOfGame.setText("游戏结束：黑方获胜");
		}else if(res==BasicRules.white) {
			endOfGame.setText("游戏结束：白方获胜");
		}
		
		JButton sure = new JButton();
		sure.setText("结束游戏");
		sure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub			
				ChessMap.closeFrame();
				main.dispose();
			}
		});
		
		JButton again = new JButton();
		again.setText("再来一次");
		again.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BasicRules.cleanCM();
				main.dispose();
			}
			
		});
			
		end.add(endOfGame);
		end.add(again);
		end.add(sure);
		main.add(end);
	}
}


