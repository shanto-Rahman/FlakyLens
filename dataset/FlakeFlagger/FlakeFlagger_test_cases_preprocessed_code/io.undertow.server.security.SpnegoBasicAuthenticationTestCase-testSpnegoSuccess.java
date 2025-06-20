@Test public void testSpnegoSuccess() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(NEGOTIATE.toString(),header);
if (token != null && token.length > 0) {
if (headers.length > 0) {
}
if (result.getStatusLine().getStatusCode() == 200) {
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
if (result.getStatusLine().getStatusCode() == 401) {
assertTrue("We did get a header.",headers.length > 0);
fail(String.format("Unexpected status code %d",result.getStatusLine().getStatusCode()));
}
}
}
assertTrue(gotOur200);
assertTrue(context.isEstablished());
}