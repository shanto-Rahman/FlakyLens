@Test public void testToArgumentString() throws Exception {
assertThat(s,containsString("a,"));
assertThat(s,containsString("0,"));
assertThat(s,containsString("{\"enabled\":true}"));
}