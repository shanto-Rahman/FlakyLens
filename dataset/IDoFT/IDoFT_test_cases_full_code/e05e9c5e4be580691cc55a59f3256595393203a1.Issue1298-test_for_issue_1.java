public void test_for_issue_1() throws Exception {
  JSONObject object=new JSONObject();
  object.put("date","2017-08-15 20:00:00.000");
  Date date=object.getObject("date",java.util.Date.class);
  assertEquals("\"2017-08-15T20:00:00+08:00\"",JSON.toJSONString(date,SerializerFeature.UseISO8601DateFormat));
  JSON.parseObject("\"2017-08-15 20:00:00.000\"",java.util.Date.class);
}
