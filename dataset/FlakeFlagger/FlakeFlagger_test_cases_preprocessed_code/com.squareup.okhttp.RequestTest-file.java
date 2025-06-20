@Test public void file() throws Exception {
FileWriter writer=new FileWriter(file);
assertEquals(contentType,body.contentType());
assertEquals(3,body.contentLength());
assertEquals("616263",bodyToHex(body));
assertEquals("Retransmit body","616263",bodyToHex(body));
}