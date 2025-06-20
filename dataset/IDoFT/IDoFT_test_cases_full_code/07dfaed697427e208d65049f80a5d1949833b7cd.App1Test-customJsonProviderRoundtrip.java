@Test public void customJsonProviderRoundtrip(){
  final String url=String.format("http://localhost:%d/mapper",RULE.getLocalPort());
  final GenericType<Map<String,String>> typ=new GenericType<Map<String,String>>(){
  }
;
  final Map<String,String> response=client.target(url).request().post(Entity.json(Collections.singletonMap("check","mate")),typ);
  assertThat(response).containsExactly(entry("check","mate"),entry("hello","world"));
}
