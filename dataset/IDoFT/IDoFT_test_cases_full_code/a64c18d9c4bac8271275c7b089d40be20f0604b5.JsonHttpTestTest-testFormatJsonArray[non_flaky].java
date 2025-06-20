@Test public void testFormatJsonArray(){
  String expected="<pre>[\n" + "  {\n" + "    &quot;category&quot;: &quot;reference&quot;,\n"+ "    &quot;nested&quot;: {\n"+ "      &quot;price&quot;: 8.95,\n"+ "      &quot;category&quot;: &quot;reference&quot;\n"+ "    }\n"+ "  }\n"+ "]</pre>";
  assertEquals(expected,fixture.safeFormatValue("[{\"category\": \"reference\",\"nested\": {\"price\": 8.95,\"category\": \"reference\"}}]").replace("\r",""));
  assertEquals(expected,fixture.safeFormatValue(" [{\"category\": \"reference\",\"nested\": {\"price\": 8.95,\"category\": \"reference\"}}] ").replace("\r",""));
  assertEquals("<pre>[\n  []\n]</pre>",fixture.safeFormatValue(" [[]] ").replace("\r",""));
}
