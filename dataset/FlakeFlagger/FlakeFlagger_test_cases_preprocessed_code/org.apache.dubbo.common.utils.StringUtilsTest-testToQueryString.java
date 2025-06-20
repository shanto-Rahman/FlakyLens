@Test public void testToQueryString() throws Exception {
assertThat(queryString,containsString("key1=value1"));
assertThat(queryString,containsString("key2=value2"));
}