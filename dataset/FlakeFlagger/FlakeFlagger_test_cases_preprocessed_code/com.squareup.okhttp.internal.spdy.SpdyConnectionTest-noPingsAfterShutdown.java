@Test public void noPingsAfterShutdown() throws Exception {
fail();
assertEquals("shutdown",expected.getMessage());
assertEquals(TYPE_GOAWAY,goaway.type);
assertEquals(INTERNAL_ERROR,goaway.errorCode);
}