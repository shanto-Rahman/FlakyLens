@Test public void client1RestCallViaCustomizer(){
  this.customizer.getServer(this.client1.getRestTemplate()).expect(requestTo("/test")).andRespond(withSuccess("hello",MediaType.TEXT_HTML));
  assertThat(this.client1.test()).isEqualTo("hello");
}
