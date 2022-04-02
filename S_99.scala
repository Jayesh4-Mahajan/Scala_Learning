/* Going through 99 problems mentioned in http://aperiodic.net/phil/scala/s-99/ */

/*
P01 (*) Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
*/

object P01 {
  
  def last(x: List[Int]): Int = {
    return x.last;
  }
  
  def last2(x: List[Int]): Int = x.last;
  
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil   => h
    case _ :: tail  => lastRecursive(tail)
    case _          => throw new NoSuchElementException
  }
  
  def main(args: Array[String]): Unit = {
    var list = List(1, 1, 2, 3, 5, 8);
    println(last(list));
    println(last2(list));
    println(lastRecursive(list));
  }
}

// P02 (*) Find the last but one element of a list.
// Example:
// scala> penultimate(List(1, 1, 2, 3, 5, 8))
// res0: Int = 5

// object P03 {
  
  
  
//   def main(args: Array[String]): Unit = {
    
//   }
// }

object P02 {

    def penultimate(x: List[Int]): Int = {
      return x(x.length-2);
    }
    
    def penultimateBuiltin[A](ls: List[A]): A = {
      if (ls.isEmpty) throw new NoSuchElementException
      else ls.init.last
    }
  
    def penultimateRecursive[A](ls: List[A]): A = {
        ls match {
        case h :: _ :: Nil => h
        case _ :: tail => penultimateRecursive(tail)
        case _ => throw new NoSuchElementException
      }
    }
  
    // Generic lastNth function.
    def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
      if (n <= 0) throw new IllegalArgumentException
      if (ls.length < n) throw new NoSuchElementException
      return ls.takeRight(n).head
    }
  
    // def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    //   def lastNthR(count: Int, resultList: List[A], curList: List[A]): A = {
    //     return curList match {
    //       case Nil if count > 0 => throw new NoSuchElementException
    //       case Nil => resultList.head
    //       case _ :: tail => lastNthR(count - 1, if (count > 0) resultList else resultList.tail, tail)
    //     }
    //     if (n <= 0) throw new IllegalArgumentException
    //     else lastNthR(n, ls, ls)
    //   }
    // }
  
    def main(args: Array[String]): Unit = {
        val lst: List[Int] = List(1, 1, 2, 3, 5, 8);
        println(penultimate(lst));
        println(penultimateBuiltin(lst));
        println(penultimateRecursive(lst));
        println(lastNthBuiltin(2, lst));
        // println(lastNthRecursive(2, lst));
    }
}

// P03 (*) Find the Kth element of a list.
// By convention, the first element in the list is element 0.
// Example:

// scala> nth(2, List(1, 1, 2, 3, 5, 8))
// res0: Int = 2

object P03 {
  
  def getNthIndex[A](n: Int, ls: List[A]): A = {
    if (n < 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    return ls(n)
  }

  def nthRecursive[A](n: Int, ls: List[A]): A = {
    return (n, ls) match {
      case (0, h :: _ ) => h
      case (n, _ :: tail) => nthRecursive(n - 1, tail)
      case (_, Nil) => throw new NoSuchElementException
    }
  }
  
  def main(args: Array[String]): Unit = {
    val lst = List(1, 1, 2, 3, 5, 8);
    println(getNthIndex(2, lst));
    println(nthRecursive(2, lst));
  }
}