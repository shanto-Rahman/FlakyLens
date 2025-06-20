@Test public void testSameHttpStringReturned(){
Assert.assertSame(result1.getProtocol(),result2.getProtocol());
Assert.assertSame(result1.getRequestMethod(),result2.getRequestMethod());
if (header == header2) {
}
if (header.equals(Headers.HOST)) {
Assert.assertSame(Headers.HOST,header);
}
Assert.assertTrue("Could not found header " + header,found);
}