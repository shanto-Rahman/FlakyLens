@Test public void jobWebSample() throws Exception {
assertTrue("Wrong output: " + output,output.contains("completed with the following parameters"));
assertEquals("World!",result);
}