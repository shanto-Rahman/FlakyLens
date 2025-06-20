@Test public void client2RestCallViaCustomizer(){
  this.customizer.getServer(this.client2.getRestTemplate()).expect(requestTo("/test")).andRespond(withSuccess("there",MediaType.TEXT_HTML));
  assertThat(this.client2.test()).isEqualTo("there");
}
