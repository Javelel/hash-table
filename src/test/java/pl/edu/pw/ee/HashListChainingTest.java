package pl.edu.pw.ee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashListChainingTest {

	@Before
	public void setUp() {
	}

	@Test
	public void shouldCreateHashList() {
		HashListChaining<Double> hashList = new HashListChaining<>(7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sizeOfHashListCannotBeLessThanOne() {
		HashListChaining<Double> hashList = new HashListChaining<>(0);
	}

	@Test
	public void shouldAddElementWhenHashIsEmpty() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		Double expected = 1.1;
		//when
		hashList.add(1.1);
		Double result = hashList.get(1.1);
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void shouldAddElementWhenHashIsNotEmpty() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(7);
		Double expected = 9.9;
		//when
		hashList.add(1.1);
		hashList.add(2.9);
		hashList.add(9.9);
		hashList.add(1.3);
		Double result = hashList.get(9.9);
		//then
		Assert.assertEquals(expected, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addedElementCannotBeNull() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		//when
		hashList.add(null);
		//then
		assert true;
	}

	@Test(expected = IllegalArgumentException.class)
	public void ReceivedElementCannotBeNull() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		//when
		hashList.get(null);
		//then
		assert true;
	}

	@Test(expected = IllegalArgumentException.class)
	public void deletedElementCannotBeNull() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		//when
		hashList.delete(null);
		//then
		assert true;
	}

	@Test
	public void shouldDeleteFirstElementFromTheList() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		hashList.add(3.5);
		hashList.add(4.6);
		hashList.add(1.1);
		Double expected = null;
		//when
		hashList.delete(1.1);
		//then
		Assert.assertEquals(expected, hashList.get(1.1));
	}

	@Test
	public void shouldDeleteMiddleElementFromTheList() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		hashList.add(3.5);
		hashList.add(4.6);
		hashList.add(1.1);
		Double expected = null;
		//when
		hashList.delete(4.6);
		//then
		Assert.assertEquals(expected, hashList.get(4.6));
	}

	@Test
	public void shouldDeleteLastElementFromTheList() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		hashList.add(3.5);
		hashList.add(4.6);
		hashList.add(1.1);
		Double expected = null;
		//when
		hashList.delete(3.5);
		//then
		Assert.assertEquals(expected, hashList.get(3.5));
	}

	@Test
	public void shouldPassWhenListDoesntContainElementToDelete() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		hashList.add(3.5);
		hashList.add(4.6);
		hashList.add(1.1);
		//when
		hashList.delete(0.0);
		//then
		assert true;
	}

	@Test
	public void shouldPassWhenListIsEmptyWhileDeleting() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		//when
		hashList.delete(0.0);
		//then
		assert true;
	}

	@Test
	public void shouldPassWhenElementIsAlreadyDeleted() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		hashList.add(3.5);
		hashList.add(4.6);
		hashList.add(1.1);
		Double expected = null;
		//when
		hashList.delete(1.1);
		hashList.delete(1.1);
		//then
		Assert.assertEquals(expected, hashList.get(1.1));
	}

	@Test
	public void shouldAddElementAfterAddingAndDeletingIt() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		hashList.add(3.5);
		hashList.delete(3.5);
		Double expected = 3.5;
		//when
		hashList.add(3.5);
		//then
		Assert.assertEquals(expected, hashList.get(3.5));
	}

	@Test
	public void numOfElementsShouldIncreaseAfterAddingElement() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		Double expected = 4.0;
		//when
		hashList.add(1.1);
		hashList.add(2.9);
		hashList.add(9.9);
		hashList.add(1.3);
		Double result = hashList.countLoadFactor();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void numOfElementsShouldNotIncreaseAfterAddingExistingElement() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		Double expected = 3.0;
		//when
		hashList.add(1.1);
		hashList.add(2.9);
		hashList.add(9.9);
		hashList.add(9.9);
		Double result = hashList.countLoadFactor();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void numOfElementsShouldDecreaseAfterDeletingElement() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		Double expected = 2.0;
		//when
		hashList.add(1.1);
		hashList.add(2.9);
		hashList.add(9.9);
		hashList.delete(9.9);
		Double result = hashList.countLoadFactor();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void numOfElementsShouldNotChangeAfterDeletingNotExistingElement() {
		//given
		HashListChaining<Double> hashList = new HashListChaining<>(1);
		Double expected = 3.0;
		//when
		hashList.add(1.1);
		hashList.add(2.9);
		hashList.add(9.9);
		hashList.delete(3.3);
		Double result = hashList.countLoadFactor();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void shouldWorkWithStrings() {
		//given
		HashListChaining<String> hashList = new HashListChaining<>(1);
		hashList.add("wrew");
		hashList.add("aasa");
		hashList.add("tr");
		String expected = "aasa";
		//when
		hashList.delete("wrew");
		//then
		Assert.assertEquals(expected, hashList.get("aasa"));
	}

	@Test
	public void shouldWorkWithBigSetOfData() {
		//given
		HashListChaining<Integer> hashList = new HashListChaining<>(1000000);
		//when
		for (int i = 0; i < 1000000; i++) {
			hashList.add(i);
		}
		//then
		for (int i = 0; i < 1000000; i++) {
			Assert.assertEquals(Integer.valueOf(i), hashList.get(i));
		}
	}

	@Test
	public void countLoadFactorShouldWorkWhenHashListIsSmallerThanNumberOfElements() {
		//given
		HashListChaining<Integer> hashList = new HashListChaining<>(4);
		for (int i = 0; i < 10; i++) {
			hashList.add(i);
		}
		Double expected = 2.5;
		//when
		Double result = hashList.countLoadFactor();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void countLoadFactorShouldWorkWhenHashListIsBiggerThanNumberOfElements() {
		//given
		HashListChaining<Integer> hashList = new HashListChaining<>(10);
		for (int i = 0; i < 4; i++) {
			hashList.add(i);
		}
		Double expected = 0.4;
		//when
		Double result = hashList.countLoadFactor();
		//then
		Assert.assertEquals(expected, result);
	}

}
