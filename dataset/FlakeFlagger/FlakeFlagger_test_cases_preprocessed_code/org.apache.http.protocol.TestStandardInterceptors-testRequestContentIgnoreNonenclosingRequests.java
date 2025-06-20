@Test public void testRequestContentIgnoreNonenclosingRequests() throws Exception {
Assert.assertEquals(0,request.getAllHeaders().length);
}