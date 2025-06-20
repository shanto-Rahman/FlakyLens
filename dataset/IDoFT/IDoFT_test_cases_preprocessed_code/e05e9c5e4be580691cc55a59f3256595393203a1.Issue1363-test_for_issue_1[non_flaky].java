public void test_for_issue_1() throws Exception {
System.out.println(obj.toString());//IT
assertNotNull(obj.value1);
assertEquals(jsonStr,JSON.toJSONString(obj,SerializerFeature.MapSortField));
}