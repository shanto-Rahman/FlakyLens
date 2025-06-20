public void test_for_issue_1() throws Exception {
assertEquals("\"2017-08-15T20:00:00+08:00\"",JSON.toJSONString(date,SerializerFeature.UseISO8601DateFormat));
}