package xyz.ourguide.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// 기존 안드로이드 프로젝트에서 코틀린 지원 추가
//   : gradle
//     : build.gradle - project
//          build.gradle - module

// 1. 프로젝트 레벨 build.gradle 파일의 classpath에 항목을 추가해주어야 합니다.
//   classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.71'

// 2. 모듈 레벨 build.gradle 파일에 코틀린 플러그인을 적용해야 합니다.
//   apply plugin: 'kotlin-android'

// 3. 의존성을 추가합니다.
//       implementation 'org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.2.71'

// 4. 소스 파일 분리합니다.
//    sourceSets {
//        main.java.srcDirs += 'src/main/kotlin'
//    }

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}