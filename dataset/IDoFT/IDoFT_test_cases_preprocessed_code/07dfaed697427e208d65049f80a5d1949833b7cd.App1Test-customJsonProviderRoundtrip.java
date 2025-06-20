@Test public void customJsonProviderRoundtrip(){
final Map<String,String> response=client.target(url).request().post(Entity.json(Collections.singletonMap("check","mate")),typ);//RW
assertThat(response).containsExactly(entry("check","mate"),entry("hello","world"));
}