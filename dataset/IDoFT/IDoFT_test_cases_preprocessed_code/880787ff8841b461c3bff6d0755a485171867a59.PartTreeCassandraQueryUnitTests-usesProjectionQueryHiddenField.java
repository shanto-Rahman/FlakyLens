@Test void usesProjectionQueryHiddenField(){
assertThat(query).isEqualTo("SELECT lastname,firstname FROM person WHERE nickname='foo'");
}