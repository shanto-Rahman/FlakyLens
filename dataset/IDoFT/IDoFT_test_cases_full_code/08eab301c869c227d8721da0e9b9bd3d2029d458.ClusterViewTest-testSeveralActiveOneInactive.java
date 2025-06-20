@Test public void testSeveralActiveOneInactive() throws Exception {
  String clusterId=UUID.randomUUID().toString();
  ClusterViewBuilder builder=new ClusterViewBuilder(10,2);
  ClusterView view=builder.active(2,5,6).inactive(3).asView(clusterId);
  JsonObject o=asJsonObject(view);
  Map<String,String> props=o.getProperties();
  assertEquals("10",props.get("seq"));
  assertEquals("true",props.get("final"));
  assertEquals(clusterId,unwrapString(props.get("id")));
  assertEquals("2",props.get("me"));
  assertEquals(asJsonArray(2,5,6),props.get("active"));
  assertEquals(asJsonArray(),props.get("deactivating"));
  assertEquals(asJsonArray(3),props.get("inactive"));
}
