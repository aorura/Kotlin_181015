
// Program.java
// public class Program {
//   public static void main(String[] args) {
//      System.out.println("Hello, Java");
//   }
// }


// $ kotlinc Hello.kt -include-runtime -d Hello.jar
//  -> HelloKt.class
// $ kotlin HelloKt

// kotlin-runtime을 포함한다면, 자바 런타임을 통해 실행할 수 있다.
// $ java -jar Hello.jar

// Byte Code
//  : javap -c Hello.class
//--------------------

// 1. Compile
// 2. Script(Interpreter) => REPL(Read-Eval-Print-Loop) 도구
//   $ kotlinc-jvm -cp joda-time-2.10.jar

// 코틀린 언어 특징
// 1) 간결함
//   : 보일러플레이트를 효과적으로 제거합니다.
// 2) 안전함
//   : Optional, Nullable, Maybe
//   코틀린의 타입은 기본적으로 null을 담을 수 없습니다.
//   Nullable 타입은 null을 담을 수 있지만, 사용하기 전에
//   반드시 null이 아님을 검증해야 합니다.

// 3) 상호 운용성

fun main(args: Array<String>) {
    println("Hello, Kotlin")
}
















