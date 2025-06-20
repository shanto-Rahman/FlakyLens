public void testDefaultShapeOverride() throws Exception {
assertEquals(aposToQuotes("{'key':'foo','value':'bar'}"),mapper.writeValueAsString(input));
}