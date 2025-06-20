@Test public void testResolveWithoutTags(){
Assert.assertEquals(name.resolve("bar",false),new MetricName("foo.bar"));
}