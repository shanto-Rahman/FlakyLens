@Test public void testIncrementDecode(){
assertEquals("strVal1",bean2.getStrField());
Assert.assertEquals(TestBean2.Enum1.value1,bean2.getEnumField());
assertEquals(2.0,bean2.testBean.getFloatField(),0.0001);
assertArrayEquals(new int[]{3,4},bean2.getInts());
assertEquals(listOf("c","d"),bean2.testBean.getLinkedList1());
assertEquals("publicStrVal",bean2.testBean.publicStrField);
assertArrayEquals(new int[]{1,2,3,4},bean2.getInts());
assertEquals(listOf("a","b","c","d"),bean2.testBean.getLinkedList1());
}