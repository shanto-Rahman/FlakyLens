@Test public void testAssetsController404() throws Exception {
assertTrue(resultCaptor.getValue().getStatusCode() == Result.SC_404_NOT_FOUND);
}