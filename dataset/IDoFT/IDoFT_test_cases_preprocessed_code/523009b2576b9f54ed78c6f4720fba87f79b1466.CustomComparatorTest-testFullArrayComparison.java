@Test public void testFullArrayComparison() throws Exception {
Assert.assertTrue(compareResult.failed());
Assert.assertTrue(message,message.matches(".*id=5.*Expected.*id=6.*Unexpected.*id=7.*Unexpected.*"));
}