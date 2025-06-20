@Test public void testDerbyOps() throws Exception {
Assert.assertEquals("200",JacksonUtils.toObj(actualValue).get("code").toString());
}