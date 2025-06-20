@Test public void testSystemPropertyInitializesFormat() throws Exception {
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertTrue("Wrong output:\n" + output,output.contains("1234 INFO ["));
}