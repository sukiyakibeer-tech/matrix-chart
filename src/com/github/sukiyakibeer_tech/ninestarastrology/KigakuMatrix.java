package com.github.sukiyakibeertech.matrixchart;

public class KigakuMatrix {
    // 基準年・基準月の設定
    final int BASE_YEAR = 1906;
    // 1905年以前を算出したい場合は1906から9年ずつ遡ってBASE_YEARを設定してください
    final int BASE_MONTH = 3;
    // 3月を基準（基準月は3月でなくてもいいのですが、月盤の計算式の形を年盤と似せるため）
    // 現コードの計算式を維持するためには、基準年を変えると基準月も変更する必要があります

    public int makeMatrix(int matrixNum){
        int[] box = new int[10];
        box[0] = matrixNum;

        for (int i = 0; i < 9; i++){
            box[i+1] = box[i] + 1;
            
            if (box[i+1] > 9){ // 9を超えたら1に戻す
                box[i+1] = 1;
            }
        }
        //Matrix表示
        System.out.printf("%2d %2d %2d\n", box[3],box[8],box[1]);
        System.out.printf("%2d %2d %2d\n", box[2],box[4],box[6]);
        System.out.printf("%2d %2d %2d\n", box[7],box[0],box[5]);
    return matrixNum;
    }

    public int calcYear(int y){
        // 年盤の計算
        KigakuMatrix nsm = new KigakuMatrix();

        for (int i= -1; i < 2 ; i++ ){ // 前後1年分を表示
            int yearNum = 9 - ((y + i - BASE_YEAR) % 9) ; // 基準年からの差を9で割った余りを引く
            System.out.println("\n" + (y + i) + "年の年盤");
            nsm.makeMatrix(yearNum); // 年盤表示
        }
        return y;
    }

    public int calcMonth(int month, int year){
        // 月盤の計算
        KigakuMatrix nsm = new KigakuMatrix();

        // 入力値チェックと1月の前年扱い
        if (month < 1 || month > 12){
            System.out.println("1〜12の月を入力してください");
            return month;
        }else if (month == 1 ){
            year -= 1; // 九星気学では立春から新年となるため、1月は前年扱い
            month = 13; // 1月を13月として計算
        }

        for (int i= -1; i < 2 ; i++ ){ // 前後1月分を表示
            int monthNum = 9 - ((year-BASE_YEAR) * 12 + BASE_MONTH + month + i ) % 9 ;
            
            //前後の月で年が変わる場合の表示調整
            if (month + i >= 13){
                System.out.println("\n" + (year + 1) + "年" + (month + i - 12) + "月の月盤");
            }else{
                System.out.println("\n" + year + "年" + (month + i) + "月の月盤");
            }
            nsm.makeMatrix(monthNum);// 月盤表示
        }
        return month;
    }
}
