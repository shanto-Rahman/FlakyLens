@Test public void testResolveWithTags(){
Assert.assertEquals(name.resolve("bar"),new MetricName("foo.bar").tag("key","value"));
}