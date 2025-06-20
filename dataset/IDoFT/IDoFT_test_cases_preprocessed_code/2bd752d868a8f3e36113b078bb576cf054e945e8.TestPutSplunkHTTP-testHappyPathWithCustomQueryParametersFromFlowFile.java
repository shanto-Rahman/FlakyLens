@Test public void testHappyPathWithCustomQueryParametersFromFlowFile() throws Exception {
Assert.assertEquals("/services/collector/raw?host=test_host&index=test_index&sourcetype=test%3Fsource%3Ftype&source=test_source",path.getValue());
Assert.assertEquals(EVENT,processor.getLastContent());//IT
Assert.assertEquals(attributes.get("ff_content_type"),processor.getLastContentType());//IT
}