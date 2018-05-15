/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

import static java.lang.Thread.sleep;

/**
 *
 * @author Gruppe 18gr6406
 */
public class SpilModel {
    static int milisekunder =0;
    static int sekunder = 0;
    static int minutter = 0;
    static int timer = 0;
    static boolean stadie = false;
    
    
    public void startTimer(){
        stadie = true;

            Thread stopUr = new Thread(){
                public void run(){
                    for(;;){
                        if(stadie == true){
                            try{
                                sleep(1);
                                if(milisekunder > 1000){
                                    milisekunder = 0;
                                    sekunder ++;
                                }
                                if(sekunder > 60){
                                    milisekunder = 0;
                                    sekunder = 0;
                                    minutter ++;
                                }
                                if(minutter > 60){
                                    milisekunder = 0;
                                    sekunder = 0;
                                    minutter = 0;
                                    timer ++;
                                }
                                milisekunder ++;
//                                sekunderDisplay.setText(" : "+sekunder);
//
//                                minutterDisplay.setText(" : "+minutter);
//                                timerDisplay.setText(" "+timer);
                                System.out.println(" "+timer+" : "+minutter+" : "+sekunder);
                            }
                            catch(Exception e){
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            };
            stopUr.start();
    }
    
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package bp.model;
//
//import static java.lang.Thread.sleep;
//
///**
// *
// * @author Gruppe 18gr6406
// */
//public class SpilModel {
//    static int milisekunder =0;
//    static int sekunder = 0;
//    static int minutter = 0;
//    static int timer = 0;
//    static boolean stadie = false;
//                                    String timerTid ;
//
//    
//    
//    public String startTimer(){
//        stadie = true;
//        
//
//           
//                    for(;;){
//                        if(stadie == true){
//                            try{
//                                sleep(1);
//                                if(milisekunder > 1000){
//                                    milisekunder = 0;
//                                    sekunder ++;
//                                }
//                                if(sekunder > 59){
//                                    milisekunder = 0;
//                                    sekunder = 0;
//                                    minutter ++;
//                                }
//                                if(minutter > 59){
//                                    milisekunder = 0;
//                                    sekunder = 0;
//                                    minutter = 0;
//                                    timer ++;
//                                }
//                                milisekunder ++;
////                                String timerTid = "00:00:00";
//
//                                String timerString = String.valueOf(timer);
//                                String minutterString = String.valueOf(minutter);
//                                String sekunderString = String.valueOf(sekunder);
//
////                                sekunderDisplay.setText(" : "+sekunder);
////
////                                minutterDisplay.setText(" : "+minutter);
////                                timerDisplay.setText(" "+timer);
//                                    timerTid = " "+timerString+" : "+minutterString+" : "+sekunderString;
//                                System.out.println(timerTid);
//                            }
//                            catch(Exception e){
//                            }
//                        }
//                        else{
//                            break;
//                        }
//                    }
//              
//    return timerTid;
//    }
//    
//    
//}
