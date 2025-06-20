@Test public void testFormatJsonArray(){
assertEquals(expected,fixture.safeFormatValue("[{\"category\": \"reference\",\"nested\": {\"price\": 8.95,\"category\": \"reference\"}}]").replace("\r",""));
assertEquals(expected,fixture.safeFormatValue(" [{\"category\": \"reference\",\"nested\": {\"price\": 8.95,\"category\": \"reference\"}}] ").replace("\r",""));
assertEquals("<pre>[\n  []\n]</pre>",fixture.safeFormatValue(" [[]] ").replace("\r",""));
}