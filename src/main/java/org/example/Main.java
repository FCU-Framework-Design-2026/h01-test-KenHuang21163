package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.generateChess();
        Scanner sc = new Scanner(System.in);

        System.out.println("====== 台灣暗棋 ======");

        while (true) {
            game.showAllChess();
            System.out.print("\n請輸入位置 (如 A1, 輸入 exit 離開): ");
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) break;

            int idx = game.posToIndex(input);
            if (idx == -1) {
                System.out.println(">> 錯誤：座標超出範圍！");
                continue;
            }

            Chess current = game.getBoard()[idx];
            if (current == null) {
                System.out.println(">> 該位置是空的！");
            } else if (!current.isOpened) {
                game.move(idx);
                System.out.println(">> 翻開了棋子！");
            } else {
                System.out.print(">> 選中 " + current.name + "，請輸入目的座標: ");
                String targetInput = sc.next();
                int targetIdx = game.posToIndex(targetInput);
                if (game.move(idx, targetIdx)) {
                    System.out.println(">> 行動成功！");
                } else {
                    System.out.println(">> 行動無效：規則不符或階級不足！");
                }
            }
            System.out.println("---------------------------------------");
        }
        System.out.println("遊戲結束，謝謝遊玩。");
    }
}