import java.util.Scanner;

public class Tikkupeli {

    public static void main(String[] args) {

        int tikkujenMaara;
        boolean jatketaan = true;
        Scanner input = new Scanner(System.in);
        Scanner take = new Scanner(System.in);
        System.out.println("Pelissä otetaan vuorotellen 1-3 tikkua, viimoisen tikun ottanu häviää");
        while (jatketaan) {
            System.out.println("Monellako tikulla pelataan?");
            tikkujenMaara = take.nextInt();
            System.out.println("Pelataanko pelaajaa vai tietokonetta vastaan? (P/T)");
            String peliMuoto = input.nextLine();

            if (peliMuoto.equals("T") || peliMuoto.equals("t")) {
                yksinpeli(tikkujenMaara);
            } else {
                moninpeli(tikkujenMaara);
            }

            System.out.println("Uusi peli? (K/E)");
            String uusi = input.nextLine();
            if (uusi.equals("E") || uusi.equals("e")) {
                System.out.println("Hei hei!");
                jatketaan = false;
            } else {
                System.out.println("Jatketaan!");
            }
        }
    }

    public static void yksinpeli(int tikkujenMaara) {
        Scanner input = new Scanner(System.in);
        Scanner take = new Scanner(System.in);
        boolean aloitusJarjestys = false;

        System.out.println("Haluatko aloittaa? (K/E)");
        String aloittaja = input.nextLine();
        if (aloittaja.equals("K") || aloittaja.equals("k")) {
            aloitusJarjestys = true;
        }

        while (tikkujenMaara > 0) {
            if (aloitusJarjestys) {
                while (true) {
                    System.out.println("Pelaaja montako tikkua otat? (1-3) Tikkuja jäljellä: " + tikkujenMaara);
                    int x = take.nextInt();
                    if (x >= 1 && x <= 3) {
                        if ((tikkujenMaara -= x) >= 0) {
                            break;
                        }
                        System.out.println("Et voi ottaa enempää tikkuja kuin niitä on jäljellä!");
                        tikkujenMaara += x;
                    } else {
                        System.out.println("Tikkuja voi ottaa joko 1, 2 tai 3 kerrallaan.");
                    }
                }

                if (tikkujenMaara == 0) {
                    System.out.println("Tietokone voitti!");
                    break;
                }
            }
            aloitusJarjestys = true;
                System.out.println("Tietokone montako tikkua otat? (1-3) Tikkuja jäljellä: " + tikkujenMaara);
                int x;
                if ((tikkujenMaara - 4) % 4 == 0 || tikkujenMaara - 4 == 0) {
                    x = 3;
                } else if ((tikkujenMaara - 3) % 4 == 0 || tikkujenMaara - 3 == 0) {
                    x = 2;
                } else {
                    x = 1;
                }
                System.out.println("Tietokone otti: " + x);
                tikkujenMaara -= x;

            if (tikkujenMaara == 0) {
                System.out.println("Pelaaja voitti!");
                break;
            }
        }
    }

    public static void moninpeli(int tikkujenMaara) {
        Scanner take = new Scanner(System.in);

        while (tikkujenMaara > 0) {
            while(true) {
                System.out.println("Pelaaja 1 montako tikkua otat? (1-3) Tikkuja jäljellä: " + tikkujenMaara);
                int x = take.nextInt();
                if (x >= 1 && x <= 3) {
                    if ((tikkujenMaara -= x) >= 0) {
                        break;
                    }
                    System.out.println("Et voi ottaa enempää tikkuja kuin niitä on jäljellä!" );
                    tikkujenMaara += x;
                } else {
                    System.out.println("Tikkuja voi ottaa joko 1, 2 tai 3 kerrallaan.");
                }
            }

            if (tikkujenMaara == 0) {
                System.out.println("Pelaaja 2 voitti!");
                break;
            }

            while(true) {
                System.out.println("Pelaaja 2 montako tikkua otat? (1-3) Tikkuja jäljellä: " + tikkujenMaara);
                int x = take.nextInt();
                if (x >= 1 && x <= 3) {
                    if ((tikkujenMaara -= x) >= 0) {
                        break;
                    }
                    System.out.println("Et voi ottaa enempää tikkuja kuin niitä on jäljellä!");
                    tikkujenMaara += x;
                } else {
                    System.out.println("Tikkuja voi ottaa joko 1, 2 tai 3 kerrallaan.");
                }
            }

            if (tikkujenMaara == 0) {
                System.out.println("Pelaaja 1 voitti!");
                break;
            }
        }
    }
}
