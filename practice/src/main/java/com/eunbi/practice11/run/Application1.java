package com.eunbi.practice11.run;

public class Application1 {
    public static void main(String[] args) {

        /* 캔디만 취급하는 스낵바를 이용해보자! */

        SnackBar<Candy> table1 = new SnackBar<>();
        SnackBar<BallCandy> table2 = new SnackBar<>();
        SnackBar<MintCandy> table3 = new SnackBar<>();
        SnackBar<Eclipse> table4 = new SnackBar<>();

        table1.setSnack(new Candy());
        table1.getSnack().eat();

        table2.setSnack(new BallCandy());
        table2.getSnack().eat();

        table3.setSnack(new MintCandy());
        table3.getSnack().eat();

        table4.setSnack(new Eclipse());
        table4.getSnack().eat();

    }
}
