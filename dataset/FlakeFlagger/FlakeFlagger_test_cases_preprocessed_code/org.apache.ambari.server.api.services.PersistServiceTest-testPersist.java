@Test public void testPersist() throws UniformInterfaceException, JSONException, IOException {
LOG.info("Done posting to the server");//RW
LOG.info("All key values " + output);//RW
Assert.assertEquals("t",value);
Assert.assertEquals("t",output);
LOG.info("Value for xyx " + output);//RW
}