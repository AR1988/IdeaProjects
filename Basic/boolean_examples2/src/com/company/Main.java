package com.company;

public class Main {

    public static void main(String[] args) {

        double mariaSpeed = 1;
        double petjaSpeed = mariaSpeed * 0.8;
        double vasjaSpeed = mariaSpeed * 0.5;

        int totalYearPlan = 1150;

        int mariaGet450 = 450;
        int mariaGet500 = 500;

        double planTogether1 = mariaGet450 * mariaSpeed + mariaGet450 * petjaSpeed + mariaGet450 * vasjaSpeed;
        double planTogether2 = mariaGet500 * mariaSpeed + mariaGet500 * petjaSpeed + mariaGet500 * vasjaSpeed;

        if (planTogether1 >= (totalYearPlan * 0.8)) {
            vasjaSpeed = mariaSpeed;
            double result450 = planTogether1 + (mariaGet450 * vasjaSpeed) * 0.2;
            System.out.println("If Maria has 450 kredits, when they have together: " + result450 + " kredits");

            double isPlanExecuted1 = (result450 * 100) / totalYearPlan;

            if (isPlanExecuted1 >= 100) System.out.println("Plan executed on " + isPlanExecuted1 + "%");
            else System.out.println("Plan is not executed. It is executed just: " + isPlanExecuted1 + "%");
        }

        System.out.println(" ");

        if (planTogether2 >= (totalYearPlan * 0.8)) {
            vasjaSpeed = mariaSpeed;
            double result500 = planTogether2 + (mariaGet500 * vasjaSpeed) * 0.2;
            System.out.println("If Maria has 500 kredits, when they have together: " + result500 + " kredits");

            double isPlanExecuted2 = (result500 * 100) / totalYearPlan;

            if (isPlanExecuted2 >= 100) System.out.println("Plan executed on " + isPlanExecuted2 + "%");
            else System.out.println("Plan is not executed. It is executed just: " + isPlanExecuted2 + "%");
        }
    }
}
