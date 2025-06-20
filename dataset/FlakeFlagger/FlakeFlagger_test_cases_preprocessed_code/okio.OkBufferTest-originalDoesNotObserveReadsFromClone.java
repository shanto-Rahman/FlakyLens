@Test public void originalDoesNotObserveReadsFromClone() throws Exception {
assertEquals("abc",clone.readUtf8(3));
assertEquals(3,original.size());
assertEquals("ab",original.readUtf8(2));
}