public class Aluno {
    final String nomeAluno; // Ultilizando como final, não necessario o set e get já que não estou
                            // utilizando protect nem private
    final Double notaAluno;

    public Aluno(String nomeAluno, Double notaAluno) {
        this.nomeAluno = nomeAluno;
        this.notaAluno = notaAluno;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nomeAluno + " tem nota " + notaAluno; // Uma forma de tratar informações do tipo String para não vir como
                                                     // memoria
    }
}
