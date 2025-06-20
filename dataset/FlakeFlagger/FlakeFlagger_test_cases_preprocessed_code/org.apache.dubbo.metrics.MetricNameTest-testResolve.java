@Test public void testResolve(){
Assert.assertEquals(name.resolve("bar"),new MetricName("foo.bar"));
}