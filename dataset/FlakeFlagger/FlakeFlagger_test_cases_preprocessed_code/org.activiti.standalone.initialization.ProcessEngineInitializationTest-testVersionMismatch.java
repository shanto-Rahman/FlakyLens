public void testVersionMismatch(){
if (success) {
}
fail("expected exception");
assertEquals("25.7",e.getDbVersion());
assertEquals(ProcessEngine.VERSION,e.getLibraryVersion());
}