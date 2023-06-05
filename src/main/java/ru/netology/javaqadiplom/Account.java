package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    // конструктор, принимающий начальный баланс счета
    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
