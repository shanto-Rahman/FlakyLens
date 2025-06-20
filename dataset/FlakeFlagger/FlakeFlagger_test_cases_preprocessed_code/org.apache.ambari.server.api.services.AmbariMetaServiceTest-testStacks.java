@Test public void testStacks() throws UniformInterfaceException, JSONException, IOException {
LOG.info("All Stack Info \n" + output);//RW
Assert.assertEquals("HDP",stackInfo.getName());
Assert.assertEquals("HDFS",info.getName());
}