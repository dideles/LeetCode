package com.java.Task_2_Add_two_Numbers;

/**
 * Рекурсивный подход
 * Этот метод использует рекурсию для обработки каждого узла двух списков и суммирования их значений.
 * Он очень похож на решение выше, но вместо итерации используется рекурсия.
 */
class Solution_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addList(l1, l2, 0);
    }

    private ListNode addList(ListNode node1, ListNode node2, int carry) {
        if (node1 == null && node2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }

        int value1 = (node1 == null) ? 0 : node1.val;
        int value2 = (node2 == null) ? 0 : node2.val;

        ListNode result = new ListNode((value1 + value2 + carry) % 10);
        result.next =

                addList(node1 == null ? null : node1.next,
                        node2 == null ? null : node2.next,
                        (value1 + value2 + carry) / 10);

        return result;
    }
}