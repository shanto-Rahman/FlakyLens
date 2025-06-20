@Test public void testCyclicReference(){
  TestBean tb=new TestBean().setBean2(new TestBean2());
  tb.getBean2().testBean=tb;
  String str=toJSONString(tb,new JSONCoderOption().setJsonOption(false,'`',2));
  assertMatchesSnapshot(str);
  assertTrue("Cyclic reference should be encoded as $ref:str=" + str,str.indexOf("testBean:{\n      $ref:`../../`\n") > 0);
  TestBean tb1=JSONCoder.global.decode(str,TestBean.class);
  assertEquals(tb1.getBean2().testBean,tb1);
}
