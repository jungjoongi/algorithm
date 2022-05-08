package com.jungjoongi.algorithm.note.string;


import java.util.*;

public class 우선순위연산 {

    public static void main(String[] args) {
        System.out.println(
                solution("2*2*2*2*2-2*2*2")
        );
    }

    public static long solution(String expression) {


        StringBuffer sb = new StringBuffer();
        List<Long> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s : expression.split("")) {
            if("+".equals(s) || "*".equals(s) || "-".equals(s)) {
                nums.add(Long.parseLong(sb.toString()));
                ops.add(s);
                sb.delete(0, sb.length());
                set.add(s);
            } else {
                sb.append(s);
            }
        }

        nums.add(Long.parseLong(sb.toString()));

        long max = 0;
        for(int i = 0; i < 6; i++) {
            Deque<Long> numsQ = new LinkedList<>();
            Queue<String> opQ = new LinkedList<>();
            for(long obj : nums) {
                numsQ.offer(obj);
            }
            for(String obj : ops) {
                opQ.offer(obj);
            }
            max = Math.max(max, Math.abs(rec(numsQ, opQ, i+1, 1, set.size()+1)));

        }

        return max;
    }

    public static long rec(Deque<Long> queue, Queue<String> opQ,  int priority, int deps, int limit) {

        if(deps == limit) {
            return queue.poll();
        }

        Deque<Long> copyQueue = new LinkedList<>();
        Queue<String> copyOpQ = new LinkedList<>();

        while (!queue.isEmpty()) {
            String op = opQ.poll();
            if(op != null) {
                if(op.equals(operation(priority, deps, op))) {
                    long result = 0;
                    if ("*".equals(op)) {
                        if(queue.size() > 1) {
                            result = queue.poll() * queue.poll();
                        } else {
                            result = copyQueue.pollLast() *  queue.poll();
                        }

                    } else if ("+".equals(op)) {
                        if(queue.size() > 1) {
                            result = queue.poll() + queue.poll();
                        } else {
                            result = copyQueue.pollLast() + queue.poll();
                        }
                    } else {
                        if(queue.size() > 1) {
                            result = queue.poll() - queue.poll();
                        } else {
                            result = copyQueue.pollLast() -  queue.poll();
                        }
                    }
                    queue.offerFirst(result);
                } else {
                    copyQueue.offer(queue.poll());
                    copyOpQ.offer(op);
                }
            } else {
                copyQueue.offer(queue.poll());
            }
        }

        return rec(copyQueue, copyOpQ, priority, deps+1, limit);


    }

    public static String operation(int priority, int deps, String op) {

        String operation = "";

        if(priority == 1) {
            if(deps == 1) {
                operation = "+";
            } else if(deps == 2) {
                operation = "-";
            } else if(deps == 3) {
                operation = "*";
            }
        } else if (priority == 2) {
            if(deps == 1) {
                operation = "+";
            } else if(deps == 2) {
                operation = "*";
            } else if(deps == 3) {
                operation = "-";
            }
        } else if (priority == 3) {
            if(deps == 1) {
                operation = "-";
            } else if(deps == 2) {
                operation = "+";
            } else if(deps == 3) {
                operation = "*";
            }
        } else if (priority == 4) {
            if(deps == 1) {
                operation = "-";
            } else if(deps == 2) {
                operation = "*";
            } else if(deps == 3) {
                operation = "+";
            }
        } else if (priority == 5) {
            if(deps == 1) {
                operation = "*";
            } else if(deps == 2) {
                operation = "-";
            } else if(deps == 3) {
                operation = "+";
            }
        } else if (priority == 6) {
            if(deps == 1) {
                operation = "*";
            } else if(deps == 2) {
                operation = "+";
            } else if(deps == 3) {
                operation = "-";
            }
        }
        return op.equals(operation) ? op : "N";
    }
}


