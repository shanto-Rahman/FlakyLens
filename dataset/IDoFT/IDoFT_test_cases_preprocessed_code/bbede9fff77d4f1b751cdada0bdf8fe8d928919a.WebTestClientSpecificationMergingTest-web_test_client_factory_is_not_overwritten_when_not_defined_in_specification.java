@Test public void web_test_client_factory_is_not_overwritten_when_not_defined_in_specification(){
assertThat(webTestClient).isSameAs(webTestClientInstance);
Assertions.assertThat(implementation(spec).getQueryParams()).containsOnly(entry("param1","value1"));
}