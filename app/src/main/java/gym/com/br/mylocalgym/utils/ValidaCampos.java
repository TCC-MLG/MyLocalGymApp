package gym.com.br.mylocalgym.utils;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

/**
 * Created by Jorge on 19/08/2016.
 */

public class ValidaCampos {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    public static boolean isValidCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)) {
            return false;
        }else {
            Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
            Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
            return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
        }
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj==null)||(cnpj.length()!=14)) return false;
        Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
    }

    //Valida se o email está
    public static boolean validateEmail(String rEmail) {
        if (rEmail.isEmpty() || !isValidEmail(rEmail)) {
            return false;
        } else {
            return true;
        }
    }

    // Compara as senhas informadas
    public static boolean comparaPassword(String rPassword, String rRPassword) {
        if (!rPassword.equals(rRPassword)){
            return false;
        } else {
            return true;
        }
    }

    //Verifica se o campo está vazio
    public static boolean validateField(TextInputLayout inputLayout) {
        if (inputLayout.getEditText().getText().toString().trim().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    // verifica se o formato do email é válido
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
