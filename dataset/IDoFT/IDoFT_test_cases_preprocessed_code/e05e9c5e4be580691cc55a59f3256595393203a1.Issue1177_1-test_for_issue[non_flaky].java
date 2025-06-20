public void test_for_issue() throws Exception {
assertEquals("{\"a\":{\"x\":\"y2\"},\"b\":{\"x\":\"y2\"}}",JSON.toJSONString(jsonObject,SerializerFeature.MapSortField));
}