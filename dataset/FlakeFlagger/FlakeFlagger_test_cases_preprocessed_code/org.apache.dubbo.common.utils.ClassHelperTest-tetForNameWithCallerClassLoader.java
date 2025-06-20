@Test public void tetForNameWithCallerClassLoader() throws Exception {
assertThat(c == ClassHelper.class,is(true));
}