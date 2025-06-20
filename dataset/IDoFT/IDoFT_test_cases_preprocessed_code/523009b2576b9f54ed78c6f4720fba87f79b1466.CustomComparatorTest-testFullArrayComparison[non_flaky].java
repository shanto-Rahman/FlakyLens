@Test public void testFullArrayComparison() throws Exception {
Assert.assertTrue(compareResult.failed());
Assert.assertTrue(message,message.matches("(?:.*id=(?:5.*Expected|6.*Unexpected|7.*Unexpected)){3}.*"));
}