# reuse
Java, Spring을 관통하는 키워드 중에 하나는 **코드의 재사용성**이다. 코드 재사용성은 어떻게 높일 수 있을까. 바로 코드 간에 **관계**를 맺어주는 것 자체가 코드의 재사용성을 높이는 일이다.  

코드 간의 관계에는 크게 2가지가 있는데 바로 수직 관계와 수평 관계이다. '수직 관계 = 상속 관계' 이고, 수평 관계에는 의존, 연관, 포함, 합성이 있지만 의존이 나머지를 전부 포함하는 개념이기 때문에 퉁쳐서 '수평 관계 = 의존 관계'라 부르기도 한다.  

그러나 상속은 결합도가 높다. 자식이 원하지 않는 부모의 멤버까지 전부 상속되기 때문이다. 그래서 '코드의 재사용성을 높이는 것 = 의존 관계를 맺어주는 것'이라 부를 수 있다.  

객체를 의존하는 방법에는 3가지가 있다. 첫번째는 가장 원시적인 방법인 'new로 직접 생성해서 사용하는 것'이다. 두번째는 그것보다 더 발전한 방법으로 보관소에 의존객체를 넣어두고 필요할때마다 꺼내 쓰는 방법이다. 이 방법은 첫번째 방법보다는 재사용성을 높였지만 여전히 보관소와 결합도가 높다. 보관소가 변경되면 보관소를 사용하는 모든 코드를 변경해야하기 때문이다.  

세번째 방법이 바로 의존성 주입이다. 다른 말로 전략 패턴이라고도 한다. 의존성 주입은 두번째 방법보다 재사용성이 높다. 외부에서 의존 객체를 생성해 내부로 주입하는 방식이다. 주입하는 통로에는 2가지가 있다. '필드 주입'과 '메서드 매개변수로 주입'이다. 하나의 메서드만 의존 객체를 사용할 경우 메서드 매개변수로 주입하면 되지만, 여러 메서드가 사용할 경우에는 필드로 주입하면 될 것이다.  

필드 주입의 통로에는 또 2가지가 있다. 바로 생성자 주입, 세터 주입이다. 생성자 주입의 장점은 의존 객체 주입 누락을 컴파일 단계에서 방지할 수 있다는 것이다. 왜냐하면 생성자는 매개변수가 누락되면 컴파일 에러가 발생하기 때문이다. 세터 주입의 단점은 세터의 존재 자체가 단점이다. 세터가 존재한다는 것의 의미는 언제나 값이 변경될 수 있는 가능성이 열려있다는 것이다. 그렇기 때문에 세터 자체를 남용하는 것을 권장하지 않는다.  

이때까지의 내용을 정리하자면, '코드의 재사용성을 높이는 것 = 의존 관계를 맺어주는 것'이고, 객체를 의존하는 방법 중에 가장 발전된 방법은 의존성 주입이며, 필드로 주입할시 가장 권장하는 방법은 생성자 주입이다.  

그러나 의존성 주입에도 한계가 있다. 의존성 주입은 의존 객체와의 결합도를 완전히 없애지 못한다. 의존성 주입은 단순히 new 연산자가 외부에 있는 것 뿐이기 때문이다. 의존 객체가 교체된다면 의존 객체를 사용하는 코드도 전부 변경해야한다.  

이를 해결해주는 것이 인터페이스이다. 인터페이스는 클래스 사용방법을 표준화하기 때문에 코드 재사용성을 높인다. 의존 객체를 사용하는 코드를 인터페이스를 사용하는 코드로 바꾼다면 추후에 의존 객체가 교체되었을때 코드를 전혀 건드리지 않아도 된다.  

정리하자면 인터페이스와 의존성 주입을 같이 사용해야만 결합도를 완전히 낮추어 독립적인 프로그래밍이 가능해진다.  

인터페이스 외에도 자바에는 코드 재사용성을 높일 수 있는 여러 문법들이 존재한다. 인스턴스 필드, 다형성, 제네릭이 그러하다. 이들을 사용하는 것 자체가 코드 재사용성을 높이는 일이다.  

- **인스턴스 필드**를 사용하지 않으면 같은 일을 하는 클래스임에도 다루는 필드가 다르다는 이유로 반복적으로 정의해야한다.
- **다형성**을 사용하지 않으면 같은 일을 하는 클래스임에도 다루는 객체 타입이 다르다는 이유로 반복적으로 정의해야한다.  
- **제네릭**을 사용하지 않고 코드의 타입 안정성을 높이려면 코드의 재사용성을 포기해야 한다.  

## 목표
1. 코드의 재사용성을 극대한다
2. OOP, 디자인 패턴 등을 하나씩 적용하면서 재사용성이 어떻게 좋아지는지, 또다른 이점은 있는지 기록한다.

## 재사용성을 높이는 방법
- [ ] 00. 코드의 재사용성을 높여야 하는 이유.
- [x] [01. 인스턴스 멤버를 사용하여 재사용성을 높인다(스태틱 멤버의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/01.%20%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4%20%EB%A9%A4%EB%B2%84%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EC%8A%A4%ED%83%9C%ED%8B%B1%20%EB%A9%A4%EB%B2%84%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [x] [02. 다형성을 사용하여 재사용성을 높인다(배열의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/02.%20%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%84%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EB%B0%B0%EC%97%B4%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [x] [03. 제네릭을 사용하여 재사용성과 타입 안정성을 높인다(다형성의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/03.%20%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%9D%84%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EA%B3%BC%20%ED%83%80%EC%9E%85%20%EC%95%88%EC%A0%95%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [ ] [04. 컬렉션 API를 사용하여 재사용성과 일관성을 높인다(인터페이스의 장점)](https://github.com/cgkim449/reuse/blob/master/documents/04.%20%EC%BB%AC%EB%A0%89%EC%85%98%20API%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EA%B3%BC%20%EC%9D%BC%EA%B4%80%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4%EC%9D%98%20%EC%9E%A5%EC%A0%90).md).
- [ ] 05. 의존성 주입을 사용하여 재사용성을 높인다(인터페이스의 한계).

## 기타
- [ ] 01. 생성자를 사용하는 이유
- [ ] 02. 캡슐화를 하는 이유
- [ ] 03. 클래스를 내부클래스로 선언하는 이유
