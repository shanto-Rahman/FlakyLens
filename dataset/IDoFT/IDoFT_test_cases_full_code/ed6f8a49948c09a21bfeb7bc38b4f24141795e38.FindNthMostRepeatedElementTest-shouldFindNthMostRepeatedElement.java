@Test public void shouldFindNthMostRepeatedElement(){
  int[] numbers={1,1,2,3,4,5,2,2,2,4,4,6,7,4,9,214,4,5};
  int result=findNthMostRepeatedElement.find(numbers,2);
  assertEquals(1,result);
}
