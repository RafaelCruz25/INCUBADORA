import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        String cpf = "123.455.675-12";
        valida(cpf);

    }

    public static boolean valida(String cpf){
        CPFValidator cpfValidator = new CPFValidator();

        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);

        if(erros.size()> 0 ){
            System.out.println(erros);
            return false;
        }
        else{
            System.out.println("CPF VÁLIDO!");
            return true;
        }
    }
}
