package org.itstep;

import java.util.Scanner;

public class Controller {
        private Model model;
        private View view;

    // Constants
    //diapazon [1-99]
    final int MIN=1;
    final  int MAX=99;

    // REGEX

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //Work method
    public void processUser(){
        model.randomNumberInDiapazon(MIN,MAX);
        Scanner sc = new Scanner(System.in);
       while (!model.isGuessed()){
       model.setValue(inputIntValueWithScannerAndDiapason(sc));
           if(model.newMaxBarrier()){model.setStatistic(); view.printMessage(view.SMALL + model.getMaxBarrier());}
           else if(model.newMinBarrier()){model.setStatistic(); view.printMessage(view.GRATER + model.getMinBarrier());}
       }
       model.setStatistic();
       model.printStatistic();
       view.printMessage(View.CONGRATULATION);
       sc.close();
    }


/*    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_INT_DATA);
        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }*/

    public int inputIntValueWithScannerAndDiapason(Scanner sc) {
        int res=0;
        view.printMessage(view.INPUT_INT_DATA +
                model.getMinBarrier() +view.TO + model.getMaxBarrier());

            while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT_DATA
                        + view.INPUT_INT_DATA +model.getMinBarrier() +view.TO + model.getMaxBarrier());
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(view.WRONG_RANGE_DATA
                        + View.INPUT_INT_DATA +model.getMinBarrier() +view.TO + model.getMaxBarrier());
                continue ;
            }
            break;
        }
        return res;
    }


}
