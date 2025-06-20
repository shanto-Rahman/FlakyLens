@Test public void reactorSample() throws Exception {
Thread.sleep(200);
assertTrue("Wrong output: " + output,output.contains("Hello Phil"));
}