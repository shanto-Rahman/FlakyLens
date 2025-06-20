@Test public void testDeserializeHostInfo() throws JsonParseException, JsonMappingException, IOException {
Assert.assertEquals(info.getMemoryTotal(),3051356L);
Assert.assertEquals(info.getKernel(),"Linux");
Assert.assertEquals(info.getFQDN(),"dev.test.com");
Assert.assertEquals(info.getAgentUserId(),"root");
Assert.assertEquals(info.getMemorySize(),3051356L);
Assert.assertEquals(info.getArchitecture(),"x86_64");
}