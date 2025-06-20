@Test public void testDedupWithRef(){
  TestBean2 tb2=new TestBean2();
  TestBean tb=new TestBean().setBean2(tb2).setInts(new int[]{1,2,3});
  tb.bean2List=Collections.singletonList(tb2);
  tb2.setInts(tb.getInts());
  String str=toJSONString(tb,JSONCoderOption.of().setDedupWithRef(true).setJsonOption(false,'"',2));
  assertMatchesSnapshot(str);
  assertTrue("Generate ref if dedupWithRef is set",str.contains("$ref"));
  TestBean tb1=JSONCoder.global.decode(str,TestBean.class);
  assertSame(tb1.getBean2(),tb1.bean2List.get(0));
  assertSame(tb1.getInts(),tb1.getBean2().getInts());
}
