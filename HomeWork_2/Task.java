package HomeWork_2;

//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор)

public class Task {
    Node head;

    public void reverse() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }

    /**
     * @apiNote процедура разворота связного списка при помощи рекурсии
     * @param currentNode  текущая нода
     * @param previousNode предыдущая нода
     */

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    public class Node {
        int value;
        Node next;
    }

}
