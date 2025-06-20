public void test_for_issue() throws Exception {
assertEquals("{\"a\":{\"b\":{\"c\":\"2018-04\",\"d\":[123]}}}",JSON.toJSONString(jsonObject,SerializerFeature.MapSortField));
}