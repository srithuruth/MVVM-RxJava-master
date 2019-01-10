package com.example.mvvm_rxjava;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class CalculatorViewModel {

    private PublishSubject<String> resultObservable = PublishSubject.create();
    private int numberOne = 0;
    private int numberTwo = 0;
    private int result = 0;

    public void add(String a, String b) {
        getNumbersFromInput(a, b);
        result = numberOne + numberTwo;
        resultObservable.onNext(String.valueOf(result));
        }

    public void subtract(String a, String b) {
        getNumbersFromInput(a, b);
        result = numberOne - numberTwo;
        resultObservable.onNext(String.valueOf(result));
    }

    public void multiply(String a, String b) {
        getNumbersFromInput(a, b);
        result = numberOne * numberTwo;
        resultObservable.onNext(String.valueOf(result));
    }

    public void divide(String a, String b) {
        getNumbersFromInput(a, b);
        result = numberOne / numberTwo;
        resultObservable.onNext(String.valueOf(result));
    }

    public Observable<String> getResultObservable() {
        return resultObservable;
    }

    private void getNumbersFromInput(String a, String b) {
        try {
            numberOne = Integer.valueOf(a);
            numberTwo = Integer.valueOf(b);
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
    }
}
