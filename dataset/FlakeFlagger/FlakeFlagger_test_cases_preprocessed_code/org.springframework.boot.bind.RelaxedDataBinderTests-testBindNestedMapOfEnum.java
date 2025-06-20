@Test public void testBindNestedMapOfEnum() throws Exception {
assertEquals("bar",target.getNested().get(Bingo.THIS));//RW
assertEquals("123",target.getNested().get(Bingo.THAT));//RW
}