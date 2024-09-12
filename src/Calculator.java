import java.util.regex.Pattern;

public class Calculator {
    public void Calculate(final String expression) throws IllegalArgumentException  {
        Operand firstToken = null;
        Operand secondToken = null;
        String findOperation = "";

        for (String operation : m_operations) {
            // Используем Pattern.quote для экранирования символа
            String escapedOperation = Pattern.quote(operation);
            String[] parts = expression.split(escapedOperation);
            if (parts.length == 1)
                continue;

            if (parts.length > 2)
                throw new IllegalArgumentException ("Формат математической операции не удовлетворяет заданию");


            firstToken = new Operand(parts[0].trim());
            secondToken = new Operand(parts[1].trim());

            findOperation = operation;
            break;
        }

        if (findOperation.isEmpty())
            throw new IllegalArgumentException("Не является выражением");


        switch (findOperation) {
            case "+":
                firstToken.Addition(secondToken);
                break;
            case "-":
                firstToken.Subtraction(secondToken);
                break;
            case "*":
                firstToken.Multiplication(secondToken);
                break;
            case "/":
                firstToken.Division(secondToken);
                break;
        }
        firstToken.Print();

    }

    private final String[] m_operations = {"+", "-", "*", "/"};
}
