/** 
 * Test JSON.
 */
@Test public void testJSON(){
  final H h=new H();
  h.g=new G();
  final String json0=JSONSerializer.serializeFromField(h,"g",0,false);
  final String expected="{\"e\":{\"list\":[3,3,3],\"map\":{\"3\":3},\"q\":{\"b\":3,\"a\":{\"x\":[3],\"y\":\"x\"}," + "\"arr\":[3,3,3]}," + "\"c\":{\"b\":5,\"a\":{\"x\":[5],\"y\":\"x\"},\"arr\":[5,5,5]},"+ "\"z\":42},\"f\":{\"list\":[1.5,1.5,1.5],\"map\":{\"1.5\":1.5},"+ "\"q\":{\"b\":1.5,"+ "\"a\":{\"x\":[1.5],\"y\":\"x\"},\"arr\":[1.5,1.5,1.5]},\"z\":1.5,\"wxy\":123}}";
  assertThat(json0).isEqualTo(expected);
  final G obj=JSONDeserializer.deserializeObject(G.class,json0);
  final String json1=JSONSerializer.serializeObject(obj,0,false);
  assertThat(json0).isEqualTo(json1);
}
