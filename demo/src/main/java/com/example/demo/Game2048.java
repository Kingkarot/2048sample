package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game2048 extends Application {

    private static final int BOARD_SIZE = 4;
    private static final int CELL_SIZE = 50;

    private int[][] board;
    private GridPane gridPane;
    private Label scoreLabel;
    private int score;

    @Override
    public void start(Stage primaryStage) {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        gridPane = new GridPane();
        scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        StackPane root = new StackPane();
        root.getChildren().addAll(gridPane, scoreLabel);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE + 50);
        scene.setOnKeyPressed(this::handleKeyPress);

        initBoard();
        updateUI();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Game 2048");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void initBoard() {
        score = 0;
        addRandomTile();
        addRandomTile();
    }

    private void updateUI() {
        gridPane.getChildren().clear();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE - 2, CELL_SIZE - 2);
                cell.setFill(getTileColor(board[row][col]));
                cell.setStroke(Color.BLACK);
                gridPane.add(cell, col, row);
            }
        }
        scoreLabel.setText("Score: " + score);
    }

    private Color getTileColor(int value) {
        switch (value) {
            case 2:
                return Color.rgb(221, 24, 24);
            case 4:
                return Color.rgb(215, 163, 122);
            case 8:
                return Color.rgb(229, 193, 10);
            case 16:
                return Color.rgb(73, 222, 22);
            case 32:
                return Color.rgb(31, 181, 222);
            case 64:
                return Color.rgb(12, 205, 246);
            case 128:
                return Color.rgb(25, 55, 227);
            case 256:
                return Color.rgb(120, 30, 229);
            case 512:
                return Color.rgb(174, 30, 243);
            case 1024:
                return Color.rgb(225, 27, 168);
            case 2048:
                return Color.rgb(19, 241, 188);
            default:
                return Color.rgb(231, 231, 231);
        }
    }

    private void addRandomTile() {
        List<int[]> emptyCells = new ArrayList<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == 0) {
                    emptyCells.add(new int[]{row, col});
                }
            }
        }
        if (!emptyCells.isEmpty()) {
            int[] cell = emptyCells.get(new Random().nextInt(emptyCells.size()));
            board[cell[0]][cell[1]] = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private void handleKeyPress(KeyEvent event) {
        boolean moved = false;
        switch (event.getCode()) {
            case UP:
                moved = moveTilesUp();
                break;
            case DOWN:
                moved = moveTilesDown();
                break;
            case LEFT:
                moved = moveTilesLeft();
                break;
            case RIGHT:
                moved = moveTilesRight();
                break;
        }
        if (moved) {
            addRandomTile();
            updateUI();
            if (isGameOver()) {
                System.out.println("Game over!");
            }
        }
    }

    private boolean moveTilesUp() {
        boolean moved = false;
        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 1; row < BOARD_SIZE; row++) {
                if (board[row][col] != 0) {
                    int newRow = row;
                    while (newRow > 0 && board[newRow - 1][col] == 0) {
                        swapTiles(newRow, col, newRow - 1, col);
                        newRow--;
                        moved = true;
                    }
                    if (newRow > 0 && board[newRow - 1][col] == board[newRow][col]) {
                        board[newRow - 1][col] *= 2;
                        score += board[newRow - 1][col];
                        board[newRow][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveTilesDown() {
        boolean moved = false;
        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = BOARD_SIZE - 2; row >= 0; row--) {
                if (board[row][col] != 0) {
                    int newRow = row;
                    while (newRow < BOARD_SIZE - 1 && board[newRow + 1][col] == 0) {
                        swapTiles(newRow, col, newRow + 1, col);
                        newRow++;
                        moved = true;
                    }
                    if (newRow < BOARD_SIZE - 1 && board[newRow + 1][col] == board[newRow][col]) {
                        board[newRow + 1][col] *= 2;
                        score += board[newRow + 1][col];
                        board[newRow][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveTilesLeft() {
        boolean moved = false;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 1; col < BOARD_SIZE; col++) {
                if (board[row][col] != 0) {
                    int newCol = col;
                    while (newCol > 0 && board[row][newCol - 1] == 0) {
                        swapTiles(row, newCol, row, newCol - 1);
                        newCol--;
                        moved = true;
                    }
                    if (newCol > 0 && board[row][newCol - 1] == board[row][newCol]) {
                        board[row][newCol - 1] *= 2;
                        score += board[row][newCol - 1];
                        board[row][newCol] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveTilesRight() {
        boolean moved = false;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = BOARD_SIZE - 2; col >= 0; col--) {
                if (board[row][col] != 0) {
                    int newCol = col;
                    while (newCol < BOARD_SIZE - 1 && board[row][newCol + 1] == 0) {
                        swapTiles(row, newCol, row, newCol + 1);
                        newCol++;
                        moved = true;
                    }
                    if (newCol < BOARD_SIZE - 1 && board[row][newCol + 1] == board[row][newCol]) {
                        board[row][newCol + 1] *= 2;
                        score += board[row][newCol + 1];
                        board[row][newCol] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private void swapTiles(int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }

    private boolean isGameOver() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == 0
                        || (row > 0 && board[row - 1][col] == board[row][col])
                        || (row < BOARD_SIZE - 1 && board[row + 1][col] == board[row][col])
                        || (col > 0 && board[row][col - 1] == board[row][col])
                        || (col < BOARD_SIZE - 1 && board[row][col + 1] == board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}