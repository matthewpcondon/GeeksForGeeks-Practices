public Node rotate(Node head, int k) {
        /*store head as old head
        iterate k times
        once iterated,
        set head = curr.next, and curr.next = null.
        continue iterating to the end
        once end reached, set curr.next = old head. */
        Node oldHead = head;
        Node curr = head;
        Node prev = null;
        while (k > 0){
            prev = curr;
            if (curr.next == null) {
                // happens when k equals n, for some reason, they didn't
                // let me use n in this method...
                // if k==n, then the list is the same as if it was not rotated.
                return head;
            }
            curr = curr.next;
            k--;
        }
        prev.next = null;
        head = curr;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = oldHead;
        return head;
    }
