//Livro de Classe
//Classe GradeBook utilizando um array para armazenar notas de teste.

import org.w3c.dom.ls.LSOutput;

public class GradeBook {
    private String courseName;//Nome do curso que essa GradeBook representa
    private int[] grades; //Array de notas de aluno;

    //Construtor

    public GradeBook(String courseName, int[] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

   //Realiza várias operações nos dados
    public void processesGrades(){
        //Gera saída de array de notas
        outputGrades();

        //Chama outputBarChart para imprimir gráfico de distribuição de nota
        outputBarChart();

        //Chama o método getMinimum e getMaximim
        System.out.printf("%nStudent average is: %.2f%n", getAverage());

        //Chama métodos getMinimum e getMaximum
        System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n",
                getMinimum(), getMaximum());

        ChecksSituation();

    }

    //Verifica a situação do aluno
    private void ChecksSituation() {
        //Se a média for maior que 7 mostrar aprovado
        if (getAverage() >= 7)
            System.out.printf("Approved by average%n%n");
        else if (getAverage() < 7){
            System.out.printf("Failed in the final direction.%n%n");
            finalProof();
        }
        else if (finalProof() > 5)
            System.out.printf("Approved in the final%n%n");
        else if (getAverage() < 3)
            System.out.printf("Failed by average%n%n");


    }

    //Calcula a prova final
    private double finalProof() {
        double aux = getAverage();
        double result = 7 - aux ;

        System.out.printf("É preciso tirar %.2f na final%n%n", result);
        return result;
    }

    //Localiza nota mínima
    private int getMinimum() {
        int lowGrade = grades[0]; //Supõe que grades[0] é a menor nota

        //Faz um loop pelo array de notas
        for (int grade :
                grades) {
            //Se nota for mais baixa que lowGrade, atribui essa nota a lowGrade
            if (grade < lowGrade)
                lowGrade = grade; //Nova nota mais baixa
        }
        return lowGrade;
    }

    //Localiza nota máxima
    private int getMaximum(){
        int highGrade = grades[0]; //Supõe que grades[0] é a maior nota

        //Faz um loop pelo array de notas
        for (int grade :
                grades) {
            if (grade > highGrade)
                highGrade = grade;//Nova nota mais alta
        }
        return highGrade;
    }

    //Determina média para o teste
    private double getAverage() {
        int toral = 0;

        //Soma notas de um aluno
        for (int grade:
             grades) {
            toral += grade;
        }
        return (double) toral / grades.length;
    }

    //Gera a saída do gráfico de barras exibindo distribuição de notas
    private void outputBarChart() {
        System.out.printf("%n%nGrade distribution%n");

        //Armazena frequência de notas em cada intervalo de 10 notas
        int[] frequency = new int[11];

        //Para cada nota, incrementa a frequência apropriada
        for (int grade: grades)
            ++frequency[grade/10];

        //para cada frequência de nota, imprime barra no gráfico
        for (int count = 0; count < frequency.length; count++){
            //Gera saída do rótulo de barra ("00-09: ", ..., "90-99: ", "100: ")
            if (count == 10)
                System.out.printf("%5d: ", 100);
            else
                System.out.printf("%02d-%02d: ",
                        count * 10, count * 10 + 9);

            //Imprime a barra de asteriscos
            for (int stars = 0; stars < frequency[count]; stars++)
                System.out.printf("*");

            System.out.println();
        }
    }

    //Gera saída do conteúdo do array de notas
    private void outputGrades() {
        System.out.printf("The grades are:%n%n");

        //Gera a saída da nota de cada aluno
        for (int student = 0; student < grades.length; student++){
            System.out.printf("Grades %2d: %3d%n",
                    student + 1, grades[student]);
        }
    }
}//Fim da classe GradeBook
