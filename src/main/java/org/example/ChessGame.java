package org.example;

import java.util.*;

public class ChessGame extends AbstractGame {
    private final Chess[] board = new Chess[32];

    public Chess[] getBoard() { return board; }

    public void generateChess() {
        List<Chess> deck = new ArrayList<>();
        String[] rN = {"帥", "仕", "相", "俥", "傌", "炮", "兵"};
        String[] bN = {"將", "士", "象", "車", "馬", "包", "卒"};
        int[] w = {7, 6, 5, 4, 3, 2, 1};
        int[] counts = {1, 2, 2, 2, 2, 2, 5};

        for (int i = 0; i < rN.length; i++) {
            for (int c = 0; c < counts[i]; c++) {
                deck.add(new Chess(rN[i], w[i], "紅"));
                deck.add(new Chess(bN[i], w[i], "黑"));
            }
        }
        Collections.shuffle(deck);
        for (int i = 0; i < 32; i++) board[i] = deck.get(i);
    }

    public void showAllChess() {
        System.out.println("\n   1   2   3   4   5   6   7   8");
        for (int i = 0; i < 4; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < 8; j++) {
                int idx = i * 8 + j;
                System.out.print(board[idx] == null ? " ＿ " : board[idx]);
            }
            System.out.println();
        }
    }

    public int posToIndex(String input) {
        try {
            input = input.trim().toUpperCase();
            int row = input.charAt(0) - 'A';
            int col = Integer.parseInt(input.substring(1)) - 1;
            return (row >= 0 && row < 4 && col >= 0 && col < 8) ? row * 8 + col : -1;
        } catch (Exception e) { return -1; }
    }

    @Override public boolean move(int loc) {
        if (loc < 0 || loc >= 32 || board[loc] == null || board[loc].isOpened) return false;
        board[loc].isOpened = true; return true;
    }

    @Override public boolean move(int from, int to) {
        if (from == to || board[from] == null || !board[from].isOpened) return false;

        Chess p1 = board[from];
        Chess p2 = board[to];
        int r1 = from / 8, c1 = from % 8, r2 = to / 8, c2 = to % 8;
        int distRow = Math.abs(r1 - r2);
        int distCol = Math.abs(c1 - c2);
        int totalDist = distRow + distCol;

        if (p1.weight == 4) {
            if (r1 != r2 && c1 != c2) return false;
            if (countBetween(r1, c1, r2, c2) != 0) return false;
            if (p2 == null) { executeMove(from, to); return true; }
            return handleBattle(from, to, (totalDist > 1));
        }

        if (p1.weight == 3) {
            if (p2 == null) {
                if ((r1 == r2 || c1 == c2) && countBetween(r1, c1, r2, c2) == 0) {
                    executeMove(from, to); return true;
                }
            } else if (distRow == 1 && distCol == 1) {
                return handleBattle(from, to, true);
            }
            return false;
        }

        if (p1.weight == 2) {
            if (p2 == null) {
                if (totalDist == 1) { executeMove(from, to); return true; }
            } else if (r1 == r2 || c1 == c2) {
                if (countBetween(r1, c1, r2, c2) == 1) return handleBattle(from, to, true);
            }
            return false;
        }

        if (totalDist == 1) {
            if (p2 == null) { executeMove(from, to); return true; }
            return handleBattle(from, to, false);
        }

        return false;
    }

    private boolean handleBattle(int from, int to, boolean ignoreWeight) {
        Chess p1 = board[from];
        Chess p2 = board[to];
        boolean targetWasOpened = p2.isOpened;

        if (!targetWasOpened) {
            p2.isOpened = true;
            if (p1.side.equals(p2.side)) {
                System.out.println(">> 暗吃翻開是自己人，兩棋存活！");
                return true;
            }
            if (ignoreWeight || canEat(p1, p2)) {
                System.out.println(">> 擊殺成功: " + p2.name);
                executeMove(from, to);
            } else {
                System.out.println(">> 進攻失敗！" + p1.name + " 撞到 " + p2.name + " 自爆。");
                board[from] = null;
            }
            return true;
        } else { // 明吃
            if (p1.side.equals(p2.side)) return false;
            if (ignoreWeight || canEat(p1, p2)) {
                System.out.println(">> 擊殺成功: " + p2.name);
                executeMove(from, to);
                return true;
            }
            return false;
        }
    }

    private int countBetween(int r1, int c1, int r2, int c2) {
        int count = 0;
        if (r1 == r2) {
            for (int j = Math.min(c1, c2) + 1; j < Math.max(c1, c2); j++) if (board[r1 * 8 + j] != null) count++;
        } else {
            for (int i = Math.min(r1, r2) + 1; i < Math.max(r1, r2); i++) if (board[i * 8 + c1] != null) count++;
        }
        return count;
    }

    private boolean canEat(Chess p1, Chess p2) {
        if (p1.weight == 1 && p2.weight == 7) return true;
        if (p1.weight == 7 && p2.weight == 1) return false;
        return p1.weight >= p2.weight;
    }

    private void executeMove(int from, int to) { board[to] = board[from]; board[from] = null; }

    @Override void setPlayers(String p1, String p2) {}
    @Override boolean gameOver() { return false; }
}