package io.github.sukiyakibeer.ninestarastrology;

/* 九星気学 年盤表示プログラム */
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("九星気学 年盤表示プログラム");
        KigakuMatrix nsm = new KigakuMatrix();// makeMatrixクラスのインスタンス生成
                
         // 対象年月の取得
        System.out.print("年盤を表示したい西暦年を入力してください: ");
        Scanner year = new Scanner(System.in);
        int y = year.nextInt();
        
        if (y < 1907) {// 計算は1906年が基準年だが年盤は前年も表示するため入力は1907年以降とする
            System.out.println("1907年以降の西暦年を入力してください");
            year.close();
            return;
        }

        System.out.print("月盤を表示したい月を入力してください: ");
        Scanner month = new Scanner(System.in);
        int m = month.nextInt();
        
        nsm.calcYear(y);
        nsm.calcMonth(m, y);

        year.close();
        month.close();
    }
    
}
