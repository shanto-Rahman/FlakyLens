@Test public void testExplodedJar() throws Exception {
if (dirPath.endsWith("/")) {
}
assertEquals(1,resultCollector.getClassDescriptorSet().size());
assertEquals(1,resultCollector.getPackageDescriptorSet().size());
assertEquals(1,resultCollector.getMappingFileSet().size());
assertTrue(resultCollector.getClassDescriptorSet().contains(new ClassDescriptorImpl(Carpet.class.getName(),null)));
assertNotNull(mappingFileDescriptor.getStreamAccess());
assertNotNull(stream);
}