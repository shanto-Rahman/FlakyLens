public void test_for_issue() throws Exception {
assertEquals("\"2017-06-29T10:36:30+08:00\"",JSON.toJSONString(date,SerializerFeature.UseISO8601DateFormat));
}