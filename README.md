# AceCounter+ Android SDK
AceCounter+ 분석 서비스를 사용하기 위한 Android SDK 입니다.
* [상세 가이드 바로가기]()

# 간편 시작하기
AceCounter+를 가장 쉽게 이용하는 방법입니다.  

`AceTM-1.0.8.aar` 모듈 추가하기 :
```
/lib/AceTM-1.0.8.aar
```

AndroidManifest.xml 에 `Application class` 추가 하기 :
```java
<application android:name=".MyApplication"/>
```

Application 클래스에서 `초기화`하기 :
```java
public class MyApplication extends Application {
  @Override 
  public void onCreate() {
    AceConfiguration aceConfiguration = new AceConfiguration(this);
    aceConfiguration.setServiceId(R.string.acecounter_sid);
    aceConfiguration.setAutoPageView(true);
    AceTM.initialize(aceConfiguration);
  }
}
```
고객 아이디 보호를 위해 **ServiceId**는 `res/string`을 사용하실 것을 권장 해드립니다.

# FAQ
* [데이터 수집이 정상적으로 이루어지는지 확인하고 싶습니다.]()
* [데이터 수집이 안됩니다.]()
* [예전 버전(1.0.7 이하)을 사용하고 있습니다. 계속 사용해도 될까요??]()