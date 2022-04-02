package scalatips

/* 8 Pattern Matching Tricks you probably didn't know:
    https://rockthejvm.com/blog/8-special-patterns
*/
object EightPMTricks {

    // 1 - switch on steriods
    val aNumber = 44
    val ordinal = aNumber match {
        case 1 => "first"
        case 2 => "second"
        case 3 => "third"
        case _ => aNumber + "th"
    }

    // 2 - case class deconstruction
    case class Person(name: String, age: Int)
    val bob = Person("Bob", 34)

    val bobGreeting = bob match {
        case Person(n, a) => s"Hi, my name is $n and I an $a years old"
    }

    // trick #1 - list extractors
    val numberList = List(1,2,3,42)

    val mustHaveTree = numberList match {
        case List(_, _, 3, somethingElse) => s"List has 3rd element 3, so the 4th element is $somethingElse"
    }

    // trick #2 - Haskell-like prepending
    val startsWithOne = numberList match {
        case 1 :: tail => "list starts with one"
    }

    def main(args: Array[String]): Unit = {

    }
}