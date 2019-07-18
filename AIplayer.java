
//设定应该是白棋先手，黑棋后手
//那么白棋AI就需要首先随机下几步
//而黑棋在第一步需要做的是跟随

import java.util.*;

public class AIplayer {
	
	private static final int EMPTY = 0;
	private final int black = -1;
	private final int white = 1;
	
	public AIplayer(int chessType) {
		if(chessType==BasicRules.white)
			white(BasicRules.chessMap);
		if(chessType==BasicRules.black)
			black(BasicRules.chessMap);
	}
	
	BasicRules bRules = new BasicRules();
	int sx = 0;int sy = 0;
	
	
//--------------白色AI---------------------------
	void white(int[][] chessMap) {
		BasicRules br = new BasicRules();
		int col,row;
		
		int Y=0;
    	int k=0,s=0,x=0,y = 0;
    	int MAP_SIZE = 15;
    //TODO
    //补5
     for(int i=0;i<MAP_SIZE;i++){
            for(int j=0;j<MAP_SIZE-5;j++){
                if((chessMap[i][j] == black||chessMap[i][j+1] == black||chessMap[i][j+2] ==black||chessMap[i][j+3] == black||chessMap[i][j+4]==black)&&Y==0){
                    k++;
                }
                if((chessMap[i][j] == EMPTY||chessMap[i][j+1] == EMPTY||chessMap[i][j+2] ==EMPTY||chessMap[i][j+3] ==EMPTY||chessMap[i][j+4]==black)&&Y==0){
                    s++;
                    x=i;
                    y=j;
                	}
            }
        }
    if(k==4&&s==1&&Y==0)
    {
    	for(int i=y;i<y+5;i++)
    	if(chessMap[x][i]==EMPTY)
    	{
    		row=x;
    		col=i;
    		Y=1;
    		if(chessMap[row][col]==EMPTY)
    		return;
		}
	}
    for(int i=0;i<MAP_SIZE-5;i++){
            for(int j=0;j<MAP_SIZE;j++){
                 if((chessMap[i][j] == black||chessMap[i+1][j] ==black||chessMap[i+2][j] == black||chessMap[i+3][j] == black||chessMap[i+4][j]==black)&&Y==0){
                    k++;
                }
                 if((chessMap[i][j] == EMPTY||chessMap[i+1][j] ==EMPTY||chessMap[i+2][j] == EMPTY||chessMap[i+3][j] == EMPTY||chessMap[i+4][j]==EMPTY)&&Y==0){
                    s++;
                    x=i;
                    y=j;
                }
            }
        }
        if(k==4&&s==1&&Y==0)
    {
    	for(int i=x;i<x+5;i++)
    	if(chessMap[i][y]==EMPTY)
    	{
    		row=i;
    		col=y;
    		Y=1;
    		if(chessMap[row][col]==EMPTY)
    		return;
		}
	}
    for(int i=0;i<MAP_SIZE-5;i++){
            for(int j=0;j<MAP_SIZE-5;j++){
                if((chessMap[i][j] == black||chessMap[i+1][j+1] == black||chessMap[i+2][j+2] == black||chessMap[i+3][j+3] == black||chessMap[i+4][j+4]==black)&&Y==0){
                    k++;
                }
                 if((chessMap[i][j] == EMPTY||chessMap[i+1][j+1] == EMPTY||chessMap[i+2][j+2] == EMPTY||chessMap[i+3][j+3] == EMPTY||chessMap[i+4][j+4]==EMPTY)&&Y==0){
                    s++;
                    x=i;
                    y=j;
                }
            }
        }
    if(k==4&&s==1&&Y==0)
    {
    	for(int i=x;i<x+5;i++)
    	for(int j=y;j<y+5;j++)
    	if(chessMap[i][j]==EMPTY)
    	{
    		row=i;
    		col=j;
    		Y=1;
    		if(chessMap[row][col]==EMPTY)
    		return;
		}
	}
    for(int i=4;i<MAP_SIZE;i++){
            for(int j=0;j<MAP_SIZE-5;j++){
                if((chessMap[i][j] == black||chessMap[i-1][j+1] == black||chessMap[i-2][j+2] == black||chessMap[i-3][j+3] ==black||chessMap[i-4][j+4]==black)&&Y==0){
                  k++;
                }
                if((chessMap[i][j] == EMPTY||chessMap[i-1][j+1] == EMPTY||chessMap[i-2][j+2] == EMPTY||chessMap[i-3][j+3] ==EMPTY||chessMap[i-4][j+4]==EMPTY)&&Y==0){
                  s++;
                  x=i;
                  y=j;
                }
            }
        }
     if(k==4&&s==1&&Y==0)
    {
    	for(int i=x;i>x-5;i--)
    	for(int j=y;j<y+5;j++)
    	if(chessMap[i][j]==EMPTY)
    	{
    		row=i;
    		col=j;
    		Y=1;
    		if(chessMap[row][col]==EMPTY)
    		return;
		}
	}

    //防守
      for(int i=0;i<MAP_SIZE;i++){
            for(int j=0;j<MAP_SIZE-4;j++){
                if(chessMap[i][j] == white&&chessMap[i][j+1] == white&&chessMap[i][j+2] == white&&chessMap[i][j+3] == EMPTY&&chessMap[i][j-1]!=black&&Y==0){
                    row = i;
                    col = j+3;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
      for(int i=0;i<MAP_SIZE;i++){
            for(int j=1;j<MAP_SIZE-4;j++){
                if(chessMap[i][j] == white&&chessMap[i][j+1] == white&&chessMap[i][j+2] == white&&chessMap[i][j+3] != black&&chessMap[i][j-1]==EMPTY&&Y==0){
                    row = i;
                    col = j-1;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
       for(int i=0;i<MAP_SIZE-4;i++){
            for(int j=0;j<MAP_SIZE;j++){
                 if(chessMap[i][j] == white&&chessMap[i+1][j] == white&&chessMap[i+2][j] == white&&chessMap[i+3][j] == EMPTY&&chessMap[i-1][j]!=black&&Y==0){
                    row = i+3;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
      for(int i=1;i<MAP_SIZE-4;i++){
            for(int j=0;j<MAP_SIZE;j++){
                if(chessMap[i][j] == white&&chessMap[i+1][j] == white&&chessMap[i+2][j] == white&&chessMap[i+3][j] != black&&chessMap[i-1][j]==EMPTY&&Y==0){
                    row = i-1;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
		}
     for(int i=0;i<MAP_SIZE-4;i++){
            for(int j=0;j<MAP_SIZE-4;j++){
                if(chessMap[i][j] == white&&chessMap[i+1][j+1] == white&&chessMap[i+2][j+2] == white&&chessMap[i+3][j+3] == EMPTY&&chessMap[i-1][j-1]!=black&&Y==0){
                    row = i+3;
                    col = j+3;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
    for(int i=1;i<MAP_SIZE-4;i++){
            for(int j=1;j<MAP_SIZE-4;j++){
                if(chessMap[i][j] == white&&chessMap[i+1][j+1] == white&&chessMap[i+2][j+2] == white&&chessMap[i+3][j+3] != black&&chessMap[i-1][j-1]==EMPTY&&Y==0){
                    row = i-1;
                    col = j-1;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
    for(int i=3;i<MAP_SIZE-1;i++){
            for(int j=0;j<MAP_SIZE-1;j++){
                if(chessMap[i][j] == white&&chessMap[i-1][j+1] == white&&chessMap[i-2][j+2] == white&&chessMap[i-3][j+3] == EMPTY&&chessMap[i+1][j-1]!=black&&Y==0){
                    row = i-3;
                    col = j+3;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
    for(int i=3;i<MAP_SIZE-1;i++){
            for(int j=1;j<MAP_SIZE-1;j++){
                if(chessMap[i][j] == white&&chessMap[i-1][j+1] == white&&chessMap[i-2][j+2] == white&&chessMap[i-3][j+3] != black&&chessMap[i+1][j-1]==EMPTY&&Y==0){
                    row = i+1;
                    col = j-1;
                    Y=1;
                    if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
	//冲2
	 for(int i=0;i<MAP_SIZE;i++){
            for(int j=0;j<MAP_SIZE-2;j++){
                if(chessMap[i][j] == black&&chessMap[i][j+1]==EMPTY&&Y==0){
                    row = i;
                    col = j+1;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
                  if(chessMap[i][j] == EMPTY&&chessMap[i][j+1]==black&&Y==0){
                    row = i;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
        for(int i=0;i<MAP_SIZE-2;i++){
            for(int j=0;j<MAP_SIZE;j++){
                if(chessMap[i][j] ==black &&chessMap[i+1][j]==EMPTY&&Y==0){
                    row = i+1;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
                for(j=0;j<MAP_SIZE;j++){
                if(chessMap[i][j] ==EMPTY &&chessMap[i+1][j]==black&&Y==0){
                    row = i;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
    }
        for(int i=0;i<MAP_SIZE-2;i++){
            for(int j=0;j<MAP_SIZE-2;j++){
                if(chessMap[i][j] ==black &&chessMap[i+1][j+1]==EMPTY&&Y==0){
                    row = i+1;
                    col = j+1;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
                for(j=0;j<MAP_SIZE-1;j++){
                if(chessMap[i][j] ==EMPTY &&chessMap[i+1][j+1]==black&&Y==0){
                    row = i;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
    }
        for(int i=1;i<MAP_SIZE-2;i++){
            for(int j=5;j<MAP_SIZE-1;j++){
                if(chessMap[i][j] ==black &&chessMap[i-1][j+1]==EMPTY&&Y==0){
                    row = i-1;
                    col = j+1;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
                for(j=0;j<MAP_SIZE-2;j++){
                if(chessMap[i][j] ==EMPTY &&chessMap[i-1][j+1]==black&&Y==0){
                    row = i;
                    col = j;
                    Y=1;
                	if(chessMap[row][col]==EMPTY)
                    return;
                }
            }
        }
	 }
    while(Y==0){
        int i = (int) (15*Math.random()) ;
        int j = (int) (15*Math.random()) ;
        if(chessMap[i][j] == EMPTY){
                row = i;
                col = j;
                break;
            }
        }
		
		
//---------------------------------------------------
		
		if(br.setMap(white,x,y)) {
			return;
		}else if(br.resOfScan()){
			return;
		}
	}
	
//---------------------黑色AI-------------------------
	
	void black(int[][] chessMap) {
		BasicRules br = new BasicRules();
		int x = 0,y = 0;int MAP_SIZE = 15;
		
		int t=0;

        int i,j;
        int[][] cm = new int[MAP_SIZE+4][MAP_SIZE+4];
        for(i=0;i<MAP_SIZE+4;i++){
            cm[0][i]=5;
            cm[1][i]=5;
            cm[MAP_SIZE+1][i]=5;
            cm[MAP_SIZE+2][i]=5;
            cm[i][0]=5;
            cm[i][1]=5;
            cm[i][MAP_SIZE+1]=5;
            cm[i][MAP_SIZE+2]=5;
        }
        for(i=0;i<MAP_SIZE;i++){
        	for(j=0;j<MAP_SIZE;j++){
        		if(chessMap[i][j]==white)
        			cm[i+2][j+2]=1;
        		if(chessMap[i][j]==black)
        			cm[i+2][j+2]=-1;
        		if(chessMap[i][j]==EMPTY)
        			cm[i+2][j+2]=0;
			}
		}										//设置棋盘

        int m,n,l=0,m1,n1;                //设置随机数
        m=(int) (15*Math.random()) ;
        n=(int) (15*Math.random()) ;
       for(i=2;i<17;i++){
        for(j=2;j<i;j++){
           if(cm[i][j]>0)
               l=l+cm[i][j];
            if(cm[i][j]<0)
               l=l-cm[i][j];
        }
       }
        if(l==0){
                m1=m;
                n1=n;
                x=m1;
                y=n1;
        }


        int x1,y1;
		for(y1=2;y1<MAP_SIZE+2;y1++){
        	for(x1=2;x1<MAP_SIZE+2;x1++){
				t=cm[x1][y1]+cm[x1+1][y1+1];
				if(t*t==4)
				{
				    if(cm[x1+2][y1+2]==0){
                        x=x1+2;
                        y=y1+2;
                        break;
				    }else if(cm[x1-1][y1-1]==0){
                        x=x1-1;
                        y=y1-1;
                        break;
				    }
                }
            }
		}

        int x2,y2;
		for(x2=2;x2<MAP_SIZE+2;x2++){
        	for(y2=2;y2<MAP_SIZE+2;y2++){
				t=cm[x2][y2]+cm[x2-1][y2+1];
				if(t*t==4)
				{
				     if(cm[x2-2][y2+2]==0){
                        x=x2-2;
                        y=y2+2;
                        break;
				    }else if(cm[x2+1][y2-1]==0){
                        x=x2+1;
                        y=y2-1;
                        break;
				    }
				}
			}
		}

        int x3,y3;
		for(y3=2;y3<MAP_SIZE+2;y3++){
        	for(x3=2;x3<MAP_SIZE+2;x3++){
				t=cm[x3][y3]+cm[x3+1][y3];
				if(t*t==4)
				{
				     if(cm[x3+2][y3]==0){
                        x=x3+2;
                        y=y3;
                        break;
				    }else if(cm[x3-1][y3]==0){
                        x=x3-1;
                        y=y3;
                        break;
				    }
				}
			}
		}

        int x4,y4;
		for(x4=2;x4<MAP_SIZE+2;x4++){
        	for(y4=2;y4<MAP_SIZE+2;y4++){
				t=cm[x4][y4]+cm[x4][y4+1];
				if(t*t==4)
				{
				     if(cm[x4][y4+2]==0){
                        x=x4;
                        y=y4+2;
                        break;
				    }else if(cm[x4][y4-1]==0){
                        x=x4;
                        y=y4-1;
                        break;
				    }
				}
			}
		}



		int xx1,yx1;
		for(yx1=2;yx1<MAP_SIZE+2;yx1++){
        	for(xx1=2;xx1<MAP_SIZE+2;xx1++){
				t=cm[xx1][yx1]+cm[xx1+1][yx1+1]+cm[xx1+2][yx1+2];
				if(t*t==9)
				{
				    if(cm[xx1+3][yx1+3]==0){
                        x=xx1+3;
                        y=yx1+3;
                        break;
				    }else if(cm[xx1-1][yx1-1]==0){
                        x=xx1-1;
                        y=yx1-1;
                        break;
				    }

				}
			}
		}

        int xx2,yx2;
		for(xx2=2;xx2<MAP_SIZE+2;xx2++){
        	for(yx2=2;yx2<MAP_SIZE+2;yx2++){
				t=cm[xx2][yx2]+cm[xx2-1][yx2+1]+cm[xx2-2][yx2+2];
				if(t*t==9)
				{
				     if(cm[xx2-3][yx2+3]==0){
                        x=xx2-3;
                        y=yx2+3;
                        break;
				    }else if(cm[xx2+1][yx2-1]==0){
                        x=xx2+1;
                        y=yx2-1;
                        break;
				    }
				}
			}
		}

        int xx3,yx3;
		for(yx3=2;yx3<MAP_SIZE+2;yx3++){
        	for(xx3=2;xx3<MAP_SIZE+2;xx3++){
				t=cm[xx3][yx3]+cm[xx3+1][yx3]+cm[xx3+2][yx3];
				if(t*t==9)
				{
				     if(cm[xx3+3][yx3]==0){
                        x=xx3+3;
                        y=yx3;
                        break;
				    }else if(cm[xx3-1][yx3]==0){
                        x=xx3-1;
                        y=yx3;
                        break;
				    }
				}
			}
		}

        int xx4,yx4;
		for(xx4=2;xx4<MAP_SIZE+2;xx4++){
        	for(yx4=2;yx4<MAP_SIZE+2;yx4++){
				t=cm[xx4][yx4]+cm[xx4][yx4+1]+cm[xx4][yx4+2];
				if(t*t==9)
				{
				     if(cm[xx4][yx4+3]==0){
                        x=xx4;
                        y=yx4+3;
                        break;
				    }else if(cm[xx4][yx4-1]==0){
                        x=xx4;
                        y=yx4-1;
                        break;
				    }
				}
			}
		}

      /*  if(cm[x][y]!=0){
           if(cm[x][y+1]==0){
                y=y+1;

           }
           if(cm[x+1][y]==0){
                x=x+1;

           }
           if(cm[x-1][y]==0){
                x=x-1;

           }
           if(cm[x][y-1]==0){
                y=y-1;

           }
        }*/

        if(x<2){
                x=2*x;
        }if(y<2){
                y=2*y;
        }
        if(x>17){
             x=sx-1;
         }if(y>17){
             y=sy-1;
         }

          /*if(cm[x][y]!=0){
                if(cm[x+1][y]==0){
                    x=x+1;
                    y=y;
                }else if(cm[x][y]==0){
                    x=x;
                    y=y+1;
                }else if(cm[x][y]==0){
                    x=x+1;
                    y=y+1;
                }else if(cm[x][y-1]==0){
                    x=x-1;
                    y=y-1;
                }else if(cm[x-1][y]==0){
                    x=x-1;
                    y=y;
                }else if(cm[x][y-1]==0){
                    x=x;
                    y=y-1;
                }else if(cm[x+1][y-1]==0){
                    x=x+1;
                    y=y-1;
                }else if(cm[x-1][y+1]==0){
                    x=x-1;
                    y=y+1;
                }
        }*/

        sx=x;
        sy=y;
        x=x-2;
        y=y-2;		
	
//--------------------------------------------
        
		if(br.setMap(black,x,y)) {	
			return;
		}else if(br.resOfScan()){
			return;
		}
		
	
	}
}
