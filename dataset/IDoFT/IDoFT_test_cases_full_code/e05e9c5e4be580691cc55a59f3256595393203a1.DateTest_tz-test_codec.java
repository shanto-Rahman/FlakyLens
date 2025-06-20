public void test_codec() throws Exception {
  JSONReader reader=new JSONReader(new StringReader("{\"value\":\"2016-04-29\"}"));
  reader.setLocale(Locale.CHINA);
  reader.setTimzeZone(TimeZone.getTimeZone("Asia/Shanghai"));
  Model model=reader.readObject(Model.class);
  Assert.assertNotNull(model.value);
  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
  format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
  Date date=format.parse("2016-04-29");
  Assert.assertEquals(date.getTime(),model.value.getTime());
  Assert.assertEquals(TimeZone.getTimeZone("Asia/Shanghai"),reader.getTimzeZone());
  Assert.assertEquals(Locale.CHINA,reader.getLocal());
  reader.close();
}
