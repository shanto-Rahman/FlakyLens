public void test_for_issue() throws Exception {
assertEquals("\"2018-01-10T08:30:00+08:00\"",JSON.toJSONString(user.create,SerializerFeature.UseISO8601DateFormat));
}