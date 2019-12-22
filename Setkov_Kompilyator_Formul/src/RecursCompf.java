public class RecursCompf {
    private static final int DEFSIZE = 255;
    private char[] str;
    private int index;

    private void compileF() {

        while (index < str.length) {
            if (str[index] == '+') {
                index++;
                compileT();
                System.out.print("+ ");
                return;
            }  else break;
        }

        while (index < str.length) {
            if (str[index] == '-') {
                index++;
                compileT();
                System.out.print("- ");
            }else break;
        }
    }


    private void compileT() {

        while (index < str.length) {

            if (str[index] == '*') {
                index++;
                compileM();
                System.out.print("* ");
                return;
            }else break;
        }
        while (index < str.length) {
            if (str[index] == '/') {
                index++;
                compileM();
                System.out.print("/ ");
            }else break;
        }
        }



    private void compileM() {
        if (str[index] == '(') {
            index++;
            compileF();
            index++;
        } else
            compileV();
    }

    private void compileV() {
        System.out.print("" + str[index++] + " ");
    }

    public void RecursCompf() {
        str = new char[DEFSIZE];
    }

    public void compile(char[] str) {
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}
