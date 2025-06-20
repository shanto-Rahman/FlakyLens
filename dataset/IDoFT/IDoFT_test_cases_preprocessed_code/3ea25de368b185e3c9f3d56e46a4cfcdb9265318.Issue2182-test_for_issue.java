public void test_for_issue() throws Exception {
assertEquals("{\"admin\":[\"admin.create\",\"admin.update\",\"admin.delete\"],\"user\":[\"user.create\",\"user.delete\"]}",json);
assertEquals(multimap.size(),multimap1.size());
assertEquals(json,JSON.toJSONString(multimap1));
}