package universidade;

/**  
 * Modelo de estudante de graduação da UFABC.
*/

public class Estudante {
    private String nome;
    private String ra;
    private double [] notas;

    /**
     * Constrói um novo estudante.
     * 
     * @param nome o nome completo do(a) estudante
     * @param ra O RA do formato UFABC
     * @param notas As notas obtidas[0,10]
     */

    public Estudante(String nome, String ra, double[] notas) {
        validaRA(ra);
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
    }

    /**
     * Valida se o RA está no formato UFABC
     * 
     * @param ra O ra
     */

    private void validaRA(String ra) {
        if(!ra.matches("\\d{11}")) {
            throw new IllegalArgumentException("RA fora do formato da UFABC");
        }
    }

     /**
     * Consulta o nome completo do estudante
     * @return o nome completo
     */

    public String getNome() {
        return nome;
    }


    
     /**
     * Altera o nome   estudante
     * @param nome o nome 
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    
     /**
     * Altera o nome completo do estudante
     * @param ra o novo RA
     * @throws IllegalArgumentException Se o RA Não estiver no formato UFABC
     */

    public void setRa(String ra) {
        validaRA(ra);
        this.ra = ra;
    }

    /**
     *Obtem a referencia para o array de notas do estudante 
     * @return as notas
     */
    public double[] getNotas() {
        return notas;
    }

    /**
     * Substitui o array de notas
     * 
     * @param notas  o novo array de notas
     */
    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    
    /**
     * Calcula a media atualizada do estudante
     * 
     * @return Calcula a media  [0,10]
     */

    private double somaNotas(){
        double soma = 0.0;

        for (var nota : notas) {
            soma += nota;
        }
        return soma;
    }

 /**
     * Consulta a media atualizada do estudante
     * 
     * @return a media atualizada [0,10]
     */
    public double getMedia() {
        if(notas.length ==0) {
            return 0.0;
        }
        return somaNotas() / notas.length;
    }
}