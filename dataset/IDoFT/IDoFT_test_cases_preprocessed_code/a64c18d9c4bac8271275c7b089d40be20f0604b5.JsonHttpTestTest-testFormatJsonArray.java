@Test public void testFormatJsonArray(){
assertEquals(expected,fixture.safeFormatValue("[{\"category\": \"reference\",\"nested\": {\"category\": \"reference\",\"price\": 8.95}}]").replace("\r",""));
assertEquals(expected,fixture.safeFormatValue(" [{\"category\": \"reference\",\"nested\": {\"category\": \"reference\",\"price\": 8.95}}] ").replace("\r",""));
assertEquals("<pre>[[]]</pre>",fixture.safeFormatValue(" [[]] ").replace("\r",""));
}