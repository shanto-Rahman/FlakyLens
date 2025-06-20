@Test public void testMultipleKeysOneNotFound() throws InitializationException, IOException {
  service.put("key1","value1",new FetchDistributedMapCache.StringSerializer(),new FetchDistributedMapCache.StringSerializer());
  runner.setProperty(FetchDistributedMapCache.PROP_CACHE_ENTRY_IDENTIFIER,"key1, key2");
  runner.assertNotValid();
  runner.setProperty(FetchDistributedMapCache.PROP_PUT_CACHE_VALUE_IN_ATTRIBUTE,"test");
  runner.assertValid();
  final Map<String,String> props=new HashMap<>();
  runner.enqueue(new byte[]{},props);
  runner.run();
  runner.assertAllFlowFilesTransferred(FetchDistributedMapCache.REL_NOT_FOUND,1);
  runner.assertTransferCount(FetchDistributedMapCache.REL_NOT_FOUND,1);
  final MockFlowFile outputFlowFile=runner.getFlowFilesForRelationship(FetchDistributedMapCache.REL_NOT_FOUND).get(0);
  outputFlowFile.assertAttributeEquals("test.key1","value1");
}
