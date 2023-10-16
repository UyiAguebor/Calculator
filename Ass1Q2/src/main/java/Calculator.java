import java.util.Set;

public class Calculator {
    private char operator;
    private int operand1;
    private int operand2;
    private String expression;

    public Calculator() {
    }

    public char getOperator() {
        return operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public String getExpression(){
    return expression;
    }


    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean verify() {
        //valid operator++
        //space either side of the operator++
        //both operands are valid ++
        //there is no division by zero++

        //splits the expression
        String[] parts = getExpression().split(" ");

        //if parts doesn't = 3 then false (space check)
        if (3 != parts.length) {
            return false;
        }
        //assigns the split expression into parts
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

         //loop while i less than expression length check if every character is a digit(Operand check)
        int i = 0;
        while(i < part1.length()) {
            if ((!Character.isDigit(part1.charAt(i)))) {
                return false;
            }
            i++;
       }
        int x = 0;
        while(x < part3.length()) {
            if ((!Character.isDigit(part3.charAt(x)))) {
                return false;
            }
            x++;
        }

        //assigns the parts to their respected data fields
        this.operand1 = Integer.parseInt(part1);
        this.operator = part2.charAt(0);
        this.operand2 = Integer.parseInt(part3);

        // if the operator is not one of these then return false
        if (('*' != operator) & ('/' != operator) & ('+' != operator) & ('-' != operator)) {
            return false;
        }
        //if operand 2 is 0 and the operator is divide then return false
        if ((operand2 == 0) & (operator == '/')) {
            return false;
        }
        return true;
    }

     public int evaluate() {
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                System.out.println(operand1 + "+" + operand2 + "=" + result);
                break;
            case '-' :
                result = operand1 - operand2;
                System.out.println(operand1 + "-" + operand2 + "=" + result);
                break;
            case '*' :
                result = operand1 * operand2;
                System.out.println(operand1 + "*" + operand2 + "=" + result);
                break;
            case '/':
                result = operand1 / operand2;
                System.out.println(operand1 + "/" + operand2 + "=" + result);
                break;
        }
                return result;
    }

}


