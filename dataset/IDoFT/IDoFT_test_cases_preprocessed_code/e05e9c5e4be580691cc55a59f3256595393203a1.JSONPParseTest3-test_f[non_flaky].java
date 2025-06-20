public void test_f() throws Exception {
assertEquals("parent.callback",jsonpObject.getFunction());
assertEquals(3,jsonpObject.getParameters().size());
assertEquals(1,param.get("id"));
assertEquals("ido)nans",param.get("name"));
assertEquals("/**/parent.callback({\"id\":1,\"name\":\"ido\\u0029nans\"},1,2)",json);
}