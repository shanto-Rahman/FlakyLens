@Test public void testSelect_Invokersize2AndselectNotNull() throws Exception {
Assert.assertNotNull("cluster.initLoadBalance returns null!",l);
Assert.assertEquals(invoker2,invoker);
Assert.assertEquals(invoker4,invoker);
}