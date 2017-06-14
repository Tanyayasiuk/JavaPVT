package javapvt.lesson10;

public class Calculator {

    public int firstNum;
    public int secondNum;
    public int operation;

    public void sum(int firstNum, int secondNum){
        System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
    }

    public void subtract (int firstNum, int secondNum){
        System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
    }

    public void mult(int firstNum, int secondNum) throws MyException {
        if (secondNum == 0){
            throw new MyException();
        } else
            System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
    }

    public void division(int firstNum, int secondNum) throws MyException {
        if (secondNum ==  0)
            throw new MyException();
        else
            System.out.println(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
    }
}
