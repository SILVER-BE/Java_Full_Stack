package com.eunbi.practice11.run;

public class SnackBar<T extends Candy & Snack> {
    //스낵바가 스낵과 캔디만 취급하게 됨


    //정해지지 않은 타입의 스낵 필드 생성
    private T snack;

    //기본 생성자
    public SnackBar() {};

    //매개변수를 가진 생성자
    public SnackBar(T snack) {
        this.snack = snack;
    }

    //setter
    public void setSnack(T snack) {
        this.snack = snack;
    }

    //getter
    public T getSnack() {
        return snack;
    }
}
