public class Token
{
    Token(final String str) throws Exception
    {
        m_value = RomanToInt(str);
        if(m_value!=0)
            m_isRoman = true;
        else
            m_value = Integer.parseInt(str);

        if (m_value<0 || m_value>10)
            throw new Exception();
    }

    // Метод сложения
    public void Addition(final Token token) throws Exception
    {
        if (m_isRoman != token.m_isRoman)
            throw new Exception("Нельзя складывать римские и арабские числа.");

        m_value += token.m_value;
    }

    // Метод вычитания
    public void Subtraction(final Token token) throws Exception
    {
        if (m_isRoman != token.m_isRoman)
            throw new Exception("Нельзя вычитать римские и арабские числа.");

        m_value -= token.m_value;
    }

    // Метод умножения
    public void Multiplication(final Token token) throws Exception
    {
        if (m_isRoman != token.m_isRoman)
            throw new Exception("Нельзя умножать римские и арабские числа.");

        m_value *= token.m_value;
    }

    // Метод деления
    public void Division(final Token token) throws Exception
    {
        if (m_isRoman != token.m_isRoman)
            throw new Exception("Нельзя делить римские и арабские числа.");

        if (token.m_value == 0)
            throw new Exception("Деление на ноль недопустимо.");

        m_value /= token.m_value;
    }

    //Метод для декодирования римской строки в целое число
    private static int RomanToInt(final String roman)
    {
        int result = 0;
        String uRoman = roman.toUpperCase();
        for (int i = 0; i < uRoman.length() - 1; i++)
        {
            if (romanCharToInt(uRoman.charAt(i)) < romanCharToInt(uRoman.charAt(i + 1)))
                result -= romanCharToInt(uRoman.charAt(i));
             else
                result += romanCharToInt(uRoman.charAt(i));
        }
        result += romanCharToInt(uRoman.charAt(uRoman.length() - 1));
        return result;
    }

    // Метод декодирования символа
    private static int romanCharToInt(char symbol)
    {
        switch (symbol)
        {
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }

    // Перечисление римских чисел и их весов
    enum Numeral
    {

        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);
        final int weight;

        Numeral(int weight) { this.weight = weight;}
    }

    // Метод для конвертации арабского числа в римское
    public static String ToRoman(int n) throws Exception
    {
        if (n <= 0)
            throw new Exception("Число должно быть положительным.");

        StringBuilder buf = new StringBuilder();

        final Numeral[] values = Numeral.values();
        for (int i = values.length - 1; i >= 0; i--)
        {
            while (n >= values[i].weight)
            {
                buf.append(values[i]);
                n -= values[i].weight;
            }
        }
        return buf.toString();
    }

    // Метод вывода значения
    public void Print() throws Exception
    {
        System.out.println(m_isRoman ? ToRoman(m_value) : m_value);
    }

    private boolean m_isRoman = false;
    private int m_value = 0;
}
