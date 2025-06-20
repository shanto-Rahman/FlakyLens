@Test public void testStart(){
assertEquals("user@host.dom",address.toString());
assertEquals("sebastien.nospam@qos.ch%nopex",appender.getToAsListOfString().get(0));
assertEquals("logging report",appender.getSubject());
assertTrue(appender.isStarted());
fail("Unexpected exception.");
}