import ui.custom.screen.MainScreen;
import util.SudokuGenerator;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        final Map<String, String> gameConfig;
        //verifica se o args passado possui formato válido e tamanho de 81
        if(checkIfArgsFormatIsValid(args) && args.length == 81) {
            //gerando um jogo de sudoku com base nas informações passadas em args
            gameConfig = Stream.of(args)
                    .collect(toMap(
                            k -> k.split(";")[0],
                            v -> v.split(";")[1]
                    ));

        } else { //se ele não atender os 2 requisitos é criado um sudoku aleatório
            //gerando um jogo de sudoku com 15 números visíveis
            gameConfig = Stream.of(SudokuGenerator.generateSudokuInputs(15))
                    .collect(toMap(
                            k -> k.split(";")[0],
                            v -> v.split(";")[1]
                    ));
        }
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    }

    private static boolean checkIfArgsFormatIsValid(String[] args) {
        boolean argsValidFormat = true;
        String argsFormat = "^[0-8],[0-8];[1-9],(true|false)$";

        for (String entrada : args) {
            if (!entrada.matches(argsFormat)) {
                System.out.println("Entrada inválida: " + entrada);
                argsValidFormat = false;
            }
        }
        return argsValidFormat;
    }

}