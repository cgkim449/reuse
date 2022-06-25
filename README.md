# reuse
## 1. 의존 해야하는 이유
Java, Spring이 등장한 이유 자체가 **코드의 재사용성** 때문이다. 코드의 재사용성은 어떻게 높일 수 있을까. 바로 코드 간에 **관계**를 맺어주는 것 자체가 코드의 재사용성을 높이는 일이다.  

코드 간의 관계에는 2가지가 있다. 바로 수직 관계와 수평 관계이다. 수직 관계 = 상속 관계이다. 수평 관계에는 의존, 연관, 포함, 합성이 있지만, 의존이 나머지를 전부 포함하는 개념이기 때문에 퉁쳐서 수평 관계 = 의존 관계라 부르기도 한다.   

그러나 상속은 부모와 자식간의 결합도가 높다. 부모가 수정되면 자식도 그 영향을 받기 때문이다. 그래서 '코드 재사용성을 높이기 위해 코드 간에 관계를 맺는 것은 곧 **의존 관계를 맺는 것**'이라 보면 될 것이다.  

## 2. 의존 방법 3가지
의존 관계를 맺는 것, 즉, 객체를 의존하는 방법에는 3가지가 있다.  

첫번째 방법은 가장 원시적인 방법으로, '객체를 **직접 생성**해서 사용하는 방법'이다. 이 방법에는 다음 2가지 단점이 있다.  

- 단점1. 의존 객체와의 결합도가 높다.
- 단점2. 요청이 들어올때 마다 객체를 생성하여 가비지가 많이 생성되고, 경우에 따라 실행속도가 느려진다.  

두번째로 등장한 방법은 **보관소**를 이용하는 방법으로, 이 방법은 단점2를 해결한다. 객체를 하나 미리 생성하여 **보관소**에 넣어두고 필요할때마다 꺼내 쓰는 방법이다. 이 방법은 단점2를 해결하지만 단점1은 해결하지 못했다. 그리고 오히려 단점을 하나 더 추가한다.  

- 단점1. 의존 객체와의 결합도가 높다.
- ~~단점2. 요청이 들어올때 마다 객체를 생성하여 가비지가 많이 생성되고, 경우에 따라 실행속도가 느려진다.~~  
- 단점3. 보관소와의 결합도가 높다.

만약 보관소가 변경된다면 보관소를 사용하는 코드를 전부 바꿔줘야 하기 때문이다. (보관소도 의존 객체이다.)   

세번째로 등장한 방법이 바로 **DI**(**의존성 주입**)이다. DI는 일단 단점3을 해결한다. 보관소를 사용하는 코드를 아예 없애버리기 때문이다. 그러나 단점1은 완전히 해결하지 못한다(조금 해결하긴 했다. 객체 생성하는 코드를 외부에 두었기 때문에.).  

- 단점1. 의존 객체와의 결합도가 여전히 높다.
- ~~단점3. 보관소와의 결합도가 높다.~~

단점1을 완전히 해결하려면 어떻게 해야할까. 바로 **다형성**을 이용하면 된다. 다형성을 이용하면 의존 객체가 교체되더라도 의존 객체를 사용하는 코드는 전혀 수정하지 않아도 된다.  

- ~~단점1. 의존 객체와의 결합도가 여전히 높다.~~  

이제 모든 단점을 해결했다. 정리하면, 객체를 의존하는 가장 좋은 방법은 **DI와 다형성을 결합하는** 것이다.

### 2.1. 의존성 주입 방법 2가지
의존 객체를 주입하는 통로에는 2가지가 있다. '필드에 주입'과 '메서드 매개변수에 주입'이다. 만약 의존 객체를 사용하는 메서드가 단 하나 밖에 없다면 굳이 필드에 주입할 필요가 없을 것이다.  

필드 주입의 통로 또한 2가지가 있다. 바로 **생성자 주입**, **세터 주입**이다.  
 
생성자 주입의 장점은 의존 객체의 누락을 컴파일 단계에서 방지할 수 있다는 점이다. 왜냐하면 생성자는 매개변수가 누락되면 컴파일 에러가 발생하기 때문이다.  

세터 주입의 단점은 세터의 존재 자체가 단점이다. 세터가 존재한다는 것은 언제나 값이 변경될 수 있는 가능성이 열려있다는 것이기 때문이다. 그렇기 때문에 세터를 남용하는 것은 좋지 않다.  

정리하면, 생성자 주입은 의존 객체 주입 누락을 방지하고, 세터 주입의 단점을 갖지 않으므로 가장 좋은 방법이라 할 수 있다.

## 3. 의존 외에도 코드 재사용성을 높이는 방법
### 3.1. 자바를 사용한다.
인스턴스 필드, 다형성, 제네릭, 인터페이스 등을 사용하는 것 자체가 코드 재사용성을 높이는 일이다.  

- **인스턴스 필드**를 사용하지 않으면 같은 일을 하는 클래스임에도 다루는 필드가 다르다는 이유로 반복적으로 정의해야한다.

- **다형성**을 사용하지 않으면 같은 일을 하는 클래스임에도 다루는 객체 타입이 다르다는 이유로 반복적으로 정의해야한다.

- **제네릭**을 사용하지 않고 코드의 타입 안정성을 높이려면 코드의 재사용성을 포기해야 한다.

- **인터페이스**는 클래스 사용 방법을 표준화하기 때문에 코드의 재사용성을 높인다.

- **의존성 주입**과 다형성을 같이 사용해야만이 의존 객체와의 결합도를 완전히 낮출 수 있다.  

스태틱 필드의 한계 때문에 인스턴스 필드가 필요하고, 배열의 한계 때문에 다형성이 필요하고, 다형성의 한계 때문에 제네릭이 필요하고, 또 다형성의 한계 때문에 의존성 주입이 필요하다.  

### 3.2. 모듈화, 애노테이션을 사용한다.
- 다형성 + DI + 모듈화(.properties, .xml, .class 등)
- 다형성 + DI + 애노테이션

## 목표
1. 코드 재사용성을 높인다.
2. OOP, 디자인 패턴 등을 하나씩 적용하면서 재사용성이 어떻게 좋아지는지, 또다른 이점은 있는지 기록한다.

## 재사용성을 높이는 방법
- [ ] 00. 코드의 재사용성을 높여야 하는 이유.
- [x] [01. 인스턴스 멤버를 사용하여 재사용성을 높인다 (스태틱 멤버의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/01.%20%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4%20%EB%A9%A4%EB%B2%84%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EC%8A%A4%ED%83%9C%ED%8B%B1%20%EB%A9%A4%EB%B2%84%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [x] [02. 다형성을 사용하여 재사용성을 높인다 (배열의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/02.%20%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%84%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EB%B0%B0%EC%97%B4%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [x] [03. 제네릭을 사용하여 재사용성과 타입 안정성을 높인다 (다형성의 한계).](https://github.com/cgkim449/reuse/blob/master/documents/03.%20%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%9D%84%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EA%B3%BC%20%ED%83%80%EC%9E%85%20%EC%95%88%EC%A0%95%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%98%20%ED%95%9C%EA%B3%84).md)
- [ ] [04. 컬렉션 API를 사용하여 재사용성과 일관성을 높인다 (인터페이스의 장점)](https://github.com/cgkim449/reuse/blob/master/documents/04.%20%EC%BB%AC%EB%A0%89%EC%85%98%20API%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC%20%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%84%B1%EA%B3%BC%20%EC%9D%BC%EA%B4%80%EC%84%B1%EC%9D%84%20%EB%86%92%EC%9D%B8%EB%8B%A4(%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4%EC%9D%98%20%EC%9E%A5%EC%A0%90).md).
- [ ] 05. 의존성 주입을 사용하여 재사용성을 높인다 (다형성의 한계).

## 기타
- [ ] 01. 생성자를 사용하는 이유
- [ ] 02. 캡슐화를 하는 이유
- [ ] 03. 클래스를 내부클래스로 선언하는 이유
