public void test_f() throws Exception {
assertEquals("parent.callback",jsonpObject.getFunction());
assertEquals(1,jsonpObject.getParameters().size());
assertEquals(1,param.get("id"));
assertEquals("idonans",param.get("name"));
assertEquals("parent.callback({\"name\":\"idonans\",\"id\":1})",json);
}