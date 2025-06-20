@Test void usesDynamicProjection(){
  String query=deriveQueryFromMethod("findDynamicallyProjectedBy",PersonProjection.class);
  assertThat(query).isEqualTo("SELECT lastname,firstname FROM person");
}
