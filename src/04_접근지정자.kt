package ex4

// Kotlin
//  : Java 6 / 8

// kr.co.imguru.User
// package com.lge;
// class User { String name; }

// Java 9 -> module

// 접근 지정자
//  * field, method 지정하는 접근 레벨 지정자
//    private - package - protected - public

//  Java에서 default와 protected는 잘못 설계된 부분이 있습니다.
//   1) protected 필드를 같은 패키지에서는 바로 접근이 가능합니다.
//   2) package는 같은 패키지에서는 직접 접근이 가능하다.
//     : 악의적으로 같은 패키지를 만들면 접근할 수 있다.

//  Kotlin의 내부 접근 지정자(필드, 메소드)
//   private -> internal -> protected - public
//   => internal은 오직 같은 모듈에서만 접근이 가능합니다.
//      같은 패키지 명을 가지고 있어도, 접근할 수 없습니다.
//   => protected는 오직 자식 클래스를 통해서만 접근이 가능합니다.

// 외부 접근 지정자
//  public, private, internal

// 전역 클래스나 전역 함수에 private은 같은 파일에서만 접근이 가능합니다.
private class User
private fun foo() {

}

// 같은 모듈에서만 접근이 가능합니다.
internal class Car
















