import java.util.Scanner;

public class Main {

    static final int MAX = 3;
    static String agenda[] = new String[MAX];
    static final int EXIT = 6;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int optiune;

        meniu();
        System.out.print("Alege o optiune din meniu prin tastarea Index-ului: ");
        optiune = input.nextInt();

        while(optiune!=EXIT){
            System.out.println("Ati ales: " + optiune);

            switch(optiune){

                case 1: afisare();break;
                case 2: cautare();break;
                case 3: adaugare();break;
                case 4: modifica();break;
                case 5: stergere();break;
                default:
                    System.out.println(optiune + " nu exista in meniu. Incearca sa testezi numarul corespunzator optiunii pe care vrei sa accesezi.");break;
            }

            meniu();
            System.out.print("Alege o optiune din meniu prin tastarea Index-ului: ");
            optiune = input.nextInt();
        }

    }

    static void meniu() {
        System.out.println("--------------------------------------------------");
        System.out.println("1. Afisare");
        System.out.println("2. Cautare");
        System.out.println("3. Adaugare");
        System.out.println("4. Modifica");
        System.out.println("5. Sterge");
        System.out.println("6. EXIT");
    }

    static void afisare() {
        System.out.println("--------------------------------------------------");
        for(int i = 0; i < agenda.length; i++){
            if(agenda[i] != null){
                System.out.println(agenda[i]);
            }
        }
    }

    static void cautare(){
        Scanner input = new Scanner(System.in);
        System.out.print("Scrie numele sau numarul de telefon pe care vrei sa-l cauti: ");
        String cauta = input.nextLine().toLowerCase();
        boolean gasit = false;

        for(int i=0; i < agenda.length; i++){
            if(agenda[i] == null) {
                continue;
            } else if(agenda[i].contains(cauta)){
                System.out.println("Numele sau numarul de telefon a fost gasit la index-ul: " + i + ". " + agenda[i]);
                gasit = true;
            }
        }
        if(!gasit) {
            System.out.println("Numele sau numarul de telefon nu a fost gasit in agenda.");
        }
    }

    static void adaugare() {
        Scanner input = new Scanner(System.in);
        System.out.print("Adauga un nume si numar de telefon: ");
        String nume = input.nextLine();
        boolean full = false;
        for(int i = 0; i<agenda.length;i++){
            if(agenda[i] == null) {
                agenda[i] = nume;
                full = true;
                break;
            }
        }
        if(!full)
            System.out.println("Imi pare rau, agenda este deja plina.");
    }

    static void modifica() {
        Scanner input = new Scanner(System.in);
        System.out.print("Tasteaza index-ul corespunzator al numelui pe care vrei sa il modificl. Sau tasteaza '-1' pentru a reveni inapoi la meniu. ");
        int index = input.nextInt();

        if(index >= MAX){
            System.out.println("Ai depasit marimea sirului.");
            modifica();
        } else if(index >= 0 && index < MAX) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("Adauga un nume si numar de telefon: ");
            String modificare = input2.nextLine();
            agenda[index] = modificare;
            System.out.println("Index-ul a fost modificat.");
        } else if (index == -1) {
        }
    }

    static void stergere() {
        Scanner input = new Scanner(System.in);
        System.out.print("Introdu index-ul corespunzator al numelui pe care il vrei sa il stergi. Daca vrei sa revi la meniu tasteaza '-1'. ");
        int index = input.nextInt();


        if( index == -1) {

        } else if(agenda[index] == null) {
            System.out.println("Valoare index-ului ales are deja valoarea 'null'.");
        } else {
            agenda[index] = null;
        }
    }
}
