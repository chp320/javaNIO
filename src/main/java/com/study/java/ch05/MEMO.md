# 문자 스트림
## 문자 단위 IO 클래스 (문자 단위 입출력 클래스)
### Reader, Writer
- 문자 단위 입출력 스트림에서 가장 기본이 되는 클래스로 모두 '추상 클래스'임.
- 추상 클래스는 객체화가 불가하므로 Reader, Writer 클래스도 '객체화가 불가' 하지만 다음과 같이 사용 가능

``` java
Reader r = new FileReader("a.txt");
```
