package MediaAcoes.src;
import java.io.PrintStream;
import java.util.Scanner;

public class MediaValoresBolsa{

    public static void main(String[] args) {
        MediaValoresBolsa programa = new MediaValoresBolsa();
        programa.executar();
    }

    private final Scanner entrada = new Scanner(System.in);
    private final PrintStream saida = System.out;
    
    public void executar() {
        escrever("Digite a quantidade de meses que receberão os valores diários das ações: \n");
        int qtdMes = lerInteiro();
        //escrever("Quantidade de meses: "+ Integer.toString(qtdMes));  
        Mes[] meses = new Mes[qtdMes];
        //escrever(Integer.toString(meses.length));
        for (int i = 0; i < meses.length; i++) {    
            escrever("Digite o nome do(a) " + (i + 1) + "° mes: (ex.: Janeiro, Fevereiro...) \n");
            Mes mes = new Mes(lerTexto());
            for (int n = 0; n < 4; n++) {
                escrever("Digite o valor da bolsa no domingo da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorDomingo = lerDecimal();
                escrever("Digite o valor da bolsa na segunda-feira da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorSegunda = lerDecimal();
                escrever("Digite o valor da bolsa na Terça-feira da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorTerca = lerDecimal();
                escrever("Digite o valor da bolsa na Quarta-feira da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorQuarta = lerDecimal();
                escrever("Digite o valor da bolsa na Quinta-feira da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorQuinta = lerDecimal();
                escrever("Digite o valor da bolsa na Sexta-feira da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorSexta = lerDecimal();
                escrever("Digite o valor da bolsa na Sábado da " + (n + 1) +"° semana do mês de "+ mes.nomeMes +"\n");
                float valorSabado = lerDecimal();
                float mediaSemanal = ((valorDomingo + valorSegunda + valorTerca + valorQuarta + valorQuinta + valorSexta + valorSabado)/7);
                Semanas semana = new Semanas (valorDomingo, valorSegunda, valorTerca, valorQuarta, valorQuinta, valorSexta, valorSabado, mediaSemanal);
                mes.semana[n] = semana;
            }
            meses[i] = mes;
        }
    
        float maior = 0;

        for(int m = 0; m < meses.length; m++){
            

            for(int n = 0; n < 4; n++){
                if(meses[m].semana[n].mediaSemanal > maior){
                    maior = meses[m].semana[n].mediaSemanal;
                }
            }
        }

        float menor = maior, mediatotalMes = 0;

        for(int m = 0; m < meses.length; m++){
            for(int n = 0; n < 4; n++){        
                if(meses[m].semana[n].mediaSemanal< menor){
                menor = meses[m].semana[n].mediaSemanal; 
                }
            }
            mediatotalMes = (meses[m].semana[0].mediaSemanal + meses[m].semana[1].mediaSemanal + meses[m].semana[2].mediaSemanal + meses[m].semana[3].mediaSemanal )/4; 
            escrever("A mmédia do mês de " + meses[m].nomeMes + "é: " + mediatotalMes + " \n" );
            escrever("A menor média semanal é: " + menor + " \n" );
            escrever("A mairo média semanal é: " + maior + " \n" );
        }
    }    
    private void escrever(String mensagem) {
        saida.print(mensagem);
    }

    private int lerInteiro() {
        return Integer.parseInt(lerTexto());
    }
    
    private Float lerDecimal() {
        return Float.parseFloat(lerTexto());
    }

    private String lerTexto() {
        return entrada.nextLine();
    }
}

