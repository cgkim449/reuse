# reuse
Java를 관통하는 키워드 중에 하나는 **코드의 재사용성**이라고 생각합니다.  
코드 간의 관계를 맺어주는 것 자체가 코드의 재사용성을 높이는 일이기 때문입니다. 관계는 크게 수직관계, 수평관계로 나뉩니다. 수직관계는 상속관계이고, 수평관계는 의존, 연관, 포함, 합성관계가 있습니다.   

또한 인스턴스 필드, 다형성, 제네릭, 인터페이스, 의존성 주입은 모두 코드의 재사용성을 높이는 것이 목적입니다.  
**인스턴스 필드**를 사용하지 않으면 같은 일을 하는 클래스임에도 다루는 필드가 다르다는 이유로 반복적으로 정의해야합니다.  
**다형성**을 사용하지 않으면 같은 일을 하는 클래스임에도 다루는 객체 타입이 다르다는 이유로 반복적으로 정의해야합니다.  
**제네릭**을 사용하지 않고 코드의 타입 안정성을 높이려면 코드의 재사용성을 포기해야 합니다.  
**인터페이스**는 클래스 사용 방법을 표준화하기 때문에 코드의 재사용성을 높입니다.  
**의존성 주입**과 인터페이스를 같이 사용해야만이 독립적인 프로그래밍이 가능합니다.  

그래서 Java를 사용하는 목적 중에 하나는 코드의 재사용성을 극대화하는 것입니다.  

## 목표
1. 코드의 재사용성을 극대화합니다.
2. OOP, 디자인 패턴 등을 하나씩 적용하면서 재사용성이 어떻게 좋아지는지, 또다른 이점은 있는지 기록합니다.

## 재사용성을 높이는 방법
- [ ] 00. 코드의 재사용성을 높여야 하는 이유.
- [x] [01. 인스턴스 멤버를 사용하여 재사용성을 높인다(스태틱 멤버의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/01.%20%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4%20%EB%A9%A4%EB%B2%84%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EC%8A%A4%ED%83%9C%ED%8B%B1%20%EB%A9%A4%EB%B2%84%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [x] [02. 다형성을 사용하여 재사용성을 높인다(배열의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/02.%20%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%84%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EB%B0%B0%EC%97%B4%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [x] [03. 제네릭을 사용하여 재사용성과 타입 안정성을 높인다(다형성의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/03.%20%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%9D%84%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EA%B3%BC%20%ED%83%80%EC%9E%85%20%EC%95%88%EC%A0%95%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [ ] [04. 컬렉션 API를 사용하여 재사용성과 일관성을 높인다(인터페이스의 장점)](https://github.com/cgkim449/reuse/blob/master/documents/04.%20%EC%BB%AC%EB%A0%89%EC%85%98%20API%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EA%B3%BC%20%EC%9D%BC%EA%B4%80%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4%EC%9D%98%20%EC%9E%A5%EC%A0%90).md).
- [ ] 05. 의존성 주입을 사용하여 재사용성을 높인다(인터페이스의 한계).

## 기타
- [x] [01. 생성자를 사용하는 이유](https://github.com/cgkim449/reuse/blob/master/documents/99.%20%EC%83%9D%EC%84%B1%EC%9E%90%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%20%EC%9D%B4%EC%9C%A0.md)
- [x] [02. 캡슐화를 하는 이유](https://github.com/cgkim449/reuse/blob/master/documents/99.%20%EC%BA%A1%EC%8A%90%ED%99%94%EB%A5%BC%20%ED%95%98%EB%8A%94%20%EC%9D%B4%EC%9C%A0.md)
