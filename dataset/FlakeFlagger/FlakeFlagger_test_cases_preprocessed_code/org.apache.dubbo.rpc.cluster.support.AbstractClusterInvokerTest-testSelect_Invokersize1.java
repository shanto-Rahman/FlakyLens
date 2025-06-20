@Test public void testSelect_Invokersize1() throws Exception {
Assert.assertNotNull("cluster.initLoadBalance returns null!",l);
Assert.assertEquals(invoker1,invoker);
}