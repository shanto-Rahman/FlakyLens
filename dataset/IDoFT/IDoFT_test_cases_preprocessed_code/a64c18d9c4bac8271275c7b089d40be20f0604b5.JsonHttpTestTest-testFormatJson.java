@Test public void testFormatJson(){
assertEquals(expected,fixture.safeFormatValue("{\"category\": \"reference\",\"price\": 8.95}").replace("\r",""));
assertEquals(expected,fixture.safeFormatValue(" {\"category\": \"reference\",\"price\": 8.95}").replace("\r",""));
}