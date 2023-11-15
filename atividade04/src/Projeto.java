import org.w3c.dom.Text;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import java.time.Month;
public class Projeto {
    public static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        int receita = 0,custo = 0,lucro =0,answer =0;
        Bts historico = new Bts();
        Month[] meses = Month.values();
        Scanner leitor = new Scanner(System.in);
        String message="";
        int i=0;
        //Esse valor será único apenas para divisão. Ou seja, lucro sempre será diferente da meta.
        System.out.println("Qual sua meta? (R$)");
        int meta = Integer.parseInt(leitor.next());
        historico.insert(meta);
            do {
                if(receita!=0 && custo!=0) {
                    lucro = receita-custo;
                    if (lucro<0) {
                        message = "3 - Cadastrar despesa: "+ lucro+"R$";
                    } else if (lucro == 0) {
                        message = "3 - Cadastrar lucro nulo: "+lucro+"R$";
                    } else {
                        message = "3 - Cadastrar Lucro: "+ lucro+"R$";
                    }
                }
                System.out.printf("""
                        Mês: %s
                        Verificador de lucro de empresas.
                        0 - Sair;
                        1 - Digitar Receita (%d)
                        2 - Digitar Custos (%d)
                        %s
                        %s
                        
                        """,meses[i].getDisplayName(TextStyle.FULL, Locale.of("pt")).toUpperCase(), receita, custo, message,historico.size()==1?"":"4 - Remover mês (escolher)");
                answer = Integer.parseInt(leitor.next());
                switch (answer){
                    case 0:
                        System.out.println("Obrigado por usar nossos serviços!");
                        break;
                    case 1:
                        System.out.print("Qual a receita do mês "+ meses[i].getDisplayName(TextStyle.FULL, Locale.of("pt")).toUpperCase()+ " (R$): ");
                        receita= Integer.parseInt(leitor.next());
                        break;
                    case 2:
                        System.out.print("Quais os custos do mês "+ meses[i].getDisplayName(TextStyle.FULL, Locale.of("pt")).toUpperCase()+ " (R$): ");
                        custo = Integer.parseInt(leitor.next());
                        break;
                    case 3:
                        if (!message.isBlank()){
                            historico.insert(lucro, meses[i].getDisplayName(TextStyle.FULL, Locale.of("pt")).toUpperCase());
                            i++;
                            receita=0;
                            custo=0;
                            lucro=0;
                            message="";
                        }else{
                            System.out.println("Alguns dados não foram preenchidos, tente novamente.");
                        }
                        break;
                    case 4:
                        if(historico.isEmpty()){
                            System.out.println("Opção inválida");
                            break;
                        }
                        //Considerando não haver valores iguais, cada mês terá seu lucro único.
                        System.out.println("Digite o valor referente do mês que deseja excluir.");
                        System.out.println(historico);
                        System.out.print("Digite o valor: ");
                        int valor = Integer.parseInt(leitor.next());
                        String mes = historico.search_mes(valor);
                        historico.remove(valor);
                        System.out.println("Digitite o novo lucro para o mês de "+ mes + ": ");
                        historico.insert(Integer.parseInt(leitor.next()),mes);
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
                System.out.println();
            }while(answer!=0 && i!=13);
            if(!historico.toString().equals("")){
        System.out.println("historico.mesesAcimaDaMeta() : " +historico.mesesAcimaDaMeta());
        System.out.println("historico.mesesAbaixoDaMeta() : " +historico.mesesAbaixoDaMeta());
    }
    }

}
