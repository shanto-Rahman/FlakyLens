@Test public void assertWithoutEventTraceRdbConfiguration(){
assertFalse(bootstrapEnvironment.getTracingConfiguration().isPresent());
}