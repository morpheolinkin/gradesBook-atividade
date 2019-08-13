// GradeBookTest cria um objeto GradeBook utilizando um array de notas,
// e, então, invoca o método processGrades para analisá-las.

import java.util.Scanner;

public class GradeBookTeste {
    // método main inicia a execução de programa
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] gradesArray = new int[3];

        int opcao = menu();

        showGradesStudent(input, gradesArray, opcao);
    }


    //====================================================================================//
    private static void showGradesStudent(
            Scanner input, int[] gradesArray, int opcao) {
        do {
            switch (opcao){
                case 1:
                    System.out.println("Informe as notas");
                    for (int i = 0; i <3; i++){
                        gradesArray[i] = input.nextInt();
                    }
                    opcao = menu();
                    break;
                case 2:
                    GradeBook myGradeBook = new GradeBook(
                            "CS101 Introduction to Java Programming",gradesArray);
                    System.out.printf("Welcome to the grade book for%n%s%n%n",
                            myGradeBook.getCourseName());
                    myGradeBook.processesGrades();
                    opcao = menu();
                    break;
            }
        }while (opcao != 3);
    }

    //Menu a ser exibido
    private static int menu(){
        System.out.println("Escolha uma opção: ");
        System.out.println("1: Inserir");
        System.out.println("2: Listar");
        System.out.println("3: Sair");

        Scanner input2 = new Scanner(System.in);
        int escolha = input2.nextInt();

        return escolha;
    }
}
