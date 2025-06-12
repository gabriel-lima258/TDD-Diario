// Arquivo: IRPF.java
package br.edu.ifpb.irpf;

public class IRPF {
    private double salario;
    private double previdencia;
    private String[] dependentes;

    public IRPF() {
        this.salario = 0;
        this.previdencia = 0;
        this.dependentes = new String[0];
    }

    public void cadastrarSalario(double valor) {
        this.salario += valor;
    }

    public double totalSalario() {
        return this.salario;
    }

    public void cadastrarPrevidenciaOficial(double valor) {
        this.previdencia += valor;
    }

    public double totalPrevidenciaOficial() {
        return this.previdencia;
    }

    public void cadastrarDependente(String nome) {
        String[] novoArray = new String[this.dependentes.length + 1];
        for (int i = 0; i < this.dependentes.length; i++) {
            novoArray[i] = this.dependentes[i];
        }
        novoArray[this.dependentes.length] = nome;
        this.dependentes = novoArray;
    }

    public double totalDeducaoDependentes() {
        return this.dependentes.length * 189.59;
    }
} 

// Arquivo: IRPFTest.java
package br.edu.ifpb.irpf;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IRPFTest {
    private IRPF irpf;

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testCadastrarSalario() {
        irpf.cadastrarSalario(5000.00);
        assertEquals(5000.00, irpf.totalSalario(), 0.01);
    }

    @Test
    public void testCadastrarSalario2() {
        irpf.cadastrarSalario(6000.00);
        assertEquals(6000.00, irpf.totalSalario(), 0.01);
    }

    @Test
    public void testCadastrarSalario3() {
        irpf.cadastrarSalario(5000.00);
        irpf.cadastrarSalario(6000.00);
        assertEquals(11000.00, irpf.totalSalario(), 0.01);
    }

    @Test
    public void testCadastrarPrevidenciaOficial() {
        irpf.cadastrarPrevidenciaOficial(700.00);
        assertEquals(700.00, irpf.totalPrevidenciaOficial(), 0.01);
    }

    @Test
    public void testCadastrarPrevidenciaOficial2() {
        irpf.cadastrarPrevidenciaOficial(800.00);
        assertEquals(800.00, irpf.totalPrevidenciaOficial(), 0.01);
    }

    @Test
    public void testCadastrarPrevidenciaOficial3() {
        irpf.cadastrarPrevidenciaOficial(900.00);
        assertEquals(900.00, irpf.totalPrevidenciaOficial(), 0.01);
    }

    @Test
    public void testCadastrarDependente() {
        irpf.cadastrarDependente("João");
        assertEquals(189.59, irpf.totalDeducaoDependentes(), 0.01);
    }

    @Test
    public void testCadastrarDoisDependentes() {
        irpf.cadastrarDependente("Maria");
        irpf.cadastrarDependente("José");
        assertEquals(379.18, irpf.totalDeducaoDependentes(), 0.01);
    }

    @Test
    public void testCadastrarCincoDependentes() {
        irpf.cadastrarDependente("A");
        irpf.cadastrarDependente("B");
        irpf.cadastrarDependente("C");
        irpf.cadastrarDependente("D");
        irpf.cadastrarDependente("E");
        assertEquals(947.95, irpf.totalDeducaoDependentes(), 0.01);
    }
}
