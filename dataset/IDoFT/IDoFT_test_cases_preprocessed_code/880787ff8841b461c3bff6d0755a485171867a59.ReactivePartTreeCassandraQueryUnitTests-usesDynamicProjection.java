@Test void usesDynamicProjection(){
assertThat(query).isEqualTo("SELECT lastname,firstname FROM person");
}