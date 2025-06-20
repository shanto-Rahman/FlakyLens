@Test public void testDefaultSettings() throws Exception {
if (serverNotRunning(ex)) {
}
assertTrue("Wrong output: " + output,output.contains("firstName='Alice', lastName='Smith'"));
}