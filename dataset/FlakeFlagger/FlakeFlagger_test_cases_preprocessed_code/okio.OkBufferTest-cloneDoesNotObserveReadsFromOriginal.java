@Test public void cloneDoesNotObserveReadsFromOriginal() throws Exception {
assertEquals("abc",original.readUtf8(3));
assertEquals(3,clone.size());
assertEquals("ab",clone.readUtf8(2));
}