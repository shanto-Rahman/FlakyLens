@Test public void testRequestExpectContinueIgnoreNonenclosingRequests() throws Exception {
Assert.assertEquals(0,request.getAllHeaders().length);
}