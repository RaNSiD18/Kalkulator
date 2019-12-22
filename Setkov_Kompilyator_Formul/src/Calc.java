public class Calc extends Compf {
    private StackInt s;
    public static boolean checknumber = false;

    private static int char2int(char c) {
        return (int)c - (int)'0';
    }

    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Что-то: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }

    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
        }


}

    protected void nextOther(char c) {
        s.push(char2int(c));
        if(checknumber == true)
            checknum();
        if(checknumber == false)
            checknumber = true;
    }

    public Calc() {
        s = new StackInt();
    }

    public final void compile(char[] str) {
        checknumber = false;
        super.compile(str);
        System.out.println("" + s.top());
    }


    private void checknum(){
        int num_2 = s.pop();
        int num_1 = s.pop();
        s.push(num_1*10 + num_2);
    }
}
