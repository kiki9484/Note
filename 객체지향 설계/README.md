## 목차
### 패턴
- [설계 패턴의 분류](#설계-패턴의-분류)
- [설계 패턴의 구성요소](#설계-패턴의-구성요소)
### SOLID: 객체지향 설계 원리 중 중요한 다섯가지 원리
- [SRP(Single Responsibility Principle)](#srp-single-responsibility-principle-)
- [OCP(Open-Closed Principle)](#ocp-open-closed-principle-)
- [LSP(Liskov Substitution Principle)](#lsp-liskov-substitution-principle-)
- [ISP(Interface Segregation Principle)](#isp-interface-segregation-principle-)
- [DIP(Dependency Inversion Principle)](#dip-dependency-inversion-principle-)
### 기타 원리
- [변할 가능성이 높은 부분을 추상화해라](#변할-가능성이-높은-부분을-추상화해라)
- [구체적 타입에 의존하는 것이 아니라 추상 타입에 의존해라](#구체적-타입에-의존하는-것이-아니라-추상-타입에-의존해라)
- [느슨한 연결을 선호해라](#느슨한-연결을-선호해라)
- [최소 지식 원리(데메테르 규칙)](#최소-지식-원리(데메테르-규칙))
- [상속 관계보다 포함 관계를 선호해라](#상속-관계보다-포함-관계를-선호해라)
- [할리우드 원칙](#할리우드-원칙)
<hr/>

### 패턴
- [1. Strategy Pattern](https://github.com/kiki9484/Note/tree/main/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%20%EC%84%A4%EA%B3%84/Strategy%20Pattern)
- [2. Observer Pattern](https://github.com/kiki9484/Note/tree/main/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%20%EC%84%A4%EA%B3%84/Observer%20Pattern)
<hr/>

#### 설계 패턴의 분류
* 생성(creational)
  + 객체의 생성과 관련되어 있다.
  + 생성하는 객체의 구체적인 클래스와 이들의 생성 방법을 추상화해준다.
* 행위(behaviroal)
  + 객체와 객체 간 상호작용과 관련되어 있다.
  + 객체 간의 상호작용을 효과적으로 할 수 있도록 해준다. 보통 포함 관계를 많이 활용한다.
* 구조(structural)
  + 객체 간에 정적인 구조적 관계와 관련되어 있다.
  + 클래스나 객체를 조합해 더 큰 구조를 만드는 패턴이다.
<hr/>

#### 설계 패턴의 구성요소
* 패턴의 이름
* 패턴의 분류: 생성, 행위, 구조 중 어디에 해당하는지 제시된다.
* 패턴의 목적: 패턴을 사용하는 이유가 제시된다.
* 패턴의 수준: 패턴이 적용되는 범위의 크기를 말한다.
* 패턴의 적용: 패턴을 유용하게 적용할 수 있는 설계 문제나 상황이 제시된다.
* 패턴의 참여자: 패턴에 등장하는 클래스와 객체들과 그들의 역할이 제시된다.
* 패턴의 구조: 참여자 간 클래스 관계도가 제시된다.
* 참여자 간 협력: 패턴에 등장하는 클래스와 객체들이 어떻게 상호작용하는지 제시된다.
* 패턴의 구현: 실제 적용 예를 코드 수준에서 제시한다.
* 패턴의 장단점
* 패턴의 변형
* 관련 패턴: 함께 사용하는 패턴이나 유사한 패턴을 제시한다.
<hr/>

#### SRP(Single Responsibility Principle)
단일 책임 원칙: A class should have only one reason to change.   
* 한 클래스는 여러 맴버 변수를 유지할 수 있고, 여러 메소드를 가질 수 있지만 SRP에 의해 이들은 모두 공통으로 한 가지 책임을 위해 필요해야 한다. 즉, 응집성이 높아야 한다.
* 한 클래스는 수정되어야 할 이유가 하나 밖에 없어야 한다.
<hr/>

#### OCP(Open-Closed Principle)
열림 닫힘 원리: Classes should be open for extension, but closed for modification
* 클래스는 확장에 대해서 열려 있지만 변화에 대해서는 닫혀 있어야 한다.
* 클래스가 새 기능이 필요하더라도 기존의 클래스를 수정하지 않고, 기능을 추가할 수 있어야 한다.
* 닫혀 있는 클래스를 확장하는 방법
  + 상속: 한 클래스를 상속하여 필요한 상태와 기능을 추가할 수 있다. 하지만, is-a관계가 성립해야 하며 클래스 간의 관계가 고정되지 때문에 유연하지 않다.
  + 포함 관계: 클래스의 어떤 기능을 다른 클래스에 위임하고, 그 클래스의 객체를 상위 타입 맴버 변수에 유지하면 구체화한 객체를 바꾸어 기능을 바꿀 수 있다. 이처럼 구체적인 클래스 대신에 추상 타입에 의존함에 따라 유연한 관계를 설계할 수 있게 된다.
<hr/>

#### LSP(Liskov Substitution Principle)
리스코프 치환 원리: If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without altering any of the desirable properties of that program.
* 상속을 통해 상위 타입에 다양한 종류의 객체를 유지할 수 있고, 이를 이용해 다형성을 활용하는 범용 프로그래밍이 가능하다.
* 하지만 상속은 반드시 is-a 관계가 성립하는 경우에만 사용해야 한다. 이 때, is-a 관계가 성립한다고 무조건 상속을 사용하는 것이 아니라 개발하는 프로그램의 설계에 맞을 경우에만 사용하는 것이 좋다.
* subclassing도 subtyping을 제공해야 한다.
  + subclassing: 한 클래스의 내부 구현을 재사용하는 것
  + subtyping: 외부 구현만 재사용하는 것
* 반변성과 공변성
  + 반변성: 자식 클래스에서 메소드를 재정의할 때 타입 일반화하는 경우
  + 공변성: 자식 클래스에서 메소드를 재정의할 때 특정 타입이 특수화되는 경우
* 상속에서 LSP를 위배하지 않도록 프로그래밍 언어는 다음을 보장해준다.
  + 메소드 인자의 반변성: 자식 클래스에서 메소드를 재정의할 때 메소드 매개변수의 타입이 더 일반화되는 것은 가능하다.
  + 메소드 반환타입의 공변성: 자식 클래스에서 메소드를 재정의할 때 반환 타입이 더 특수화되는 것은 가능하다.
  + 자식 메소드가 더 많은 종류의 예외를 발생시킬 수 없음
* 논리적 측면에서의 LSP
  + 메소드의 사전 조건이 강화되지 않아야 한다.
  + 메소드의 사후 조건이 약화되지 않아야 한다.
  + 상위 타입의 불변 조건이 계속 유지되어야 한다.
* 상속으로 모델링하고자 할 때, LSP를 위반할 경우 고려해볼 해결책
  + 방법 1. 부모 자식 간이 아니라 형제 클래스로 모델링
  + 방법 2. 상속으로 모델링하고 필요한 조치를 함
  + 방법 3. 포함 관계 활용
<hr/>

#### ISP(Interface Segregation Principle)
인터페이스 분리 원칙: Clients should not be forced to depend upon interfaces that they do not use.
* 클래스는 자신이 필요로 하지 않는 메소드를 구현하거나 강요되지 말아야 한다.
* 클래스나 interface가 제공하는 메소드의 수는 최소화되어야 한다.
* interface A에 f라는 메소드가 선언되어 있다. 이 interface를 구현하는 여러 클래스 중 대부분이 g라는 메소드를 필요로 한다. X가 메소드 g가 필요로 하는 클래스이고, Y는 메소드 g가 필요 없는 A를 구현하고 있는 클래스라고 하자.
  + 방법 1. A를 상속하는 새 interface B를 정의하고 B에 메소드 g를 선언한다. X는 interface B를 구현하고, Y는 수정없이 사용한다.
  + 방법 2. 새 interface B를 정의하고 B에 g를 선언한다. X는 interface B를 추가 구현하고, Y는 수정 없이 사용한다.
* 방법 2는 메소드 f와 메소드 g가 동시에 필요한 타입이 많지 않으므로, 방법 1이 ISP 측면에서 더 바람직하다.
<hr/>

#### DIP(Dependency Inversion Principle)
의존관계 뒤집기 원리: Depend upon abstractions. Do not depend on concrete classes.   
* 한 클래스 A는 구현할 때 다른 클래스 B를 사용하면 A는 B에 의존한다고 한다. 
* DIP 원리는 의존을 하더라도 구체적인 클래스 대신에 상위 추상 타입이나 interface에 의존해야 한다는 원리이다.
 + 구체적인 클래스를 직접 참조하는 것이 있으면 간접 참조하도록 바꾸어야 한다.
 + 구체적인 클래스의 행위들을 추상 클래스나 interface로 일반화해야 한다.
 + 상속 대신에 포함 관계를 활용해야 한다.
* 의존관계 뒤집기를 하기 위해서는 무엇을 할 것인지를 결정하는 부분과 언제할 것인지를 결정하는 부분을 분리하고, 서로 모르게 해야 한다.
* 관계를 클래스를 정의할 때 고정하는 것이 아니라 객체를 생성할 때 관계를 맺을 수 있도록 하는 것을 관계주입(DIP)라고 한다.
<hr/>

### 기타 원리

#### 변할 가능성이 높은 부분을 추상화해라
Identify the aspects of your application that vary and separate them from what stays the same.

#### 구체적 타입에 의존하는 것이 아니라 추상 타입에 의존해라
Program to an interface, not an implementation.

#### 느슨한 연결을 선호해라
Strive for loosely coupled designs between objects that interact.

#### 최소 지식 원리(데메테르 규칙)
Talk only to your immediate friends
* 규칙 1. 클래스 O에 정의되어 있는 메소드 m은 클래스 O에 있는 다른 메소드를 호출할 수 있다.
* 규칙 2. 메소드 m은 그것의 인자 객체의 메소드를 호출할 수 있다.
* 규칙 3. 메소드 m 내에서 어떤 객체 o를 생성하였으면 그 객체의 메소드는 호출할 수 있다.
* 규칙 4. 클래스 O가 다른 타입의 객체 o를 맴버 변수로 유지하고 있으면 O의 객체의 메소드에서 o의 메소드를 호출할 수 있다.

#### 상속 관계보다 포함 관계를 선호해라
Favor composition over inheritance.
* 상속 관계는 클래스 간 관계이며 정적 관계이다. 상속은 is-a 관계가 성립할 경우에만 사용해야 하며, LSP에 위배되지 않아야 한다. 클래스 간 관계이기 때문에 관계가 형성되면 코드 수정 없이는 관계가 지속된다.
* 포함 관계는 객체 간 관계이며 동적 관계이기 때문에 유연하다. 실행 시간에 참조하는 객체를 바꾸어 기능을 동적으로 바꿀 수 있다. 그렇기 때문에 포함 관계는 느슨한 결합에 해당하는 관계다.

#### 할리우드 원칙
Don't call us, we'll call you.
* 하위 수준 요소는 상위 수준 요소와 연결되어 동작할 수 있지만 상위 수준 요소가 언제 어떻게 하위 수준 요소를 사용할지 결정한다.
* 하위 수준 요소는 절대 상위 수준 요소를 직접 호출하지 않아야 한다.
* 여기서 말하는 상위 수준 요소와 하위 수준 요소는 상속 관계에서 조상과 후손에 해당하는 것이 아니다. 추상화되어 있는 요소이면 상위 수준의 요소이고, 구체적인 것이면 하위 수준 요소에 해당한다. 


