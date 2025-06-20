@Test public void properties(){
assertEquals("filename",hbsError.filename);
assertEquals(1,hbsError.line);
assertEquals(3,hbsError.column);
assertEquals("reason",hbsError.reason);
assertEquals("evidence",hbsError.evidence);
assertEquals("message",hbsError.message);
}