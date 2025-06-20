@Test public void toXmlTest(){
Assert.assertThat(s,CoreMatchers.anyOf(CoreMatchers.is("<aaa>你好</aaa><键2>test</键2>"),CoreMatchers.is("<键2>test</键2><aaa>你好</aaa>")));
}