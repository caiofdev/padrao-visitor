package padroescomportamentais.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaVisitorTest {

    private PessoaVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new PessoaVisitor();
    }

    @Test
    void deveExibirAluno() {
        Aluno aluno = new Aluno(1, "Ana", new Curso("Sistemas de Informação"));

        assertEquals("Aluno{matricula=1, nome='Ana', curso=Sistemas de Informação}",
                visitor.exibir(aluno));
    }

    @Test
    void deveExibirProfessor() {
        Professor professor = new Professor(2, "Marco", "Doutor");

        assertEquals("Professor{matricula=2, nome='Marco', titulacao='Doutor'}",
                visitor.exibir(professor));
    }

    @Test
    void deveExibirFuncionario() {
        Funcionario funcionario = new Funcionario(3, "Joana", 2500.0f);

        assertEquals("Funcionario{codigo=3, nome='Joana', salario=2500.0}",
                visitor.exibir(funcionario));
    }
}
