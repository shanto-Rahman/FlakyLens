@Test public void testFormatJson(){
  String expected="<pre>{\n" + "    &quot;price&quot;: 8.95,\n" + "    &quot;category&quot;: &quot;reference&quot;\n"+ "}</pre>";
  assertEquals(expected,fixture.safeFormatValue("{\"category\": \"reference\",\"price\": 8.95}").replace("\r",""));
  assertEquals(expected,fixture.safeFormatValue(" {\"category\": \"reference\",\"price\": 8.95}").replace("\r",""));
}
