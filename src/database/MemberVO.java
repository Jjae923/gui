package database;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class MemberVO {
	// memberTBL 내용 담기
	private int no;
	private String name;
	private int age;
	private String gender;
}
