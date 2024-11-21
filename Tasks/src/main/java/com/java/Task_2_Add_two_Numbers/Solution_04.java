package com.java.Task_2_Add_two_Numbers;

import java.util.Stack;

/**
 * Использование стеков
 * Это альтернативный способ решения задачи, который предполагает использование стеков для хранения цифр чисел.
 * Можем последовательно извлекать элементы из обоих списков, складывать их и формировать результирующий список.
 */
class Solution_04 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(0);
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();

            int sum = x + y + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }

        if (carry > 0) {
            ListNode lastCarry = new ListNode(carry);
            lastCarry.next = dummyHead.next;
            dummyHead.next = lastCarry;
        }

        return dummyHead.next;
    }
}