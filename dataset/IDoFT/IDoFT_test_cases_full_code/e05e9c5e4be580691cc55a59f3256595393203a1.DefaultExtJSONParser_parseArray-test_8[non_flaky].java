public void test_8() throws Exception {
  JSON.defaultTimeZone=TimeZone.getTimeZone("Asia/Shanghai");
  DefaultJSONParser parser=new DefaultJSONParser("\"2011-01-09T13:49:53.254\"");
  parser.config(Feature.AllowISO8601DateFormat,true);
  Object value=parser.parse();
  Assert.assertEquals(new Date(1294552193254L),value);
}
