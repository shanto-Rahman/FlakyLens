@Test public void testInitFirstVerifyStopInvokedImmediately() throws Exception {
if (mr1.size() != 0 && mr2.size() != 0) {
assertEquals("output",mr1,mr2);
if (mr1.size() != 0) {
if (mr2.size() != 0) {
}
}
}
}