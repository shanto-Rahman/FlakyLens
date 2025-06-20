@Test public void string() throws Exception {
assertEquals(contentType,body.contentType());
assertEquals(3,body.contentLength());
assertEquals("616263",bodyToHex(body));
assertEquals("Retransmit body","616263",bodyToHex(body));
}