@Test public void evaluatorFilterWithNullMarker_LBCORE_118() throws Exception {
assertEquals(FilterReply.NEUTRAL,ef.decide(event));
}