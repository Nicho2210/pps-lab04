package tasks.adts

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:

    // Change assignment below: should probably define a case class and use it?
    type Complex = (Double, Double)
    def complex(re: Double, im: Double): Complex = (re, im)
    extension (c: Complex)
      def re(): Double = c match
        case Complex(r, _) => r
      def im(): Double = c match
        case Complex(_, i) => i
      def sum(other: Complex): Complex = complex(c.re() + other.re(), c.im() + other.im())
      def subtract(other: Complex): Complex = complex(c.re() - other.re(), c.im() - other.im())
      def asString(): String = c match
        case Complex(r, i) if r == 0 && i == 0 => "0.0"
        case Complex(r, i) if r == 0 && i > 0 => i + "i"
        case Complex(r, i) if r == 0 && i < 0 => "-" + -i + "i"
        case Complex(r, i) if i == 0 => "" + r
        case Complex(r, i) if i > 0 => r + " + " + i + "i"
        case Complex(r, i) if i < 0 => r + " - " + -i + "i"