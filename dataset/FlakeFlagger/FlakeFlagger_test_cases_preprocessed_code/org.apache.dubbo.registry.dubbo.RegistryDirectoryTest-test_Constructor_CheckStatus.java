@Test public void test_Constructor_CheckStatus() throws Exception {
Assert.assertEquals("bar",queryMap.get("foo"));
Assert.assertEquals(url.clearParameters().addParameter("foo","bar"),reg.getUrl());
}