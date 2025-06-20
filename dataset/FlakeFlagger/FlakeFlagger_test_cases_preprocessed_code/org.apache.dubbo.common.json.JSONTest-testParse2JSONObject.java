@Test public void testParse2JSONObject() throws Exception {
assertEquals(jo.getString("name"),"qianlei");
assertEquals(jo.getArray("array").length(),5);
assertEquals(jo.get("$2"),Boolean.FALSE);
assertEquals(jo.get("__3"),null);
}