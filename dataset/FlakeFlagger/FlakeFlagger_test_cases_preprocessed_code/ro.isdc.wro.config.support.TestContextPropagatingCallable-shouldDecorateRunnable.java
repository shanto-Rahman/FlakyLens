@Test public void shouldDecorateRunnable() throws Exception {
assertTrue(Context.isContextSet());
assertSame(context,Context.get());
}