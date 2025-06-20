@Test public void shouldInheritContextInCreatedThread() throws Exception {
assertTrue(Context.isContextSet());
assertSame(context,Context.get());
}