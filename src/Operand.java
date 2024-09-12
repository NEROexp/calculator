public class Operand
{
    Operand(final String str) throws IllegalArgumentException
    {
        initialize(str);
    }

    private void initialize(final String str) throws IllegalArgumentException
    {
        m_value = Convertor.RomanToInt(str);
        if(m_value!=0)
            m_isRoman = true;
        else
            m_value = Integer.parseInt(str);

        if (m_value<0 || m_value>10)
            throw new IllegalArgumentException();
    }
    // Метод сложения
    public void Addition(final Operand token) throws IllegalArgumentException
    {
        if (m_isRoman != token.m_isRoman)
            throw new IllegalArgumentException ("Нельзя складывать римские и арабские числа.");

        m_value += token.m_value;
    }

    // Метод вычитания
    public void Subtraction(final Operand token) throws IllegalArgumentException
    {
        if (m_isRoman != token.m_isRoman)
            throw new IllegalArgumentException ("Нельзя вычитать римские и арабские числа.");

        m_value -= token.m_value;
    }

    // Метод умножения
    public void Multiplication(final Operand token) throws IllegalArgumentException
    {
        if (m_isRoman != token.m_isRoman)
            throw new IllegalArgumentException ("Нельзя умножать римские и арабские числа.");

        m_value *= token.m_value;
    }

    // Метод деления
    public void Division(final Operand token) throws IllegalArgumentException, ArithmeticException
    {
        if (m_isRoman != token.m_isRoman)
            throw new IllegalArgumentException("Нельзя делить римские и арабские числа.");

        if (token.m_value == 0)
            throw new ArithmeticException("Деление на ноль недопустимо.");

        m_value /= token.m_value;
    }

    // Метод вывода значения
    public void Print()
    {
        System.out.println(m_isRoman ? Convertor.ToRoman(m_value) : m_value);
    }

    private boolean m_isRoman = false;
    private int m_value = 0;
}
