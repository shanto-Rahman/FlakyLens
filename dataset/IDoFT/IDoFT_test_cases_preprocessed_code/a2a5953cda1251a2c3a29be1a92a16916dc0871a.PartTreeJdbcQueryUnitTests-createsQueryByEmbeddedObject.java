@Test public void createsQueryByEmbeddedObject() throws Exception {
assertThat(query.getQuery()).isEqualTo(expectedSql);
assertThat(query.getParameterSource().getValue("user_street")).isEqualTo("Hello");
assertThat(query.getParameterSource().getValue("user_city")).isEqualTo("World");
}