package com.example;

/**
 * Created by margaret on 9/11/16.
 */
public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numer, int denom) {
        numerator = numer;
        denominator = denom;
    }

    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public static int gcd(int m, int n) {
        int hi;
        int lo;
        if (m == n) {
            return m;
        } else {
            if (m > n) {
                hi = m;
                lo = n;
            } else {
                hi = n;
                lo = m;
            }
            if (lo == 0){
            return hi;}
            else{
            return gcd(lo, hi % lo);}}
        }

    public void simplify() {
        int divisor = gcd(numerator, denominator);
        numerator = numerator/divisor;
        denominator = denominator/divisor;
    }

    public Fraction add(Fraction that) {
        int unsimpnum = this.numerator*that.getDenominator() + that.getNumerator()*this.denominator;
        int unsimpdenom = this.denominator * that.getDenominator();
        int divisor = gcd(unsimpnum, unsimpdenom);

        return new Fraction(unsimpnum/divisor, unsimpdenom/divisor);
    }
    }

