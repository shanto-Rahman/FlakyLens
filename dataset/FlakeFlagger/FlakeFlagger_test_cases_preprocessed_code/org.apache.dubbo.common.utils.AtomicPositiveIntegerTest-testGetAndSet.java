@Test public void testGetAndSet() throws Exception {
assertEquals(0,get);
assertEquals(100,i1.get());
assertThat(expected.getMessage(),allOf(containsString("new value"),containsString("< 0")));
}