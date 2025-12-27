public class main {

    public static Queue<Integer> ex1(Queue<Character> q) { // O(n)
        Queue<Character> t = new Queue<>();
        Queue<Integer> r = new Queue<>();

        if (q.isEmpty()) return r;

        char p = q.remove();
        t.insert(p);
        int c = 1;

        while (!q.isEmpty()) {
            char x = q.remove();
            t.insert(x);
            if (x == p) c++;
            else {
                r.insert(c);
                p = x;
                c = 1;
            }
        }
        r.insert(c);

        while (!t.isEmpty()) q.insert(t.remove());
        return r;
    }

    private static boolean isIn(Queue<String> q, String s) { // O(n)
        Queue<String> t = new Queue<>();
        boolean f = false;

        while (!q.isEmpty()) {
            String x = q.remove();
            if (x.equals(s)) f = true;
            t.insert(x);
        }
        while (!t.isEmpty()) q.insert(t.remove());

        return f;
    }

    public static boolean ex2(Queue<String> q) { // O(n^2)
        Queue<String> t = new Queue<>();

        while (!q.isEmpty()) {
            String x = q.remove();
            if (isIn(t, x)) {
                t.insert(x);
                while (!q.isEmpty()) t.insert(q.remove());
                while (!t.isEmpty()) q.insert(t.remove());
                return true;
            }
            t.insert(x);
        }

        while (!t.isEmpty()) q.insert(t.remove());
        return false;
    }

    private static boolean isInInt(Queue<Integer> q, int x) { // O(n)
        Queue<Integer> t = new Queue<>();
        boolean f = false;

        while (!q.isEmpty()) {
            int v = q.remove();
            if (v == x) f = true;
            t.insert(v);
        }
        while (!t.isEmpty()) q.insert(t.remove());

        return f;
    }

    public static Queue<Integer> ex3(Queue<Integer> q) { // O(n^2)
        Queue<Integer> t = new Queue<>();
        Queue<Integer> r = new Queue<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            if (!isInInt(r, x)) r.insert(x);
            t.insert(x);
        }
        while (!t.isEmpty()) q.insert(t.remove());

        return r;
    }

    public static Queue<Integer> ex4(Queue<Integer> q) { // O(n^2)
        Queue<Integer> w = new Queue<>();
        Queue<Integer> a = new Queue<>();
        Queue<Integer> b = new Queue<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            w.insert(x);
            q.insert(x);
        }

        while (!w.isEmpty()) {
            int m = w.remove();
            a.insert(m);

            while (!w.isEmpty()) {
                int x = w.remove();
                if (x < m) m = x;
                a.insert(x);
            }

            boolean d = false;
            while (!a.isEmpty()) {
                int x = a.remove();
                if (!d && x == m) d = true;
                else w.insert(x);
            }

            b.insert(m);
        }

        return b;
    }

    public static void main(String[] args) {
        Queue<Character> qc = new Queue<>();
        qc.insert('c');
        qc.insert('c');
        qc.insert('a');
        qc.insert('c');
        System.out.println(ex1(qc));

        Queue<String> qs = new Queue<>();
        qs.insert("a");
        qs.insert("b");
        qs.insert("a");
        System.out.println(ex2(qs));

        Queue<Integer> qi = new Queue<>();
        qi.insert(5);
        qi.insert(2);
        qi.insert(5);
        qi.insert(3);
        qi.insert(2);
        System.out.println(ex3(qi));

        Queue<Integer> qx = new Queue<>();
        qx.insert(4);
        qx.insert(1);
        qx.insert(3);
        qx.insert(1);
        qx.insert(2);
        System.out.println(ex4(qx));
    }
}
