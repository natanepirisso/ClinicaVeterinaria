package InputExceptions;

public class InputValidators {
    public static void notString(String input ) throws NotAStringException{
        if(!input.matches("[a-zA-Z]+")){throw new NotAStringException("Erro: digite apenas letras.");}
    }
    public static void notAInt(String input) throws NotANumberException{
        if(!input.matches("^\\d+([,.]\\d+)?$")){throw new NotANumberException("Erro de digitação: Digite um número corretamente.");}
    }
    public static void notAZeroOrMinor(Number input) throws NotAZeroOrMinorException{
        if(input.doubleValue() <=0 ){throw new NotAZeroOrMinorException("Erro: O digito deve ser maior que 0");}
    }
}
