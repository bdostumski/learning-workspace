/*
        HDNL Toy
        Steve found a new toy to play with. It's called HDNL (High Definition Native Language).
        He doesn't know what it is used for, he just finds it interesting.
        HDNL works by defining homeomorphic endofunctors mapping submanifolds of a Hilbert space.
        Sadly, when Steve is looking at HDNL, he isn't always able to imagine how all it would look in the end.
        Each line of HDNL is consisted of a letter and a number and opens a tag (like HTML tag).
        The letter is important, though Steve can't remember why. The number defines the level of nesting.
        Steve wants to see how he can nest all the tags such that the level of nesting of inner tags is bigger than that
        of outer tags. Your task is to write a program for Steve which shows nicely indented and closed HDNL tags.

        Input
        On the first line of input, a number N is read - the number of HDNL lines to follow
        Each of the next N lines will be a Latin letter glued to positive number
        Output
        There should be N * 2 lines
        Each output line should contain either an opening or a closing tag
        Use 1 space for indentation
        Constraints
        1 <= N <= 100 000
        1 <= level of nesting <= 1000
        Sample tests
        Input
        4
        h1
        r5
        d2
        a0
        Output
        <h1>
         <r5>
         </r5>
         <d2>
         </d2>
        </h1>
        <a0>
        </a0>
        Input
        9
        a1
        b2
        c3
        d3
        e2
        f3
        g2
        h1
        i2
        Output
        <a1>
         <b2>
          <c3>
          </c3>
          <d3>
          </d3>
         </b2>
         <e2>
          <f3>
          </f3>
         </e2>
         <g2>
         </g2>
        </a1>
        <h1>
         <i2>
         </i2>
        </h1>
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;

public class HDNL {

//    const stack = new Stack();
//    const queue = new Queue();
//
//    const Node = function(x) {
//        this.val = x;
//        this.prev = null;
//        this.next = null;
//    };
//
//        const LinkedList = (function() {
//        // static personal id
//        let pid = 0;
//
//          const LinkedList = function() {
//            this.head = null;
//            this.tail = null;
//            this.size = 0;
//            this.pid = ++pid;
//        };
//
//        LinkedList.prototype.getPID = function() {
//            return this.pid;
//        };
//
//        LinkedList.prototype.getListHead = function() {
//            return this.head;
//        };
//
//        LinkedList.prototype.getListTail = function() {
//            return this.tail;
//        };
//
//        LinkedList.prototype.isEmpty = function() {
//            return (this.head === null && this.tail === null);
//        };
//
//        LinkedList.prototype.insertAfter = function(lookup, value) {
//            const newNode = new Node(value);
//            if (this.isEmpty()) {
//                first = newNode;
//                last = newNode;
//                this.size++;
//            } else {
//                let node = this.head;
//                while (node) {
//                    if (node.val === lookup) {
//                        newNode.next = node.next;
//                        newNode.prev = node;
//
//                        if (node !== this.tail) {
//                            node.next.prev = newNode;
//                        } else {
//                            this.tail = newNode;
//                        }
//
//                        node.next = newNode;
//
//                        this.size++;
//                        return true;
//                    }
//                    node = node.next;
//                }
//                return false;
//            }
//
//            return newNode;
//        };
//
//        LinkedList.prototype.insertBefore = function(lookup, value) {
//            const newNode = new Node(value);
//
//            if (this.isEmpty()) {
//                this.head = newNode;
//                this.tail = newNode;
//                this.size++;
//            } else {
//                let node = this.head;
//                while (node) {
//                    if (node.val === lookup) {
//                        newNode.next = node;
//                        newNode.prev = node.prev;
//
//                        if (node !== this.head) {
//                            node.prev.next = newNode;
//                        } else {
//                            this.head = newNode;
//                        }
//
//                        node.prev = newNode;
//
//                        this.size++;
//
//                        return true;
//                    }
//                    node = node.next;
//                }
//                return false;
//            }
//        };
//
//        LinkedList.prototype.pushFront = function(value) {
//            const node = new Node(value);
//            if (this.head === null) {
//                this.head = node;
//                this.tail = node;
//            } else {
//                node.next = this.head;
//                this.head.prev = node;
//                this.head = node;
//            }
//            this.size++;
//            return true;
//        };
//
//        LinkedList.prototype.pushBack = function(value) {
//            const node = new Node(value);
//            if (this.tail === null) {
//                this.head = node;
//                this.tail = node;
//            } else {
//                this.tail.next = node;
//                node.prev = this.tail;
//                this.tail = node;
//            }
//            this.size++;
//            return true;
//        };
//
//        LinkedList.prototype.remove = function(value, propagate = false) {
//            if (this.head === null) {
//                return false;
//            }
//            node = this.head;
//            let madeRemoval = false;
//            while (node) {
//                if (node.val === value) {
//                    if (this.head === node) {
//                        this.head = node.next;
//                        if (this.head) {
//                            this.prev = null;
//                        }
//                    } else if (this.tail === node) {
//                        this.tail = node.prev;
//                        if (this.tail) {
//                            this.tail.next = null;
//                        }
//                    } else {
//                        node.prev.next = node.next;
//                        node.next.prev = node.prev;
//                    }
//                    this.size--;
//                    madeRemoval = true;
//                    if (!propagate) {
//                        return true;
//                    }
//                }
//                node = node.next;
//            }
//            return madeRemoval;
//        };
//
//        LinkedList.prototype.popFront = function() {
//            const node = this.head;
//            if (!node) {
//                return null;
//            }
//            if (this.head === this.tail) {
//                this.head = null;
//                this.tail = null;
//                return node.val;
//            }
//
//            if (node !== this.head) {
//                node.prev.next = node.next;
//            } else {
//                this.head = node.next;
//            }
//
//            if (node !== this.head) {
//                node.next.prev = node.prev;
//            } else {
//                this.tail = node.prev;
//            }
//
//            return node.val;
//        };
//
//        LinkedList.prototype.popBack = function() {
//            const node = this.tail;
//            if (!node) {
//                return null;
//            }
//            if (this.head === this.tail) {
//                this.head = null;
//                this.tail = null;
//                return node.val;
//            }
//
//            this.tail = node.prev;
//            this.tail.next = null;
//
//            return node.val;
//        };
//
//        LinkedList.prototype.flatten = function() {
//            const flat = [];
//            if (this.head) {
//                let node = this.head;
//                while (node) {
//                    flat.push(node.val);
//                    node = node.next;
//                }
//            }
//            return flat;
//        };
//
//        return LinkedList;
//    }());
//
//        const Stack = (function() {
//        let pid = 0;
//
//        function Stack() {
//            this.head = null;
//            this.tail = null;
//            this.size = 0;
//            this.pid = ++pid;
//        }
//
//        Stack.prototype.getPID = LinkedList.prototype.getPID;
//
//        Stack.prototype.isEmpty = LinkedList.prototype.isEmpty;
//
//        Stack.prototype.peek = function() {
//            if (this.tail) {
//                return this.tail.val;
//            }
//
//            return null;
//        };
//
//        Stack.prototype.push = LinkedList.prototype.pushBack;
//
//        Stack.prototype.pop = LinkedList.prototype.popBack;
//
//        Stack.prototype.flatten = LinkedList.prototype.flatten;
//
//        return Stack;
//    }());
//
//        const Queue = (function() {
//        let pid = 0;
//
//        function Queue() {
//            this.head = null;
//            this.tail = null;
//            this.size = 0;
//            this.pid = ++pid;
//        }
//
//        Queue.prototype.getPID = LinkedList.prototype.getPID;
//
//        Queue.prototype.isEmpty = LinkedList.prototype.isEmpty;
//
//        Queue.prototype.peek = function() {
//            if (this.head) {
//                return this.head.val;
//            }
//            return null;
//        };
//
//        Queue.prototype.enqueue = LinkedList.prototype.pushBack;
//
//        Queue.prototype.dequeue = LinkedList.prototype.popFront;
//
//        Queue.prototype.flatten = LinkedList.prototype.flatten;
//
//        return Queue;
//    }());
//    Java Solution
//        import java.io.ByteArrayInputStream;
//        import java.util.Scanner;
//        import java.util.Stack;

    //    public class Hdnl {
    public static void main(String[] args) {

        fakeInput();

        Scanner scanner = new Scanner(System.in);
        int tagsCount = Integer.parseInt(scanner.nextLine());

        Stack<Character> openedTagsSymbols = new Stack<>();
        Stack<Integer> openedTagsRanks = new Stack<>();
        StringBuilder indentation = new StringBuilder();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < tagsCount; i++) {
            String nextTag = scanner.nextLine();
            char nextTagSymbol = nextTag.charAt(0);
            int nextTagRank = Integer.parseInt(nextTag.substring(1));

            while (!openedTagsRanks.isEmpty() && openedTagsRanks.peek() >= nextTagRank) {
                closeTag(openedTagsSymbols, openedTagsRanks, indentation, output);
            }

            openTag(indentation, output, nextTagSymbol, nextTagRank);

            openedTagsSymbols.push(nextTagSymbol);
            openedTagsRanks.push(nextTagRank);
            indentation.append(" ");
        }

        while (!openedTagsRanks.isEmpty()) {
            closeTag(openedTagsSymbols, openedTagsRanks, indentation, output);
        }

        System.out.println(output);
    }

    private static void openTag(
            StringBuilder indentation,
            StringBuilder output,
            char nextTagSymbol,
            int nextTagRank) {
        output.append(String.format(
                "%s<%c%d>%n",
                indentation,
                nextTagSymbol,
                nextTagRank));
    }

    private static void closeTag(
            Stack<Character> openedTagsSymbols,
            Stack<Integer> openedTagsRanks,
            StringBuilder indentation,
            StringBuilder output) {
        indentation.deleteCharAt(0);
        output.append(String.format(
                "%s</%c%d>%n",
                indentation,
                openedTagsSymbols.pop(),
                openedTagsRanks.pop()));
    }

    public static void fakeInput() {
        String test = "4\n" +
                "h1\n" +
                "r5\n" +
                "d2\n" +
                "a0";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}


//}

/*
        const stack = new Stack();
        const queue = new Queue();

        -----

        const Node = function(x) {
          this.val = x;
          this.prev = null;
          this.next = null;
        };

        const LinkedList = (function() {
          // static personal id
          let pid = 0;

          const LinkedList = function() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.pid = ++pid;
          };

          LinkedList.prototype.getPID = function() {
            return this.pid;
          };

          LinkedList.prototype.getListHead = function() {
            return this.head;
          };

          LinkedList.prototype.getListTail = function() {
            return this.tail;
          };

          LinkedList.prototype.isEmpty = function() {
            return (this.head === null && this.tail === null);
          };

          LinkedList.prototype.insertAfter = function(lookup, value) {
            const newNode = new Node(value);
            if (this.isEmpty()) {
              first = newNode;
              last = newNode;
              this.size++;
            } else {
              let node = this.head;
              while (node) {
                if (node.val === lookup) {
                  newNode.next = node.next;
                  newNode.prev = node;

                  if (node !== this.tail) {
                    node.next.prev = newNode;
                  } else {
                    this.tail = newNode;
                  }

                  node.next = newNode;

                  this.size++;
                  return true;
                }
                node = node.next;
              }
              return false;
            }

            return newNode;
          };

          LinkedList.prototype.insertBefore = function(lookup, value) {
            const newNode = new Node(value);

            if (this.isEmpty()) {
              this.head = newNode;
              this.tail = newNode;
              this.size++;
            } else {
              let node = this.head;
              while (node) {
                if (node.val === lookup) {
                  newNode.next = node;
                  newNode.prev = node.prev;

                  if (node !== this.head) {
                    node.prev.next = newNode;
                  } else {
                    this.head = newNode;
                  }

                  node.prev = newNode;

                  this.size++;

                  return true;
                }
                node = node.next;
              }
              return false;
            }
          };

          LinkedList.prototype.pushFront = function(value) {
            const node = new Node(value);
            if (this.head === null) {
              this.head = node;
              this.tail = node;
            } else {
              node.next = this.head;
              this.head.prev = node;
              this.head = node;
            }
            this.size++;
            return true;
          };

          LinkedList.prototype.pushBack = function(value) {
            const node = new Node(value);
            if (this.tail === null) {
              this.head = node;
              this.tail = node;
            } else {
              this.tail.next = node;
              node.prev = this.tail;
              this.tail = node;
            }
            this.size++;
            return true;
          };

          LinkedList.prototype.remove = function(value, propagate = false) {
            if (this.head === null) {
              return false;
            }
            node = this.head;
            let madeRemoval = false;
            while (node) {
              if (node.val === value) {
                if (this.head === node) {
                  this.head = node.next;
                  if (this.head) {
                    this.prev = null;
                  }
                } else if (this.tail === node) {
                  this.tail = node.prev;
                  if (this.tail) {
                    this.tail.next = null;
                  }
                } else {
                  node.prev.next = node.next;
                  node.next.prev = node.prev;
                }
                this.size--;
                madeRemoval = true;
                if (!propagate) {
                  return true;
                }
              }
              node = node.next;
            }
            return madeRemoval;
          };

          LinkedList.prototype.popFront = function() {
            const node = this.head;
            if (!node) {
              return null;
            }
            if (this.head === this.tail) {
              this.head = null;
              this.tail = null;
              return node.val;
            }

            if (node !== this.head) {
              node.prev.next = node.next;
            } else {
              this.head = node.next;
            }

            if (node !== this.head) {
              node.next.prev = node.prev;
            } else {
              this.tail = node.prev;
            }

            return node.val;
          };

          LinkedList.prototype.popBack = function() {
            const node = this.tail;
            if (!node) {
              return null;
            }
            if (this.head === this.tail) {
              this.head = null;
              this.tail = null;
              return node.val;
            }

            this.tail = node.prev;
            this.tail.next = null;

            return node.val;
          };

          LinkedList.prototype.flatten = function() {
            const flat = [];
            if (this.head) {
              let node = this.head;
              while (node) {
                flat.push(node.val);
                node = node.next;
              }
            }
            return flat;
          };

          return LinkedList;
        }());

        const Stack = (function() {
          let pid = 0;

          function Stack() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.pid = ++pid;
          }

          Stack.prototype.getPID = LinkedList.prototype.getPID;

          Stack.prototype.isEmpty = LinkedList.prototype.isEmpty;

          Stack.prototype.peek = function() {
            if (this.tail) {
              return this.tail.val;
            }

            return null;
          };

          Stack.prototype.push = LinkedList.prototype.pushBack;

          Stack.prototype.pop = LinkedList.prototype.popBack;

          Stack.prototype.flatten = LinkedList.prototype.flatten;

          return Stack;
        }());

        const Queue = (function() {
          let pid = 0;

          function Queue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.pid = ++pid;
          }

          Queue.prototype.getPID = LinkedList.prototype.getPID;

          Queue.prototype.isEmpty = LinkedList.prototype.isEmpty;

          Queue.prototype.peek = function() {
            if (this.head) {
              return this.head.val;
            }
            return null;
          };

          Queue.prototype.enqueue = LinkedList.prototype.pushBack;

          Queue.prototype.dequeue = LinkedList.prototype.popFront;

          Queue.prototype.flatten = LinkedList.prototype.flatten;

          return Queue;
        }());
        Java Solution
        import java.io.ByteArrayInputStream;
        import java.util.Scanner;
        import java.util.Stack;

        public class Hdnl {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int tagsCount = Integer.parseInt(scanner.nextLine());

                Stack<Character> openedTagsSymbols = new Stack<>();
                Stack<Integer> openedTagsRanks = new Stack<>();
                StringBuilder indentation = new StringBuilder();
                StringBuilder output = new StringBuilder();

                for (int i = 0; i < tagsCount; i++) {
                    String nextTag = scanner.nextLine();
                    char nextTagSymbol = nextTag.charAt(0);
                    int nextTagRank = Integer.parseInt(nextTag.substring(1));

                    while (!openedTagsRanks.isEmpty() && openedTagsRanks.peek() >= nextTagRank) {
                        closeTag(openedTagsSymbols, openedTagsRanks, indentation, output);
                    }

                    openTag(indentation, output, nextTagSymbol, nextTagRank);

                    openedTagsSymbols.push(nextTagSymbol);
                    openedTagsRanks.push(nextTagRank);
                    indentation.append(" ");
                }

                while (!openedTagsRanks.isEmpty()) {
                    closeTag(openedTagsSymbols, openedTagsRanks, indentation, output);
                }

                System.out.println(output);
            }

            private static void openTag(
                    StringBuilder indentation,
                    StringBuilder output,
                    char nextTagSymbol,
                    int nextTagRank) {
                output.append(String.format(
                        "%s<%c%d>%n",
                        indentation,
                        nextTagSymbol,
                        nextTagRank));
            }

            private static void closeTag(
                    Stack<Character> openedTagsSymbols,
                    Stack<Integer> openedTagsRanks,
                    StringBuilder indentation,
                    StringBuilder output) {
                indentation.deleteCharAt(0);
                output.append(String.format(
                        "%s</%c%d>%n",
                        indentation,
                        openedTagsSymbols.pop(),
                        openedTagsRanks.pop()));
            }
        }
 */
