package Experiment.Experiment2;

public class Test1 {
  public static void main(String[] args) {
    pay pay = new pay();
    pay.computePayment(2.1);
    System.out.println(pay.getPayment());
    pay.computePayment(2.1, 0.11);
    System.out.println(pay.getPayment());
    pay.computePayment(2.1, 0.13, 0.2);
    System.out.println(pay.getPayment());
  }
}

class pay {
  private double price = 5;
  private double withhold_rate;
  private double pay_rate;
  private double payment;

  void computePayment(double hour, double pay_rate, double withhold_rate) {
    this.payment = hour * price * (1 - withhold_rate) * (1 - pay_rate);
  }

  void computePayment(double hour, double pay_rate) {
    this.withhold_rate = 0.15;
    this.payment = hour * price * (1 - this.withhold_rate) * (1 - pay_rate);
  }

  void computePayment(double hour) {
    this.withhold_rate = 0.15;
    this.pay_rate = 0.0465;
    this.payment = hour * price * (1 - this.withhold_rate) * (1 - this.pay_rate);
  }

  double getPayment() {
    return this.payment;
  }
}
