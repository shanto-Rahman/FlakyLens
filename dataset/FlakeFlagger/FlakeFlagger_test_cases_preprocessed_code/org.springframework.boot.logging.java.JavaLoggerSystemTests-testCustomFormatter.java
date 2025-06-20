@Test public void testCustomFormatter() throws Exception {
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertTrue("Wrong output:\n" + output,output.contains("???? INFO ["));
}