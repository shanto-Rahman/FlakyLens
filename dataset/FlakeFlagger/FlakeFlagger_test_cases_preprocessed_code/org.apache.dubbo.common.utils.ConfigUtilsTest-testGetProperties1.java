@Test public void testGetProperties1() throws Exception {
assertThat((String)p.get("a"),equalTo("12"));
assertThat((String)p.get("b"),equalTo("34"));
assertThat((String)p.get("c"),equalTo("56"));
}