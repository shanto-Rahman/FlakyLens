@Test public void testSet() throws Exception {
assertEquals(100,i1.get());
fail();
assertThat(expected.getMessage(),allOf(containsString("new value"),containsString("< 0")));
}