public class Convertor {

    //Метод для декодирования римской строки в целое число
    public static int RomanToInt(final String roman)
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
    public static int romanCharToInt(char symbol)
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

    // Метод для конвертации арабского числа в римское
    public static String ToRoman(int n) throws IllegalArgumentException
    {
        if (n <= 0)
            throw new IllegalArgumentException("Число должно быть положительным.");

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

    // Перечисление римских чисел и их весов
    enum Numeral
    {
        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);
        final int weight;

        Numeral(int weight) { this.weight = weight;}
    }
}
