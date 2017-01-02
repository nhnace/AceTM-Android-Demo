# AceTM-Android-Demo
AceTM SDK를 적용하기 위한 데모 어플리케이션입니다.

## Project에 SDK 추가하는 방법  
* Project build.gradle 설정 
```groovy
buildscript {
    repositories {
        jcenter()
    }
    //... 생략 
}
```
* Application build.gradle 설정 
```groovy
dependencies {
    compile 'com.acecounter.android:acetm-release:1.0.0@aar'
    compile 'com.google.android.gms:play-services-basement:10.0.1’
    //play-services는 하위버젼 호환 가능(play-service는 없어도 문제는 없으나 Adid 수집을 위해 필요)
    //... 생략
}
```
## SDK 기본 설정 
* 인터넷 퍼미션 추가 (AndroidManifest.xml)
``` xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
```
* AceCounter SID 설정 (AndroidManifest.xml)
``` xml
<meta-data android:name="ACECOUNTER_SID" android:value=”100002" />
```
* Application Class 재정의 설정 (기존에 사용중인 Application 클래스가 있으면 해당 클래스 수정)
```java
public class AceTMApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AceTM.init(this); //super.onCreate();밑에 기입
    }
}
```
* Application 등록 (AndroidManifest.xml)
``` xml
<application
    android:name=". AceTMApplication "
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">
    <!--... 생략-->
</application>
```
* CPA 측정용 Deep-link 설정 : 앱 실행 시 랜딩 Activity 에 Intent filter 지정 (AndroidManifest.xml)
``` xml
<activity android:name=".activity.IntroActivity">
  <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
  </intent-filter>

  <intent-filter>
      <action android:name="android.intent.action.VIEW" />

      <category android:name="android.intent.category.DEFAULT" />
      <category android:name="android.intent.category.BROWSABLE" />

      <data
          android:host="open"
          android:scheme="ACE100078" />
      <!--[data android:scheme] 값은  “ACE” + SID  구성 입력. (중요: 반드시 대문자로 입력할것)-->
  </intent-filter>
</activity>
```

* 설정이 완료된 AndroidManifest.xml 
``` xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.acecounter.android.acetmtest">

    <uses-permission android:name="android.permission.INTERNET"></uses-permission>

    <application
        android:name="com.acecounter.android.acetmtest.AceTMApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name="com.acecounter.android.acetmtest.activity.MainActivity" />

        <activity android:name=".activity.HybridWebActivity" />

        <activity android:name=".activity.IntroActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

            <intent-filter>
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data
                    android:host="open"
                    android:scheme="ACE100078" />
            </intent-filter>
        </activity>

        <meta-data
            android:name="ACECOUNTER_SID"
            android:value="100078" />
            
    </application>
</manifest>
```
