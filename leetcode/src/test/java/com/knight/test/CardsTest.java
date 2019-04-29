package com.knight.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 有1到13一共13张牌，不知道一开始的顺序。接下来的操作是。从最上面拿一张放在这一摞的最下面，然后把现在最上面的这张牌放在桌上，然后再把最上面的放在这一摞的最下面，然后把现在最上面的放在桌上那一张的上面
 *直到手里没牌了,直到手里没牌了,求原始顺序
 *
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.test
 * @date:2019/4/26
 */
public class CardsTest {
    public static List<Integer> getCardsSort(List<Integer> list){
        List<Integer> temp = new LinkedList<>();
        temp.add(list.get(0));
        list.remove(0);
        while (list.size() > 0){
//            ((LinkedList<Integer>) temp).addFirst(list.get(0));
            ((LinkedList<Integer>) temp).addFirst(list.get(0));
            list.remove(0);
            Integer i = ((LinkedList<Integer>) temp).getLast();
            ((LinkedList<Integer>) temp).removeLast();
            ((LinkedList<Integer>) temp).addFirst(i);

        }
        return temp;
    }
    public static Stack<Integer> getNewCards(LinkedList<Integer> list){
        Stack<Integer> stack = new Stack();
        while (list.size() > 0){
            Integer i = list.getFirst();
            list.removeFirst();
            list.addLast(i);
            stack.push(list.getFirst());
            list.removeFirst();
        }
        return stack;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        System.err.println(getCardsSort(list));

        int[] a = new int[]{7,13,2,12,6,11,3,10,5,9,1,8,4};
        LinkedList<Integer> result = new LinkedList<>();
        for (int i : a) {
            Integer integer = i;
            result.add(integer);
        }
        Stack stack = getNewCards(result);
        while (stack.empty()){
            System.out.println(stack.pop());
        }

    }
}
