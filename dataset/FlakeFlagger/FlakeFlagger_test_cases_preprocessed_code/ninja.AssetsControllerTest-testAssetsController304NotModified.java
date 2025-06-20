@Test public void testAssetsController304NotModified() throws Exception {
assertEquals(Result.SC_304_NOT_MODIFIED,resultCaptor.getValue().getStatusCode());
}