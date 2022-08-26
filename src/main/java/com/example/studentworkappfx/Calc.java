package com.example.studentworkappfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Calc {
    @FXML
    private Label result;

    private float number1=0;
    private float number2=0;
    private String operator="";
    private boolean start=true;
    private Calculate calculate=new Calculate();



    @FXML
    private Button add;

    @FXML
    private Button c;

    @FXML
    private Button cos;

    @FXML
    private Button divide;

    @FXML
    private Button equals;

    @FXML
    private Button ex;

    @FXML
    private Button ln;

    @FXML
    private Button log;

    @FXML
    private Button mod;

    @FXML
    private Button multiply;

    @FXML
    private Button num0;

    @FXML
    private Button num1;

    @FXML
    private Button num2;

    @FXML
    private Button num3;

    @FXML
    private Button num4;

    @FXML
    private Button num5;

    @FXML
    private Button num6;

    @FXML
    private Button num7;

    @FXML
    private Button num8;

    @FXML
    private Button num9;

    @FXML
    private Button point;

    @FXML
    private Button sin;

    @FXML
    private Button sqrt;

    @FXML
    private Button subtract;

    @FXML
    private Button tan;

    @FXML
    private Button x1;

    @FXML
    private Button x2;

    @FXML
    private Button x3;

    @FXML
    private Button xy;


    @FXML
    public void clickadd() {

        if(!result.getText().contains("+")&&!result.getText().contains("-")&&!result.getText().contains("*")&&!result.getText().contains("/")&&!result.getText().contains("%")){
            String adding = result.getText() + "+";
            result.setText(adding);
            operator = "+";
        }
    }
    @FXML
    public void clicksub() {

        if(!result.getText().contains("+")&&!result.getText().contains("-")&&!result.getText().contains("*")&&!result.getText().contains("/")&&!result.getText().contains("%")){
            String adding = result.getText() + "-";
            result.setText(adding);
            operator = "-";
        }

    }
    @FXML
    public void clickmult() {

        if(!result.getText().contains("+")&&!result.getText().contains("-")&&!result.getText().contains("*")&&!result.getText().contains("/")&&!result.getText().contains("%")){
            String adding = result.getText() + "*";
            result.setText(adding);
            operator = "*";
        }
    }
    @FXML
    public void clickdiv() {
        if(!result.getText().contains("+")&&!result.getText().contains("-")&&!result.getText().contains("*")&&!result.getText().contains("/")&&!result.getText().contains("%")){
            String adding = result.getText() + "/";
            result.setText(adding);
            operator = "/";
        }
    }

    @FXML
    public void clickC() {
        operator="";
        start=true;
        result.setText("");
    }
    @FXML
    public void clickex(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clicksqrt(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clicklog(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clicksin(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickln(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickcos(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickxy(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clicktan(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickx2(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickmod(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickx3(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }
    @FXML
    public void clickxexclaim(MouseEvent mouseEvent) {
        calculateAdvanced(mouseEvent);
    }

    @FXML
    public void clickequals() {
        String[] nums = result.getText().split("\\" + operator);
//        System.out.println(operator);
//        for(String a : nums){
//            System.out.println(a);
//        }
        number1 = Float.parseFloat(nums[0]);
        number2 = Float.parseFloat(nums[1]);
        System.out.println(number1 + " " + number2 + " " + operator);
        if(operator.equals("+")){
            result.setText(String.valueOf(number1 + number2));
        }else if(operator.equals("-")){
            result.setText(String.valueOf(number1 - number2));
        }else if(operator.equals("*")){
            result.setText(String.valueOf(number1 * number2));
        }else if(operator.equals("/")){
            result.setText(String.valueOf(number1 / number2));
        }


    }
    @FXML
    public void clickdot(ActionEvent actionEvent) {


    }
    @FXML
    public void click7(ActionEvent actionEvent) {
        String num7 = result.getText() + "7";
        result.setText(num7);
    }
    @FXML
    public void click0(ActionEvent actionEvent) {
        String num0 = result.getText() + "0";
        result.setText(num0);
    }
    @FXML
    public void click3(ActionEvent actionEvent) {
        String num3 = result.getText() + "3";
        result.setText(num3);
    }
    @FXML
    public void click2(ActionEvent actionEvent) {
        String num2 = result.getText() + "2";
        result.setText(num2);
    }
    @FXML
    public void click1(ActionEvent actionEvent) {
        String num1 = result.getText() + "1";
        result.setText(num1);
    }
    @FXML
    public void click6(ActionEvent actionEvent) {
        String num6 = result.getText() + "6";
        result.setText(num6);    }
    @FXML
    public void click5(ActionEvent actionEvent) {
        String num5 = result.getText() + "5";
        result.setText(num5);    }
    @FXML
    public void click4(ActionEvent actionEvent) {
        String num4 = result.getText() + "4";
        result.setText(num4);    }
    @FXML
    public void click9(ActionEvent actionEvent) {
        String num9 = result.getText() + "9";
        result.setText(num9);    }
    @FXML
    public void click8(ActionEvent actionEvent) {
        String num8 = result.getText() + "8";
        result.setText(num8);    }
    @FXML
    public void calculateBasicMath(MouseEvent event) {
        String value=((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            number1=Float.parseFloat(result.getText());
            result.setText("");
        }else{
            if(operator.isEmpty())
                return;
            number2=Float.parseFloat(result.getText());
            float output=calculate.calculateBasicMath(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator="";
        }
    }
    public void calculateAdvanced(MouseEvent event) {

        String value=((Button)event.getSource()).getText();
        if(!operator.isEmpty())
            return;
        operator = value;
        number1=Float.parseFloat(result.getText());
        result.setText("");
        float output=calculate.calculateAdvancedMath(number1,operator);
        result.setText(String.valueOf(output));
        operator="";
    }


    public void calculateMath(ActionEvent event){
        if(start){
            result.setText("");
            start=false;
        }
        String value=((Button)event.getSource()).getText();
        result.setText(result.getText()+ value);
    }

    public void ClearFunction(ActionEvent event){

    }
}


