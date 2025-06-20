public void test_6() throws Exception {
assertEquals(JSONObject.class,obj.getClass());
assertEquals(jsonObject.toJSONString(),JSON.toJSONString(obj));
}