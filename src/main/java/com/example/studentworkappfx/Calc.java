package com.example.studentworkappfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Calc {
    @FXML
    private Label result;
    private float number1 = 0;
    private float number2 = 0;
    private String operator = "";
    private boolean start = true;


    @FXML
    public void click0(ActionEvent actionEvent) {
        String num0 = result.getText() + "0";
        result.setText(num0);
    }

    @FXML
    public void click1(ActionEvent actionEvent) {
        String num1 = result.getText() + "1";
        result.setText(num1);
    }

    @FXML
    public void click2(ActionEvent actionEvent) {
        String num2 = result.getText() + "2";
        result.setText(num2);
    }

    @FXML
    public void click3(ActionEvent actionEvent) {
        String num3 = result.getText() + "3";
        result.setText(num3);
    }

    @FXML
    public void click4(ActionEvent actionEvent) {
        String num4 = result.getText() + "4";
        result.setText(num4);
    }

    @FXML
    public void click5(ActionEvent actionEvent) {
        String num5 = result.getText() + "5";
        result.setText(num5);
    }

    @FXML
    public void click6(ActionEvent actionEvent) {
        String num6 = result.getText() + "6";
        result.setText(num6);
    }

    @FXML
    public void click7(ActionEvent actionEvent) {
        String num7 = result.getText() + "7";
        result.setText(num7);
    }

    @FXML
    public void click8(ActionEvent actionEvent) {
        String num8 = result.getText() + "8";
        result.setText(num8);
    }

    @FXML
    public void click9(ActionEvent actionEvent) {
        String num9 = result.getText() + "9";
        result.setText(num9);
    }

    @FXML
    public void clickadd() {
        if (!result.getText().contains("+") && !result.getText().contains("-") && !result.getText().contains("*") && !result.getText().contains("/") && !result.getText().contains("%")) {
            String adding = result.getText() + "+";
            result.setText(adding);
            operator = "+";
        }
    }

    @FXML
    public void clicksub() {
        if (!result.getText().contains("+") && !result.getText().contains("-") && !result.getText().contains("*") && !result.getText().contains("/") && !result.getText().contains("%")) {
            String adding = result.getText() + "-";
            result.setText(adding);
            operator = "-";
        }

    }

    @FXML
    public void clickmult() {
        if (!result.getText().contains("+") && !result.getText().contains("-") && !result.getText().contains("*") && !result.getText().contains("/") && !result.getText().contains("%")) {
            String adding = result.getText() + "*";
            result.setText(adding);
            operator = "*";
        }
    }

    @FXML
    public void clickdiv() {
        if (!result.getText().contains("+") && !result.getText().contains("-") && !result.getText().contains("*") && !result.getText().contains("/") && !result.getText().contains("%")) {
            String adding = result.getText() + "/";
            result.setText(adding);
            operator = "/";
        }
    }

    @FXML
    public void clickdot() {
        String dot = result.getText() + ".";
        result.setText(dot);


    }

    @FXML
    public void clickC() {
        operator = "";
        start = true;
        result.setText("");
    }

    @FXML
    public void clicksqrt() {
        if (result.getText().length() > 0) {
            StringBuffer sb = new StringBuffer(result.getText());
            sb = sb.deleteCharAt(result.getText().length() - 1);
            result.setText(sb.toString());
        }
    }


    @FXML
    public void clickequals() {
        String[] nums = result.getText().split("\\" + operator);

        number1 = Float.parseFloat(nums[0]);
        number2 = Float.parseFloat(nums[1]);
        System.out.println(number1 + " " + number2 + " " + operator);
        if (operator.equals("+")) {
            result.setText(String.valueOf(number1 + number2));
        } else if (operator.equals("-")) {
            result.setText(String.valueOf(number1 - number2));
        } else if (operator.equals("*")) {
            result.setText(String.valueOf(number1 * number2));
        } else if (operator.equals("/")) {
            result.setText(String.valueOf(number1 / number2));
        }


    }
}


