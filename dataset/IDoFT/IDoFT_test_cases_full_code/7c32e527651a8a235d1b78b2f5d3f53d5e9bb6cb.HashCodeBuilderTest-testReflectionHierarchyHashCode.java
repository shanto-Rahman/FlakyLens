@Test public void testReflectionHierarchyHashCode(){
  assertEquals(17 * 37 * 37,HashCodeBuilder.reflectionHashCode(new TestSubObject(0,0,0)));
  assertEquals(17 * 37 * 37* 37,HashCodeBuilder.reflectionHashCode(new TestSubObject(0,0,0),true));
  assertEquals((17 * 37 + 7890) * 37 + 123456,HashCodeBuilder.reflectionHashCode(new TestSubObject(123456,7890,0)));
  assertEquals(((17 * 37 + 7890) * 37 + 0) * 37 + 123456,HashCodeBuilder.reflectionHashCode(new TestSubObject(123456,7890,0),true));
}
