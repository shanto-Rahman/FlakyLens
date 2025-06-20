@Test public void testTaggedMoreArguments(){
Assert.assertEquals(MetricName.EMPTY.tag("foo","bar","baz","biz").getTags(),refTags);
}