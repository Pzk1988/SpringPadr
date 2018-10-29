package com.example.demo;

import com.example.demo.models.PasswordValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.DatatypeConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void GenerateMd5FromPasswordAndSeed() {
		PasswordValidator passwordValidator = new PasswordValidator();
		byte[] digest = passwordValidator.GenerateHash("pass", "ffffffffffeeeeeeeeeecccccccccc55");
		System.out.println(DatatypeConverter.printHexBinary(digest));
		Assert.assertEquals("D21F12D84CA7DD65D04DA33F631ABC70", DatatypeConverter.printHexBinary(digest));
	}


	@Test
	public void GenerateSeed(){

		PasswordValidator passwordValidator = new PasswordValidator();
		byte[] firstSeed;
		byte[] secondSeed;

		for(int i = 0; i < 50; i++){
			firstSeed = passwordValidator.GenerateSeed();
			secondSeed = passwordValidator.GenerateSeed();

			Assert.assertEquals(16, firstSeed.length);
			Assert.assertEquals(16, secondSeed.length);
			Assert.assertNotEquals(firstSeed, secondSeed);
		}
	}

}
