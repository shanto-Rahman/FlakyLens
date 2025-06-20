@Test public void testEmptyResolve(){
Assert.assertEquals(name.resolve("foo"),new MetricName("foo"));
}