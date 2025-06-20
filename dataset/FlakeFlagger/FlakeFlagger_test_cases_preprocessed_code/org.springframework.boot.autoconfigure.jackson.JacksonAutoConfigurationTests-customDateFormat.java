@Test public void customDateFormat() throws Exception {
assertEquals("\"19880625203000\"",mapper.writeValueAsString(date));
}