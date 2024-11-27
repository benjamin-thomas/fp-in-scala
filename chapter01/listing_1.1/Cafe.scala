/*

scala-cli run --watch ./chapter01/listing_1.1/Cafe.scala

---

Example of a program demonstrating "hard to test" side effects:

Examples of actions that could happen when charging:
  - contacting the credit card company
  - authorizing the transaction
  - charging the card
    - if successful, persist a record of the transaction for later reference

 */

class Cafe:
  def buyCoffee(cc: CreditCard): Coffee =
    val cup = Coffee()
    cc.charge(cup.price)
    cup

class CreditCard:
  def charge(price: Double): Unit =
    println("Charging: " + price)

class Coffee:
  val price: Double = 2.0

object Main {
  def clearScreen(): Unit =
    print("\u001b[2J")

  def main(args: Array[String]): Unit =
    clearScreen()

    val cafe = Cafe()
    val cc = CreditCard()
    val cup = cafe.buyCoffee(cc)
    printf("Enjoy your coffee! (price was: %.2f)\n", cup.price)
}
