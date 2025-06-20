public void test_for_issue() throws Exception {
  JSONObject object=new JSONObject();
  object.put("date","2017-06-29T08:06:30.000+05:30");
  Date date=object.getObject("date",java.util.Date.class);
  assertEquals("\"2017-06-29T10:36:30+08:00\"",JSON.toJSONString(date,SerializerFeature.UseISO8601DateFormat));
}
