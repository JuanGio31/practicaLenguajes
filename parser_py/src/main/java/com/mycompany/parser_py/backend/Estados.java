package com.mycompany.parser_py.backend;

/**
 *
 * @author giovanic
 */
public class Estados {

    private final int[][] matrix;

    public Estados() {
        this.matrix = new int[12][9];
        initEstados();
        initErr();
    }

    private void initEstados() {
        matrix[0][0] = 1;
        matrix[0][1] = 4;
        matrix[0][2] = 7;
        matrix[0][3] = 4;
        matrix[0][6] = 9;
        matrix[0][8] = 8;
        matrix[1][1] = 2;
        matrix[1][7] = 2;
        matrix[2][2] = 1;
        matrix[2][4] = 3;
        matrix[2][5] = 3;
        matrix[2][6] = 1;
        matrix[2][7] = 1;
        matrix[4][4] = 6;
        matrix[4][5] = 6;
        matrix[4][7] = 5;
        matrix[5][1] = 4;
        matrix[5][2] = 4;
        matrix[5][3] = 4;
        matrix[5][7] = 4;
        matrix[7][2] = 7;
        matrix[7][4] = 6;
        matrix[7][5] = 6;
        matrix[8][0] = 8;
        matrix[8][1] = 8;
        matrix[8][2] = 8;
        matrix[8][3] = 8;
        matrix[8][5] = 8;
        matrix[8][6] = 8;
        matrix[8][6] = 8;
        matrix[8][7] = 8;
        matrix[8][8] = 9;
        matrix[9][1] = 9;
        matrix[10][1] = 10;
        matrix[10][4] = 11;
        matrix[10][5] = 11;
    }

    private void initErr() {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix1[j] == 0) {
                    matrix1[j] = -1;
                }
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
