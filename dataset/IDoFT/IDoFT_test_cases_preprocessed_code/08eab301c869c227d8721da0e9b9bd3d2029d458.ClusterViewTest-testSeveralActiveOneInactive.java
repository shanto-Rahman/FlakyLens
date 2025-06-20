@Test public void testSeveralActiveOneInactive() throws Exception {
assertEquals("10",props.get("seq"));
assertEquals("true",props.get("final"));
assertEquals(clusterId,unwrapString(props.get("id")));
assertEquals("2",props.get("me"));
assertEquals(asJsonArray(2,5,6),props.get("active"));
assertEquals(asJsonArray(),props.get("deactivating"));
assertEquals(asJsonArray(3),props.get("inactive"));
}