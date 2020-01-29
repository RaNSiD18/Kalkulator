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
        int osn1, osn2, pre1, pre2, sum1 = 0, sum2 = 0, second = s.pop();
        int num1 = 0, first = s.pop();
        num1 = num1 + 1;


        System.out.println((first + "").length());
        System.out.println((second + "").length());

        osn2 = (second + "").length();
        osn1 = (first + "").length();

        if(num1 == 1) {
            if (osn1 == 4) {
                pre1 = first / 1000;
                sum1 = sum1 + pre1 * 8 * 8 * 8;
                osn1--;
            }
            if (osn1 == 3) {
                if ((first + "").length() == 4) {
                    pre1 = first / 100 % 10;
                    sum1 = sum1 + pre1 * 8 * 8;
                }
                if ((first + "").length() == 3) {
                    pre1 = first / 100;
                    sum1 = sum1 + pre1 * 8 * 8;
                }

                osn1--;
            }
            if (osn1 == 2) {
                if ((first + "").length() == 4) {
                    pre1 = first % 100 / 10;
                    sum1 = sum1 + pre1 * 8;
                }
                if ((first + "").length() == 3) {
                    pre1 = first / 10 % 10;
                    sum1 = sum1 + pre1 * 8;
                }
                if ((first + "").length() == 2) {
                    pre1 = first / 10;
                    sum1 = sum1 + pre1 * 8;
                }
                osn1--;
            }
            if (osn1 == 1) {
                if ((first + "").length() == 4) {
                    pre1 = first % 10;
                    sum1 = sum1 + pre1;
                }
                if ((first + "").length() == 3) {
                    pre1 = first % 10;
                    sum1 = sum1 + pre1;
                }
                if ((first + "").length() == 2) {
                    pre1 = first % 10;
                    sum1 = sum1 + pre1;
                }
                if ((first + "").length() == 1) {
                    pre1 = first;
                    sum1 = sum1 + pre1;
                }
                osn1--;
            }
            first = sum1;
        }

        if(num1 == 1) {
            if (osn2 == 4) {
                pre2 = second / 1000;
                sum2 = sum2 + pre2 * 8 * 8 * 8;
                osn2--;
            }
            if (osn2 == 3) {
                if ((second + "").length() == 4) {
                    pre2 = second / 100 % 10;
                    sum2 = sum2 + pre2 * 8 * 8;
                }
                if ((second + "").length() == 3) {
                    pre2 = first / 100;
                    sum2 = sum2 + pre2 * 8 * 8;
                }

                osn2--;
            }

                if ((second + "").length() == 4) {
                    pre2 = second % 100 / 10;
                    sum2 = sum2 + pre2 * 8;
                }
                if ((second + "").length() == 3) {
                    pre2 = second / 10 % 10;
                    sum2 = sum2 + pre2 * 8;
                }
                if ((second + "").length() == 2) {
                    pre2 = second / 10;
                    sum2 = sum2 + pre2 * 8;
                }
                osn2--;
            }
            if (osn2 == 1) {
                if ((second + "").length() == 4) {
                    pre2 = second % 10;
                    sum2 = sum2 + pre2;
                }
                if ((second + "").length() == 3) {
                    pre2 = second % 10;
                    sum2 = sum2 + pre2;
                }
                if ((second + "").length() == 2) {
                    pre2 = second % 10;
                    sum2 = sum2 + pre2;
                }
                if ((second + "").length() == 1) {
                    pre2 = second;
                    sum2 = sum2 + pre2;
                }
                osn2--;
            }
            second = sum2;


            switch (c) {
                case '+':
                    s.push(first + second);
                    break;
                case '-':
                    s.push(first - second);
                    break;
                case '*':
                    s.push(first * second);
                    break;
                case '/':
                    s.push(first / second);
                    break;
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
