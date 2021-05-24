
import java.util.Calendar;

public class Datas {

    private int dia;
    private int mes;
    private int ano;

    public Datas(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }
    }

    public Datas() {
        Calendar dataDoSistema = Calendar.getInstance();
        this.dia = dataDoSistema.get(Calendar.DAY_OF_MONTH);
        this.mes = dataDoSistema.get(Calendar.MONTH);
        this.ano = dataDoSistema.get(Calendar.YEAR);
    }

    private boolean validaData(int dia, int mes, int ano) {
        if (ano > 0 && mes > 0 && dia > 0) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 && dia <= 31) {
                return true;
            } else {
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11 && dia <= 30) {
                    return true;
                } else {
                    if (mes == 2 && dia <= 28) {
                        return true;
                    } else {
                        if (ehBissexto(ano) && dia <= 29) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void avancaData(){
        int novo_dia = this.dia +1;
        if(validaData(novo_dia, this.mes,this.ano)){
                setDia(novo_dia);
        } else{
            int novoMes = this.mes+1;
            if(validaData(1,novoMes,this.ano)){
                setDia(1);
                setMes(novoMes);
            } else{
                setDia(1);
                setMes(1);
                setAno(this.ano+1);
                
            }
        }
    }
    private boolean ehBissexto(int ano) {
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (validaData(dia, this.mes, this.ano)) {
            this.dia = dia;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (validaData(this.dia, mes, this.ano)) {
            this.mes = mes;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (validaData(this.dia, this.mes, ano)) {
            this.ano = ano;
        }
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
    
