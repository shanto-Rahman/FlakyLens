@Test public void testFormatJsonArray(){
  String expected="<pre>[{\n" + "    &quot;category&quot;: &quot;reference&quot;,\n" + "    &quot;nested&quot;: {\n"+ "        &quot;price&quot;: 8.95,\n"+ "        &quot;category&quot;: &quot;reference&quot;\n"+ "    }\n"+ "}]</pre>";
  assertEquals(expected,fixture.safeFormatValue("[{\"category\": \"reference\",\"nested\": {\"category\": \"reference\",\"price\": 8.95}}]").replace("\r",""));
  assertEquals(expected,fixture.safeFormatValue(" [{\"category\": \"reference\",\"nested\": {\"category\": \"reference\",\"price\": 8.95}}] ").replace("\r",""));
  assertEquals("<pre>[[]]</pre>",fixture.safeFormatValue(" [[]] ").replace("\r",""));
}
