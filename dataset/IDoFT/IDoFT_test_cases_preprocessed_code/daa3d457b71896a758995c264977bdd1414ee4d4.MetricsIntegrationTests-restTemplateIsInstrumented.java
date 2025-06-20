@SuppressWarnings("unchecked") @Test public void restTemplateIsInstrumented(){
assertThat(this.external.getForObject("/api/external",Map.class)).containsKey("message");
assertThat(this.registry.get("http.client.requests").timer().count()).isEqualTo(1);
}