package bubble.test.ex00;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Dog {
	private String name; // 상태. 상태는 행위를 통해서 변경된다. 
}

public class LombokTest {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("토토");
		System.out.println(d.getName());
	}
}
