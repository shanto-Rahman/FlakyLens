@Test public void testInvokeWithDefault() throws Exception {
Assert.assertEquals(HashMap.class,result.getValue().getClass());
Assert.assertEquals(10,((HashMap)result.getValue()).get("age"));
}