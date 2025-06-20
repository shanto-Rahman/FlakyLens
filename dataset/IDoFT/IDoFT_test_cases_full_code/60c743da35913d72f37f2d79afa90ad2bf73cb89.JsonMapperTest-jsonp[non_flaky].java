@Test public void jsonp() throws JSONException {
  TestBean bean=new TestBean("A");
  String jsonp=JsonMapper.nonEmptyMapper().toJsonP("haha",bean);
  String testJSON="haha({\"name\":\"A\",\"defaultValue\":\"hello\"})";
  String expected=testJSON.substring(testJSON.indexOf("(") + 1,testJSON.indexOf(")"));
  String test=jsonp.substring(jsonp.indexOf("(") + 1,jsonp.indexOf(")"));
  assertThat(jsonp.replace(test,"")).isEqualTo(testJSON.replace(expected,""));
  assertJSONEqual(expected,test);
}
