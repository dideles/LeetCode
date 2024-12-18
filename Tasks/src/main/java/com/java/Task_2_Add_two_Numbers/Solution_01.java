package com.java.Task_2_Add_two_Numbers;

/**
 * Простое пошаговое сложение
 * Идея этого подхода состоит в том, что мы проходим оба списка одновременно,
 * складываем соответствующие узлы и учитываем перенос.
 * Если один список короче другого, просто продолжаем добавлять нули к узлам короткого списка до тех пор,
 * пока он не станет равен длинному.
 */
class Solution_01 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Указатели для прохода по спискам
        ListNode p1 = l1;
        ListNode p2 = l2;

        // Вспомогательный узел для хранения результата:
        ListNode dummyHead = new ListNode(0); // Cоздаем временный узел dummyHead, который служит началом результирующего списка
        ListNode current = dummyHead; // Указатель current используется для добавления новых узлов к этому списку.

        // Инициализация переноса при сложении для учета переполнения:
        int carry = 0; // Переменная carry хранит значение переноса при сложении цифр.

        // Цикл продолжается до тех пор, пока хотя бы одна из исходных цепочек не закончится:
        while (p1 != null || p2 != null) {
            // Мы берем значения текущих узлов двух списков.
            // Если текущий узел отсутствует, его значение считается равным нулю.
            int x = (p1 != null) ? l1.val : 0;
            int y = (p2 != null) ? l2.val : 0;

            // Суммируем эти значения вместе с переносом от предыдущего шага.
            int sum = carry + x + y;

            // Обновляем перенос
            // В результирующий список добавляем остаток от деления суммы на 10 (это текущая цифра).
            carry = sum / 10;

            // Добавляем новую цифру в результатирующий список
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Переходим к следующим узлам обоих списков.
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null) l2 = l2.next;
        }

        // После завершения основного цикла проверяем, остался ли перенос.
        // Добавляем последний перенос, если он остался
        if (carry > 0) { //
            current.next = new ListNode(carry);
        }

        // Возвращаем ссылку на начало результата
        return dummyHead.next;
        /*
        Возвращаем ссылку на следующий после dummyHead элемент,
        т.к. сам dummyHead был создан временно и не является частью итогового результата
         */
    }
}
