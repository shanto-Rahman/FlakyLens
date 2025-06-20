@Test public void testHappyPathWithCustomQueryParameters() throws Exception {
Assert.assertEquals("/services/collector/raw?sourcetype=test%3Fsource%3Ftype&source=test_source",path.getValue());
}