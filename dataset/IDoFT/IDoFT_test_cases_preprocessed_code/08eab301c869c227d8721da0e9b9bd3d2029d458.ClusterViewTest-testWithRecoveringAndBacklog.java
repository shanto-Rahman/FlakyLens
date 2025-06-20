@Test public void testWithRecoveringAndBacklog() throws Exception {
assertEquals("10",props.get("seq"));
assertEquals(clusterId,unwrapString(props.get("id")));
assertEquals("2",props.get("me"));
assertEquals("false",props.get("final"));
assertEquals(asJsonArray(2,3),props.get("active"));
assertEquals(asJsonArray(4,5),props.get("deactivating"));
assertEquals(asJsonArray(6),props.get("inactive"));
}