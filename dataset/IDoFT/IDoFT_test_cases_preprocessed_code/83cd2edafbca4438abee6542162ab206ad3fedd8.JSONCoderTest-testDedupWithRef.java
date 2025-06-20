@Test public void testDedupWithRef(){
assertTrue("Generate ref if dedupWithRef is set",str.contains("$ref"));
assertSame(tb1.getBean2(),tb1.bean2List.get(0));
assertSame(tb1.getInts(),tb1.getBean2().getInts());
}