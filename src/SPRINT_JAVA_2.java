import java.util.Scanner;

/**
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
 * SIMULADOR DE ROBÔ DE ARMAZÉM
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
 *
 * Descrição: O robô parte da posição inicial (S) e deve chegar
 * até a saída (E - END), percorrendo apenas os corredores livres.
 * O programa aceita comandos indefinidamente até o robô chegar
 * em E ou o operador digitar SAIR.
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
 *
 * MAPA DO ARMAZÉM (13 linhas x 20 colunas):
 *
 * Direções:
 *   FRENTE   = para cima (linha diminui)
 *   TRAS     = para baixo (linha aumenta)
 *   ESQUERDA = para a esquerda (coluna diminui)
 *   DIREITA  = para a direita (coluna aumenta)
 *
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
 */

public class SPRINT_JAVA_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Definição do mapa (13 linhas x 20 colunas)
        // Coordenadas do robô (posição inicial S = linha 11, coluna 1)
        int roboLinha = 11;
        int roboColuna = 1;

        // Coordenadas da saída (E = linha 1, coluna 18)
        int saidaLinha = 1;
        int saidaColuna = 18;

        // Dimensões do armazém
        int totalLinhas = 13;
        int totalColunas = 20;

        // Custo por unidade de distância
        double custoPorUnidade = 0.50;
        double custoTotal = 0.0;

        // Controle do laço principal (1 = rodando, 0 = parar)
        int rodando = 1;
        int chegouSaida = 0;

        //  Exibição do mapa e instruções iniciais
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("   SIMULADOR DE ROBO DE ARMAZEM - SPRINT 2");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println();
        System.out.println("Comandos: FRENTE (cima), TRAS (baixo), ESQUERDA, DIREITA ou SAIR");
        System.out.println();
        System.out.println("Posicao inicial do robo: Linha " + roboLinha + ", Coluna " + roboColuna);
        System.out.println("Destino (saida E): Linha " + saidaLinha + ", Coluna " + saidaColuna);
        System.out.println();


        while (rodando == 1) {

            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println();
            System.out.println("Posicao atual: Linha " + roboLinha + ", Coluna " + roboColuna);
            System.out.print("Digite o COMANDO (FRENTE/TRAS/ESQUERDA/DIREITA/SAIR) ---> ");
            String comando = sc.nextLine();

            // Verificar se o operador quer sair
            if (comando.equals("SAIR")) {
                System.out.println();
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Operador encerrou a sessao com comando SAIR.");
                System.out.println("Custo acumulado: R$ " + String.format("%.2f", custoTotal));
                System.out.println("Rota NAO concluida.");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                break;
            }

            // Validar se o comando é reconhecido
            int comandoValido = 0;
            if (comando.equals("FRENTE")) {
                comandoValido = 1;
            } else if (comando.equals("TRAS")) {
                comandoValido = 1;
            } else if (comando.equals("ESQUERDA")) {
                comandoValido = 1;
            } else if (comando.equals("DIREITA")) {
                comandoValido = 1;
            }

            if (comandoValido == 0) {
                System.out.println(">> COMANDO INVALIDO - comando desconhecido.");
                System.out.println();
                continue;
            }

            // Ler a distância
            System.out.print("Digite a DISTANCIA (valor inteiro positivo) ---> ");
            int distancia = sc.nextInt();
            sc.nextLine();

            // Validar se a distância é positiva
            if (distancia <= 0) {
                System.out.println(">> COMANDO INVALIDO - distancia deve ser positiva.");
                System.out.println();
                continue;
            }

            // Calcular nova posição
            int novaLinha = roboLinha;
            int novaColuna = roboColuna;

            if (comando.equals("FRENTE")) {
                novaLinha = roboLinha - distancia;
            } else if (comando.equals("TRAS")) {
                novaLinha = roboLinha + distancia;
            } else if (comando.equals("ESQUERDA")) {
                novaColuna = roboColuna - distancia;
            } else if (comando.equals("DIREITA")) {
                novaColuna = roboColuna + distancia;
            }

            // Verificar se saiu dos limites do armazém
            if (novaLinha < 0 || novaLinha >= totalLinhas || novaColuna < 0 || novaColuna >= totalColunas) {
                System.out.println(">> COMANDO INVALIDO - movimento fora dos limites do armazem.");
                System.out.println();
                continue;
            }

            // VERIFICAÇÃO DE COLISÃO NO CAMINHO (célula a célula)
            int caminhoLivre = 1;
            int verificaLinha = roboLinha;
            int verificaColuna = roboColuna;
            int passos = 0;

            while (passos < distancia) {
                // Avançar uma célula na direção do comando
                if (comando.equals("FRENTE")) {
                    verificaLinha = verificaLinha - 1;
                } else if (comando.equals("TRAS")) {
                    verificaLinha = verificaLinha + 1;
                } else if (comando.equals("ESQUERDA")) {
                    verificaColuna = verificaColuna - 1;
                } else if (comando.equals("DIREITA")) {
                    verificaColuna = verificaColuna + 1;
                }

                // Verificar se a célula atual é bloqueada
                int bloqueado = 0;

                // PAREDES (perímetro do armazém)
                if (verificaLinha == 0 || verificaLinha == 12 || verificaColuna == 0 || verificaColuna == 19) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 3: colunas 6 a 9
                else if (verificaLinha == 3 && verificaColuna >= 6 && verificaColuna <= 9) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 4: coluna 6
                else if (verificaLinha == 4 && verificaColuna == 6) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 5: colunas 5 e 6
                else if (verificaLinha == 5 && verificaColuna == 5) {
                    bloqueado = 1;
                }
                else if (verificaLinha == 5 && verificaColuna == 6) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 7: colunas 11 a 18
                else if (verificaLinha == 7 && verificaColuna >= 11 && verificaColuna <= 18) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 8: coluna 11
                else if (verificaLinha == 8 && verificaColuna == 11) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 9: coluna 11
                else if (verificaLinha == 9 && verificaColuna == 11) {
                    bloqueado = 1;
                }
                // PRATELEIRA na Linha 11: colunas 6 a 18
                else if (verificaLinha == 11 && verificaColuna >= 6 && verificaColuna <= 18) {
                    bloqueado = 1;
                }

                // Se encontrou bloqueio, marca caminho como não livre
                if (bloqueado == 1) {
                    caminhoLivre = 0;
                    break; // Sai do while de verificação
                }

                passos = passos + 1;
            }

            // Se o caminho não está livre, comando inválido
            if (caminhoLivre == 0) {
                System.out.println(">> COMANDO INVALIDO - colisao com prateleira ou parede.");
                System.out.println();
                continue;
            }

            // Movimento válido: atualizar posição do robô
            roboLinha = novaLinha;
            roboColuna = novaColuna;

            // Acumular custo operacional
            custoTotal = custoTotal + (distancia * custoPorUnidade);

            System.out.println(">> Valido - robo avanca.");
            System.out.println("   Nova posicao: Linha " + roboLinha + ", Coluna " + roboColuna);
            System.out.println("   Custo acumulado: R$ " + String.format("%.2f", custoTotal));

            // Verificar se o robô chegou na saída E (END)
            if (roboLinha == saidaLinha && roboColuna == saidaColuna) {
                chegouSaida = 1;
                System.out.println();
                System.out.println(">> Valido - robo chega em E! ENCERRADO.");
                rodando = 0;
            }

            System.out.println();
        }

        // ENCERRAMENTO - Exibir resultado final com classificação
        if (chegouSaida == 1) {
            System.out.println("----------------------------------------------");
            System.out.println("PARABENS! O robo chegou a saida (E)!");
            System.out.println("Custo total da rota: R$ " + String.format("%.2f", custoTotal));
            System.out.println();

            // Classificação do custo
            if (custoTotal <= 5.00) {
                System.out.println("Classificacao: ROTA ECONOMICA");
                System.out.println("Rota aprovada. Operacao lucrativa.");
            } else if (custoTotal <= 10.00) {
                System.out.println("Classificacao: ROTA MODERADA");
                System.out.println("Rota aprovada com ressalvas.");
            } else {
                System.out.println("Classificacao: ROTA INEFICIENTE");
                System.out.println("Rota reprovada. Revisar trajeto.");
            }

            System.out.println("----------------------------------------------");
        }

        sc.close();
    }
}