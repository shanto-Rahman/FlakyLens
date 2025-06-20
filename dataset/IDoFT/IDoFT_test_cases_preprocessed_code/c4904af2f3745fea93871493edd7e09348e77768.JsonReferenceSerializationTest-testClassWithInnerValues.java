@Test public void testClassWithInnerValues() throws Exception {
assertEquals(json,mapper.writeValueAsString(data));
assertEquals(data,mapper.readValue(json,ComplexData.class));
}