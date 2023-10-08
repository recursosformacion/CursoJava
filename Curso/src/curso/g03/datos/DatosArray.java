package curso.g03.datos;

public class DatosArray {

	public static void main(String[] args) {
		int[] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
		int[][] elMes =new int[5][7];		
		elMes[0][0]=1;
		elMes[0][1]=2;
		elMes[0][2]=3;
		elMes[0][3]=4;
		elMes[0][4]=5;
		elMes[0][5]=6;
		elMes[0][6]=7;
		elMes[1][0]=8;
		elMes[1][1]=9;
		elMes[1][2]=10;
		elMes[1][3]=11;
		elMes[1][4]=12;
		elMes[1][5]=13;
		elMes[1][6]=14;
		elMes[2][0]=15;
		elMes[2][1]=16;
		elMes[2][2]=17;
		elMes[2][3]=18;
		elMes[2][4]=19;
		elMes[2][5]=20;
		elMes[2][6]=21;
		elMes[3][0]=22;
		elMes[3][1]=23;
		elMes[3][2]=24;
		elMes[3][3]=25;
		elMes[3][4]=26;
		elMes[3][5]=27;
		elMes[3][6]=28;
		elMes[4][0]=29;
		elMes[4][1]=30;
		elMes[4][2]=31;	
		
		for (int a=0;a<elMes.length;a++)
			for (int b=0;b<elMes[a].length;b++)
				System.out.println(elMes[a][b]);
	
	}

}
