@Test public void testResolveWithLevel(){
Assert.assertEquals(name.resolve("bar"),new MetricName("foo.bar").tag("key","value").level(MetricLevel.CRITICAL));
}