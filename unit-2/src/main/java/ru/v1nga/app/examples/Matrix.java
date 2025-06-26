package ru.v1nga.app.examples;

public class Matrix {

    private final int rows;
    private final int cols;
    private final int[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new int[rows][cols];
    }

    public void setValue(int i, int j, int value) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            data[i][j] = value;
        } else {
            System.out.println("Индекс вне границ матрицы");
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            System.out.println("Матрицы разных размеров, сложение невозможно.");
            return null;
        }

        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiplyByScalar(int scalar) {
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            System.out.println("Нельзя перемножить: число столбцов первой матрицы не равно числу строк второй.");
            return null;
        }

        Matrix result = new Matrix(this.rows, other.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }

        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%d ", data[i][j]);
            }
            System.out.println();
        }
    }
}
