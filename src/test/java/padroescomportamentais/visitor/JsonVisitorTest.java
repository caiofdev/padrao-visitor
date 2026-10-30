package padroescomportamentais.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonVisitorTest {

    private JsonVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new JsonVisitor();
    }

    @Test
    void deveExibirAlunoEmJson() {
        Curso curso = new Curso("Sistemas de Informação");
        Aluno aluno = new Aluno(1, "Ana", curso);

        assertEquals("{\"matricula\":1,\"nome\":\"Ana\",\"curso\":\"Sistemas de Informação\"}",
                visitor.exibir(aluno));
    }

    @Test
    void deveExibirProfessorEmJson() {
        Professor professor = new Professor(2, "Marco", "Doutor");

        assertEquals("{\"matricula\":2,\"nome\":\"Marco\",\"titulacao\":\"Doutor\"}",
                visitor.exibir(professor));
    }

    @Test
    void deveExibirFuncionarioEmJson() {
        Funcionario funcionario = new Funcionario(3, "Joana", 2500.0f);

        assertEquals("{\"codigo\":3,\"nome\":\"Joana\",\"salario\":2500.0}",
                visitor.exibir(funcionario));
    }

    @Test
    void deveEscaparAspasNoJson() {
        Professor professor = new Professor(4, "José \"Zé\" Silva", "Mestre");

        assertEquals("{\"matricula\":4,\"nome\":\"José \\\"Zé\\\" Silva\",\"titulacao\":\"Mestre\"}",
                visitor.exibir(professor));
    }

    @Test
    void deveExibirAlunoEmJsonViaAceitar() {
        Aluno aluno = new Aluno(5, "Pedro", new Curso("Engenharia"));

        assertEquals("{\"matricula\":5,\"nome\":\"Pedro\",\"curso\":\"Engenharia\"}",
                aluno.aceitar(visitor));
    }
}
