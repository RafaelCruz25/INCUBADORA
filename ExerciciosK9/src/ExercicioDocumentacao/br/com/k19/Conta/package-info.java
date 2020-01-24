/**
 * Documentação do pacote br.com.k19.contas
 */

package ExercicioDocumentacao.br.com.k19.Conta;

class Conta{

    /**
     * Documentação do atributo numero
     */
    private int numero;

    /**
     * Documentação do construtor
     *
     * @param numero
     *                  documentação do atributo numero
     *
     * @throws IllegalArgumentException
     *          documentação da situação que gera a exception
     *          IllegalArgumentException
     */

    public Conta(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("numero negativo");
        }
        this.numero = numero;
    }
        /**
         * Documentação do método getNumero
         *
         * @return documentação do valor de retorno
         */

        public int getNumero(){
            return numero;
        }
}
