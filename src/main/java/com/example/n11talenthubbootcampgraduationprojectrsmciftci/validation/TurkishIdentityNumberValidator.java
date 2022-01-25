package com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TurkishIdentityNumberValidator implements ConstraintValidator<TurkishIdentityNumber,String> {
    @Override
    public void initialize(TurkishIdentityNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(isAllDigit(value)){
            if(isIt11characters(value)){
                if(isUnitOfSumOfFirst10EqualTo11thNumber(value)){
                    if(isUnitOfSumOf1st3rd5th7th9thTimes8EqualTo11thNumber(value)){

                        int sum = calculateSumOf1st3rd5th7th9thTimes7(value) + calculateSumOf2nd4th6th8thTimes9(value);
                        String sumString = String.valueOf(sum);
                        String unitOfSum = sumString.substring(sumString.length()-1);

                        if(unitOfSum.equals(value.substring(value.length()-2,value.length()-1))){
                            return true;
                        }

                    }
                }
            }
        }

        return false;
    }

    private boolean isIt11characters(String value){
        if(value.length() == 11){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isAllDigit(String value){

        return value.matches("^\\d+$");
    }
    private static boolean isUnitOfSumOfFirst10EqualTo11thNumber(String value){
        int sum = 0;
        for(int i = 0; i < value.length()-1; i++){
            sum += Integer.valueOf(value.substring(i,i+1));

        }
        String unitOfSumOfFirst10 = String.valueOf(sum);
        unitOfSumOfFirst10 = unitOfSumOfFirst10.substring(unitOfSumOfFirst10.length()-1);
        value = value.substring(value.length()-1);
        if(unitOfSumOfFirst10.equals(value)){
            return true;
        }else{
            return false;
        }

    }
    private static boolean isUnitOfSumOf1st3rd5th7th9thTimes8EqualTo11thNumber(String value){
        int sum = 0;
        for(int i = 0 ; i < 9; i++){
            if(i % 2 == 0){
                sum += Integer.parseInt(value.substring(i,i+1));

            }
        }
        int sumTimes8 = sum * 8;
        String stringSumTimes8 = String.valueOf(sumTimes8);
        String unitOfSumTimes8 = stringSumTimes8.substring(stringSumTimes8.length()-1);
        String unitOfValue = value.substring(value.length()-1);

        if(unitOfSumTimes8.equals(unitOfValue)){
            return true;
        }else{
            return false;
        }



    }
    private static int calculateSumOf1st3rd5th7th9thTimes7(String value){
        int sum = 0;
        for(int i = 0; i < 9; i++ ){
            if(i % 2 == 0){
                sum += Integer.parseInt(value.substring(i,i+1));
            }
        }
        int sumTimes7 = sum*7;

        return sumTimes7;
    }
    private static int calculateSumOf2nd4th6th8thTimes9(String value){
        int sum = 0;
        for(int i = 1; i < 8; i++ ){
            if(i % 2 == 1){
                sum += Integer.parseInt(value.substring(i,i+1));
            }
        }
        int sumTimes7 = sum*9;

        return sumTimes7;
    }


}
