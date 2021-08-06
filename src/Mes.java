package MediaAcoes.src;
public class Mes {

    String nomeMes;
    Semanas[] semana;
    float mediasMensais;

    Mes(String nomeMes) {

        this.nomeMes = nomeMes;
        this.semana = new Semanas[4];
        this.mediasMensais = 0;

    }
}