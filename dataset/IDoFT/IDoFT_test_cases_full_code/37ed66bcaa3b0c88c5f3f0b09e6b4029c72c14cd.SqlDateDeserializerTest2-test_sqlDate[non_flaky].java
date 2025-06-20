public void test_sqlDate() throws Exception {
  java.util.Date date=new java.util.Date();
  long millis=date.getTime();
  long millis2=(millis / 1000) * 1000;
  SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",JSON.defaultLocale);
  dateFormat.setTimeZone(JSON.defaultTimeZone);
  String text=dateFormat.format(millis);
  text=text.replace(' ','T');
  SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",JSON.defaultLocale);
  dateFormat2.setTimeZone(JSON.defaultTimeZone);
  String text2=dateFormat2.format(millis2);
  text2=text2.replace(' ','T');
  Assert.assertNull(JSON.parseObject("null",Date.class));
  Assert.assertNull(JSON.parseObject("\"\"",Date.class));
  Assert.assertNull(JSON.parseArray("null",Date.class));
  Assert.assertNull(JSON.parseArray("[null]",Date.class).get(0));
  Assert.assertNull(JSON.parseObject("{\"value\":null}",VO.class).getValue());
  Assert.assertEquals(new Date(millis),JSON.parseObject("" + millis,Date.class));
  Assert.assertEquals(new Date(millis),JSON.parseObject("{\"@type\":\"java.sql.Date\",\"val\":" + millis + "}",Date.class));
  Assert.assertEquals(new Date(millis),JSON.parseObject("\"" + millis + "\"",Date.class));
  Assert.assertEquals(new Date(millis2),JSON.parseObject("\"" + text2 + "\"",Date.class));
  Assert.assertEquals(new Date(millis),JSON.parseObject("\"" + text + "\"",Date.class));
}
