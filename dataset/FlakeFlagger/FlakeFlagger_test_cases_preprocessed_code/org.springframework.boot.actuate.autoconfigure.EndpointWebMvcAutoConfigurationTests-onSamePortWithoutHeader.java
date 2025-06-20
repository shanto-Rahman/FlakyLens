@Test public void onSamePortWithoutHeader() throws Exception {
assertFalse(hasHeader("/endpoint",ports.get().server,"X-Application-Context"));//RW
}