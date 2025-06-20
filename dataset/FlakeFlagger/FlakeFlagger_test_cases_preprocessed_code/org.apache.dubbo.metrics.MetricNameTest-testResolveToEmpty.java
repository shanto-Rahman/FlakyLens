@Test public void testResolveToEmpty(){
Assert.assertEquals(name.resolve(null),new MetricName("foo"));
}