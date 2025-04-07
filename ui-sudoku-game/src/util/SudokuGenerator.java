package util;

import java.util.*;

public class SudokuGenerator {

    public static String[] generateSudokuInputs(int visibleValues) {
        int[][] board = gerateCompleteBoard();

        // Lista que armazenará as strings no formato "column,line;value,true/false"
        List<String> inputs = new ArrayList<>();

        // Cria todas as posições possíveis (linha, coluna)
        List<int[]> positions = new ArrayList<>();
        for (int line = 0; line < 9; line++) {
            for (int column = 0; column < 9; column++) {
                positions.add(new int[]{line, column});
            }
        }

        // Embaralha as posições
        Collections.shuffle(positions);

        // Define os visíveis (true)
        boolean[][] visible = new boolean[9][9];
        for (int i = 0; i < visibleValues; i++) {
            int[] pos = positions.get(i);
            visible[pos[0]][pos[1]] = true;
        }

        // Constrói a lista de strings formatadas
        for (int line = 0; line < 9; line++) {
            for (int column = 0; column < 9; column++) {
                int value = board[line][column];
                boolean isVisible = visible[line][column];
                inputs.add(String.format("%d,%d;%d,%s", column, line, value, isVisible));
            }
        }

        // Embaralha a lista final, para deixar os inputs em ordem aleatória também
        Collections.shuffle(inputs);

        return inputs.toArray(new String[0]);
    }

    private static int[][] gerateCompleteBoard() {
        int[][] board = new int[9][9];
        fill(board);
        return board;
    }

    private static boolean fill(int[][] board) {
        for (int line = 0; line < 9; line++) {
            for (int column = 0; column < 9; column++) {
                if (board[line][column] == 0) {
                    List<Integer> numbers = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) numbers.add(i);
                    Collections.shuffle(numbers);
                    for (int n : numbers) {
                        if (uniqueValueILineOrColumn(board, line, column, n)) {
                            board[line][column] = n;
                            if (fill(board)) return true;
                            board[line][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean uniqueValueILineOrColumn(int[][] board, int line, int column, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[line][i] == num || board[i][column] == num) return false;
            int lineBlock = 3 * (line / 3) + i / 3;
            int columnBlock = 3 * (column / 3) + i % 3;
            if (board[lineBlock][columnBlock] == num) return false;
        }
        return true;
    }
}
