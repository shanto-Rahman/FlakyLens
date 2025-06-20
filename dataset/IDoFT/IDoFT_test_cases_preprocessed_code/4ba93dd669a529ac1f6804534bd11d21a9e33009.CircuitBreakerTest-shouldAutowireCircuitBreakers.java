@Test void shouldAutowireCircuitBreakers(){
assertThat(circuitBreakers,is(not(empty())));
}