import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String chislo = sc.nextLine();
            System.out.println(calc(chislo));
        }
    }
    public static String calc(String input) {
        String[] chislo = input.split(" ");
        if (chislo.length<3) {
            try{ throw new IOException();
        } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(0);
            }}
        if (chislo.length>3) {
            try{ throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }}
        String nomer2 = chislo[2];
        String znak = chislo[1];
        String nomer1 = chislo[0];
        int x3 = 0;

        if ((nomer1.equals("I")||nomer1.equals("II")||nomer1.equals("III")||
                nomer1.equals("IV")||nomer1.equals("V")||nomer1.equals("VI")||
                nomer1.equals("VII")||nomer1.equals("VIII")||nomer1.equals("IX")||nomer1.equals("X"))&&
                (nomer2.equals("I")||nomer2.equals("II")||nomer2.equals("III")||
                        nomer2.equals("IV")||nomer2.equals("V")||nomer2.equals("VI")||
                        nomer2.equals("VII")||nomer2.equals("VIII")||nomer2.equals("IX")||nomer2.equals("X"))) {
            Chisla chisla1 = Chisla.valueOf(Chisla.class, nomer1);
            Chisla chisla2 = Chisla.valueOf(Chisla.class, nomer2);
            int ch1 = chisla1.getTranslation();
            int ch2 = chisla2.getTranslation();
            switch(znak){
                case "+":
                    x3=(ch1+ch2);
                    break;
                case "-":
                    x3=(ch1-ch2);
                    if (x3<1) {
                        try{ throw new IOException();
                    } catch (IOException e) {
                        System.out.println("throws Exception //т.к. в римской системе только положительные числа");
                        System.exit(0);
                    }}
                    break;
                case "*":
                    x3=(ch1*ch2);
                    break;
                case "/":
                    x3=(ch1/ch2);
                    break;
            }
            String rim;
            if (x3==100) {
                rim="C";
            } else if ((x3>=90)&&(x3<100)) {
                rim="XC";
            } else if ((x3>=80)&&(x3<90)) {
                rim="LXXX";
            } else if ((x3>=70)&&(x3<80)) {
                rim="LXX";
            } else if ((x3>=60)&&(x3<70)) {
                rim="LX";
            } else if ((x3>=50)&&(x3<60)) {
                rim="L";
            } else if ((x3>=40)&&(x3<50)) {
                rim="XL";
            } else if ((x3>=30)&&(x3<40)) {
                rim="XXX";
            } else if ((x3>=20)&&(x3<30)) {
                rim="XX";
            } else if ((x3>=10)&&(x3<20)) {
                rim = "X";
            } else rim = "";
            if (x3%10==1) {
                rim=rim+"I";
            } else if (x3%10==2) {
                rim=rim+"II";
            } else if (x3%10==3) {
                rim=rim+"III";
            } else if (x3%10==4) {
                rim=rim+"IV";
            } else if (x3%10==5) {
                rim=rim+"V";
            } else if (x3%10==6) {
                rim=rim+"VI";
            } else if (x3%10==7) {
                rim=rim+"VII";
            } else if (x3%10==8) {
                rim=rim+"VIII";
            } else if (x3%10==9) {
                rim=rim+"IX";
            }
            String str = rim;
            return str;
        } else if ((nomer1.equals("1")||nomer1.equals("2")||nomer1.equals("3")||
                nomer1.equals("4")||nomer1.equals("5")||nomer1.equals("6")||
                nomer1.equals("7")||nomer1.equals("8")||nomer1.equals("9")||nomer1.equals("10"))&&
                (nomer2.equals("1")||nomer2.equals("2")||nomer2.equals("3")||
                        nomer2.equals("4")||nomer2.equals("5")||nomer2.equals("6")||
                        nomer2.equals("7")||nomer2.equals("8")||nomer2.equals("9")||nomer2.equals("10"))) {
            int ch1 = Integer.parseInt(nomer1);
            int ch2 = Integer.parseInt(nomer2);
            switch(znak){
                case "+":
                    x3=(ch1+ch2);
                    break;
                case "-":
                    x3=(ch1-ch2);
                    break;
                case "*":
                    x3=(ch1*ch2);
                    break;
                case "/":
                    x3=(ch1/ch2);
                    break;
            }
        } else     try{ throw new IOException();
        } catch (IOException e) {
            System.out.println("throws Exception //т.к. калькулятор не работает с такими данными");
            System.exit(0);
        }
        String str = Integer. toString(x3);
        return str;
    }
}

enum Chisla {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    private int translation;
    Chisla(int translation) {
        this.translation = translation;
    }
    int getTranslation(){
        return translation;
    }
}
