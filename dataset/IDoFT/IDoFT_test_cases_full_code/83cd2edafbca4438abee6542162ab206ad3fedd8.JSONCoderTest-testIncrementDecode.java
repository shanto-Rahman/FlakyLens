@Test public void testIncrementDecode(){
  String jsonStr1="{strField: 'strVal1', testBean: {floatField: 1.0, dateField: '2017-10-1', linkedList1: [a,b]}, ints:[1,2]}";
  String jsonStr2="{enumField: 'value1', testBean: {floatField: 2.0, publicStrField: 'publicStrVal', linkedList1: [c,d]}, ints:[3,4]}";
  TestBean2 bean2=JSONCoder.global.decode(jsonStr1,TestBean2.class);
  bean2=JSONCoder.global.decodeTo(jsonStr2,bean2);
  assertMatchesSnapshot("withoutMergeArrayOption",toJSONString(bean2));
  assertEquals("strVal1",bean2.getStrField());
  Assert.assertEquals(TestBean2.Enum1.value1,bean2.getEnumField());
  assertEquals(2.0,bean2.testBean.getFloatField(),0.0001);
  assertArrayEquals(new int[]{3,4},bean2.getInts());
  assertEquals(listOf("c","d"),bean2.testBean.getLinkedList1());
  assertEquals("publicStrVal",bean2.testBean.publicStrField);
  bean2=JSONCoder.global.decode(jsonStr1,TestBean2.class);
  bean2=JSONCoder.decodeTo(jsonStr2,bean2,new JSONCoderOption().setMergeArray(true));
  assertMatchesSnapshot("withMergeArrayOption",toJSONString(bean2));
  assertArrayEquals(new int[]{1,2,3,4},bean2.getInts());
  assertEquals(listOf("a","b","c","d"),bean2.testBean.getLinkedList1());
}
