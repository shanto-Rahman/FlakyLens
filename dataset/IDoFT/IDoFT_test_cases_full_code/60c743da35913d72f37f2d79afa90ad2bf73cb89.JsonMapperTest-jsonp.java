@Test public void jsonp(){
  TestBean bean=new TestBean("A");
  String jsonp=JsonMapper.nonEmptyMapper().toJsonP("haha",bean);
  assertThat(jsonp).isEqualTo("haha({\"name\":\"A\",\"defaultValue\":\"hello\"})");
}
