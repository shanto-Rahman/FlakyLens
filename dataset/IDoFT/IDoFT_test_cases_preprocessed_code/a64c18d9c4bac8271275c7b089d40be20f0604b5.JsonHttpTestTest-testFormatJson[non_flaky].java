@Test public void testFormatJson(){
assertEquals(expected,fixture.safeFormatValue("{\"price\": 8.95,\"category\": \"reference\"}").replace("\r",""));
assertEquals(expected,fixture.safeFormatValue(" {\"price\": 8.95,\"category\": \"reference\"}").replace("\r",""));
}