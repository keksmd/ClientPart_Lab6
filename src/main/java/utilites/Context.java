package utilites;

import java.util.Scanner;

public class Context {
    Scanner sc;
    public Context(Scanner sc){
        this.sc = sc;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
