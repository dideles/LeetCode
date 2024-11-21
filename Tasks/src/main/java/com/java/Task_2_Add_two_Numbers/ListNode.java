package com.java.Task_2_Add_two_Numbers;

/**
 * Класс ListNode описывает структуру односвязного списка.
 * Каждый узел списка имеет два поля:
 * val: целое число, которое хранит значение узла.
 * next: ссылка на следующий узел в списке.
 */
public class ListNode {
    int val;
    ListNode next;

    // Конструкторы позволяют создавать новые узлы различными способами:

    // Без параметров: создаёт пустой узел.
    ListNode() {
    }

    // С одним параметром val: создаёт узел с заданным значением.
    ListNode(int x) {
        this.val = x;
    }

    // С двумя параметрами val и next: создаёт узел с заданными значениями и ссылкой на следующий узел.
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}