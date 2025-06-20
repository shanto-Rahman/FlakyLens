@Test void usesProjectionQueryHiddenField(){
  String query=deriveQueryFromMethod("findPersonProjectedByNickname","foo");
  assertThat(query).isEqualTo("SELECT lastname,firstname FROM person WHERE nickname='foo'");
}
