### 연관된 패턴

- Abstract Factory: Factory Method 를 통해 구현될 때가 많음
- Template Method: 템플릿 메서드 패턴에서도 사용될 때가 많음

### 정의

객체의 생성 과정을 하위 클래스에 위임, 객체를 생성하는 인터페이스만 정의하고 실제 인스턴스 생성은 서브클래스에서 수행. 상위 클래스에서는 객체를 생성하는 메서드의 구조만 정의하고, 하위 클래스에서 실제 객체를 반환하도록 함.

### 구성요소
- Product: 생성될 객체의 인터페이스를 정의.
- ConcreteProduct: 실제 생성될 객체의 구현체.
- Creator (Factory Method를 가진 클래스): 객체를 반환하는 Factory Method를 선언. 
- ConcreteCreator: Factory Method를 오버라이딩하여 특정 Product 객체를 생성하는 클래스. 

### Pros & Cons
- 클라이언트가 직접 객체를 생성하는 대신, 서브클래스에서 원하는 객체를 반환.
- 새로운 Product를 추가할 때, 기존 코드 수정 없이 새로운 ConcreteCreator를 추가하면 됨.
- 객체 생성의 책임이 Factory Method를 가진 클래스로 이동함으로써, 클라이언트가 특정 구현을 직접 알 필요 없음.
- 단 하나의 ConcreteProduct를 생성하기 위해 새로운 ConcreteCreator를 만들어야 할 수 있음.
- 구체적인 인스턴스 생성은 서브클래스에서 결정.
- Creator 가 추상클래스일 수도 있고, 구현클래스로 기본 매서드를 구현할 수 있음
  - 선택적으로 override 할 수 있는 hook 매서드를 제공한다고도 하는데 동일한 의미인가 싶음.
