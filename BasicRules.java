
public class BasicRules {
	
	public static int[][] chessMap = new int[15][15];//White first
	public static int white = 1;public static int black = -1;//白棋为1，黑棋为-1
	
	public boolean setMap(int chessType,int x,int y) {
		if(chessMap[x][y]==0) {
			
			chessMap[x][y] = chessType;
			System.out.println("上一步是 : ("+x+","+y+") "+!resOfScan()+" "+scan());
		
			if(!resOfScan()) {
				return true;
			}
		
		}else if(chessMap[x][y]!=0){
				System.out.println("("+x+","+y+")"+" 这个位置已经有棋了");			
			}
		 	
		 	return false;

	}
	
	public boolean resOfScan() {
		int result = scan();
			if(result == black) {
				System.out.println("黑方胜利");
				return true;
			}
			if(result == white) {
				System.out.println("白方胜利");
				return true;
			}
			return false;
	}
	
	public int scan() {
		int i,j;int n = 15;
		for(i=0;i<15;i++) {
			for(j=0;j<15;j++) {
				
				int tmp=chessMap[i][j];
				if(tmp!=0) {
					if((j<=n-5 && i<=n-5 && chessMap[i+1][j+1]==tmp && chessMap[i+2][j+2]==tmp && chessMap[i+3][j+3]==tmp && chessMap[i+4][j+4]==tmp)
						|| (j>=4   && i<=n-5 && chessMap[i+1][j-1]==tmp && chessMap[i+2][j-2]==tmp && chessMap[i+3][j-3]==tmp && chessMap[i+4][j-4]==tmp)
						|| (j<=n-5 && chessMap[i][j+1]==tmp && chessMap[i][j+2]==tmp && chessMap[i][j+3]==tmp && chessMap[i][j+4]==tmp)
						|| (i<=n-5 && chessMap[i+1][j]==tmp && chessMap[i+2][j]==tmp && chessMap[i+3][j]==tmp && chessMap[i+4][j]==tmp))
						    return tmp;
				}
					
			}
		}
		return 0;
	}
	
	static void cleanCM() {
		for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					chessMap[i][j]=0;
				}
			}
	}
}
