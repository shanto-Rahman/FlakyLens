public void test_6() throws Exception {
assertEquals(JSONObject.class,obj.getClass());
assertEquals(JSON.toJSONString(jsonObject,SerializerFeature.MapSortField),JSON.toJSONString(obj,SerializerFeature.MapSortField));
}