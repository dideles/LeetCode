package com.java.Task_2_Add_two_Numbers;

/**
 * Преобразование в целые числа и обратная конвертация.
 * В этом подходе сначала преобразуем списки в обычные целые числа,
 * затем суммируем их и возвращаем результат обратно в виде связанного списка.
 */
class Solution_03 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = toNumber(l1);
        long num2 = toNumber(l2);

        long sum = num1 + num2;

        return fromNumber(sum);
    }

    private long toNumber(ListNode head) {
        long num = 0;
        long multiplier = 1;

        while (head != null) {
            num += head.val * multiplier;
            multiplier *= 10;
            head = head.next;
        }

        return num;
    }

    private ListNode fromNumber(long num) {
        if (num == 0) {
            return new ListNode(0);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        while (num > 0) {
            current.next = new ListNode((int) (num % 10));
            current = current.next;
            num /= 10;
        }

        return dummyHead.next;
    }
}