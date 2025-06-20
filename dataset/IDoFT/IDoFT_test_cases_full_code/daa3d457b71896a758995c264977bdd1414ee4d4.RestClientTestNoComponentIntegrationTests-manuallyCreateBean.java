@Test public void manuallyCreateBean(){
  ExampleRestClient client=new ExampleRestClient(this.restTemplateBuilder);
  this.server.expect(requestTo("/test")).andRespond(withSuccess("hello",MediaType.TEXT_HTML));
  assertThat(client.test()).isEqualTo("hello");
}
