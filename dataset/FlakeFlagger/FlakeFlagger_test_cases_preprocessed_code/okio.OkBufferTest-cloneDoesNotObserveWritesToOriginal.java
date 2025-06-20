@Test public void cloneDoesNotObserveWritesToOriginal() throws Exception {
assertEquals(0,clone.size());
}