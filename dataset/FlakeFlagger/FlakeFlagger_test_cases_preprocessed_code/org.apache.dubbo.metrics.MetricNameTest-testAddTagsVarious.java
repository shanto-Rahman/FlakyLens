@Test public void testAddTagsVarious(){
Assert.assertEquals(test,new MetricName(null,refTags));
Assert.assertEquals(test.getTags(),refTags);
Assert.assertEquals(test2,new MetricName(null,refTags));
Assert.assertEquals(test2.getTags(),refTags);
}