@Test public void toXmlTest(){
  final JSONObject put=JSONUtil.createObj().set("aaa","你好").set("键2","test");
  final String s=JSONUtil.toXmlStr(put);
  Assert.assertThat(s,CoreMatchers.anyOf(CoreMatchers.is("<aaa>你好</aaa><键2>test</键2>"),CoreMatchers.is("<键2>test</键2><aaa>你好</aaa>")));
}
