package Main.java;
import java.util.Scanner;

public class XOXGame {
	 // Tahtayı temsil eden dizi
    char[][] board = new char[3][3];

    // Oyunun hangi oyuncunun sırası olduğunu temsil eden değişken
    char currentPlayer = 'X';

    // Oyunun bitip bitmediğini temsil eden değişken
    boolean gameFinished = false;

    public XOXGame() {
        // Tahtayı başlangıçta boş olarak ilklendir
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Oyun döngüsü
    public void play() {
        Scanner sc = new Scanner(System.in);

        // Oyun bitene kadar döngü devam edecek
        while (gameFinished==false) {
            // Tahtayı ekrana yazdır
            printBoard();

            // Oyuncuya sıradaki hamle yapması için bir kare seçimi yaptır
            System.out.print("Sıradaki oyuncu (" + currentPlayer + "), bir kare seçin (satır sütun): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Oyuncunun seçtiği kareye hamle yap
            board[row][col] = currentPlayer;

            // Oyunun bitip bitmediğini kontrol et
            checkFinish();

            // Sıradaki oyuncunun X veya O olduğunu belirle
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }

        if(gameFinished==true) {
        // Oyun bittiğinde, kazanan oyuncuyu veya berabere olduğunu ekrana yazdır
        if (currentPlayer == 'X') {
            System.out.println("Oyunu O kazandı!");
        } else if (currentPlayer == 'O') {
            System.out.println("Oyunu X kazandı!");
        } else {
            System.out.println("Oyun berabere bitti!");}
        }
    }

public void printBoard() {
    // Tahtayı ekrana yazdır
    for (int i = 0; i < 3; i++) {
        System.out.println("  "+board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
        if (i != 2) {
            System.out.println(" -----------");
        }
    }
    System.out.println();
}

public void checkFinish() {
    // Satırları kontrol et
	for (int i = 0; i < 3; i++) {
	    if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	        gameFinished=true;
	    	return ;
	    }
	}

    // Sütunları kontrol et
	for (int i = 0; i < 3; i++) {
	    if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
	        gameFinished=true;
	    	return;
	    }
	}

    // Çaprazları kontrol et
	if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
	    gameFinished=true;
	    return;
	}

	if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
	    gameFinished=true;
		return;
	}
    else
    { gameFinished = false;}
    // Eğer hiçbir şart sağlanmadıysa, oyun bitmedi
   
}

}
