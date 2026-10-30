package padroescomportamentais.visitor;

public class JsonVisitor implements Visitor {

    public String exibir(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {
        return "{" +
                "\"matricula\":" + aluno.getMatricula() +
                ",\"nome\":" + texto(aluno.getNome()) +
                ",\"curso\":" + texto(aluno.getNomeCurso()) +
                "}";
    }

    @Override
    public String exibirProfessor(Professor professor) {
        return "{" +
                "\"matricula\":" + professor.getMatricula() +
                ",\"nome\":" + texto(professor.getNome()) +
                ",\"titulacao\":" + texto(professor.getTitulacao()) +
                "}";
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {
        return "{" +
                "\"codigo\":" + funcionario.getCodigo() +
                ",\"nome\":" + texto(funcionario.getNome()) +
                ",\"salario\":" + funcionario.getSalario() +
                "}";
    }

    private String texto(String valor) {
        if (valor == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("\"");
        for (char c : valor.toCharArray()) {
            switch (c) {
                case '"':  sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n");  break;
                case '\r': sb.append("\\r");  break;
                case '\t': sb.append("\\t");  break;
                default:   sb.append(c);
            }
        }
        return sb.append('"').toString();
    }
}
