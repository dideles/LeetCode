package com.java.Task_1861_Rotating_the_Box_MEDIUM;

import java.util.Arrays;

/**
 * Класс, реализующий поворот коробки с камнями и препятствиями на 90 градусов против часовой стрелки.
 */
public class Solution {

    private static final class BoxSymbols {
        public static final char EMPTY_CELL = '.'; // пустая ячейка
        public static final char STONE = '#'; // камень
        public static final char OBSTACLE = '*'; // препятствие
    }

    /**
     * Поворачивает коробку на 90 градусов против часовой стрелки
     * и обновляет положение камней таким образом, чтобы они падали вниз до встречи с препятствием или на дно коробки.
     *
     * @param box Исходная коробка, представленная двумерным массивом символов.
     * @return Повернутая коробка.
     * @throws IllegalArgumentException если коробка пуста или содержит неверные данные.
     */
    public char[][] rotateTheBox(char[][] box) {

        validateBox(box); // Вынесение проверки валидности коробки в свой метод.

        // Инициализация размеров исходной коробки:
        int boxHeight = box.length; // Высота исходной коробки (количество строк в исходной коробке)
        int boxWidth = box[0].length; // Ширина исходной коробки (количество столбцов в исходной коробке)
        // Создание новой коробки для хранения результата поворота
        char[][] rotatedBox = new char[boxWidth][boxHeight]; // при повороте на 90° размеры меняются местами
        // т.е. ширина исходной коробки становится высотой новой, а высота — шириной

        // Новая коробка заполняется пустыми ячейками (.), т.к. изначально она пустая.
        for (char[] row : rotatedBox) {
            Arrays.fill(row, BoxSymbols.EMPTY_CELL);
        }

        /* Вспомогательный массив уровней нужен для того, чтобы отслеживать, на каком уровне в текущей колонке новой
        коробки находится первый свободный слот для размещения камня.

        Когда начинаем обрабатывать камни (#) в исходной коробке,
        нужно знать, куда поместить их в новой коробке после её поворота.

        Камни должны падать вниз до тех пор, пока не достигнут дна коробки или не столкнутся с препятствием (*).

        Чтобы эффективно управлять этим процессом, используется массив minLevels.
         */
        int[] minLevels = new int[boxHeight];
        Arrays.fill(minLevels, boxWidth - 1); // Элементы массива инициализируются значением boxWidth - 1,
                                              // что соответствует самому нижнему уровню в каждом столбце новой коробки.

        // Упаковка логики поворота коробки в отдельный метод,
        // чтобы отделить и организовать логику
        rotateAndDrop(box, rotatedBox, minLevels, boxHeight, boxWidth);

        // Возврат результата:
        return rotatedBox; // После завершения всех циклов возвращается повернутая коробка.
    }

    /**
     * Проверяет валидность коробки, убеждаясь, что она не пуста и все строки имеют одинаковую длину.
     *
     * @param box Двумерный массив символов, представляющий коробку.
     * @throws IllegalArgumentException если коробка пуста или строки имеют разную длину.
     */
    private void validateBox(char[][] box) {
        if (box == null || box.length == 0 || box[0].length == 0) {
            throw new IllegalArgumentException("Коробка должна содержать элементы.");
        }

        for (char[] row : box) {
            if (row.length != box[0].length) {
                throw new IllegalArgumentException("Все строки коробки должны иметь одинаковую длину.");
            }
        }
    }

    /**
     * Выполняет поворот коробки на 90 градусов против часовой стрелки и применяет правила падения камней.
     * @param box Исходная коробка, подлежащая повороту.
     * @param rotatedBox Поворотная коробка, в которую будут перенесены символы.
     * @param minLevels Массив, отслеживающий минимальные уровни для каждой колонки в повернутой коробке.
     * @param boxHeight Высота исходной коробки.
     * @param boxWidth Ширина исходной коробки.
     */
    private void rotateAndDrop(char[][] box, char[][] rotatedBox, int[] minLevels, int boxHeight, int boxWidth) {
        // Проходим по каждому столбцу справа налево (BOX_WIDTH - 1 до 0),
        // потому что при повороте коробки на 90 градусов последний столбец станет первой строкой новой коробки.
        for (int col = boxWidth - 1; col >= 0; col--) { // Цикл по столбцам
            // и по каждой строке от нижней строки к верхней (BOX_HEIGHT - 1 до 0),
            // потому что нижний ряд становится правым столбцом в новой коробке.
            for (int row = boxHeight - 1; row >= 0; row--) { // Цикл по строкам
                char currentCell = box[row][col];

                if (currentCell == BoxSymbols.OBSTACLE || currentCell == BoxSymbols.STONE) {
                    placeSymbol(rotatedBox, col, row, minLevels, currentCell, boxHeight);
                }
            }
        }
    }

    /**
     * Размещает символ в повернутой коробке и обновляет минимальный уровень для следующей операции.
     * @param rotatedBox Повернутая коробка, в которую нужно разместить символ.
     * @param col Номер колонки в повернутой коробке, в которую нужно поместить символ.
     * @param row Номер строки в исходной коробке, откуда берется символ.
     * @param minLevels Массив, отслеживающий минимальные уровни для каждой колонки в повернутой коробке.
     * @param symbol Символ, который нужно разместить ('.' для пустой клетки, '#' для камня, '*' для препятствия).
     * @param boxHeight Высота исходной коробки.
     */
    private void placeSymbol(char[][] rotatedBox, int col, int row, int[] minLevels, char symbol, int boxHeight) {
        int targetRow = minLevels[boxHeight - 1 - row];
        rotatedBox[col][targetRow] = symbol;

        if (symbol == BoxSymbols.OBSTACLE) {
            minLevels[boxHeight - 1 - row] = col - 1;
        } else if (symbol == BoxSymbols.STONE) {
            minLevels[boxHeight - 1 - row]--; // Обновление минимального уровня для следующего камня
        }
    }

    /**
     * Обрабатывает препятствие, размещая его в повернутой коробке и обновляя минимальный уровень для следующей операции.
     * @param rotatedBox Повернутая коробка, в которую нужно разместить препятствие.
     * @param col Номер колонки в повернутой коробке, в которую нужно поместить препятствие.
     * @param row Номер строки в исходной коробке, откуда берется препятствие.
     * @param minLevels Массив, отслеживающий минимальные уровни для каждой колонки в повернутой коробке.
     * @param boxHeight Высота исходной коробки.
     */
    private void processObstacle(char[][] rotatedBox, int col, int row, int[] minLevels, int boxHeight) {
        rotatedBox[col][minLevels[boxHeight - 1 - row]] = BoxSymbols.OBSTACLE;
        minLevels[boxHeight - 1 - row] = col - 1;
    }

    /**
     * Обрабатывает камень, размещая его в повернутой коробке и обновляя минимальный уровень для следующей операции.
     * @param rotatedBox Повернутая коробка, в которую нужно разместить камень.
     * @param col Номер колонки в повернутой коробке, в которую нужно поместить камень.
     * @param row Номер строки в исходной коробке, откуда берется камень.
     * @param minLevels Массив, отслеживающий минимальные уровни для каждой колонки в повернутой коробке.
     * @param boxHeight Высота исходной коробки.
     */
    private void processStone(char[][] rotatedBox, int col, int row, int[] minLevels, int boxHeight) {
        int levelToInsert = minLevels[boxHeight - 1 - row];
        rotatedBox[levelToInsert][boxHeight - 1 - row] = BoxSymbols.STONE;
        minLevels[boxHeight - 1 - row]--; // Обновление минимального уровня для следующего символа
    }
}