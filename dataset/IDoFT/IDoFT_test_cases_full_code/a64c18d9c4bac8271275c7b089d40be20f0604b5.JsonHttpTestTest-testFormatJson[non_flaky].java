@Test public void testFormatJson(){
  String expected="<pre>{\n" + "  &quot;price&quot;: 8.95,\n" + "  &quot;category&quot;: &quot;reference&quot;\n"+ "}</pre>";
  assertEquals(expected,fixture.safeFormatValue("{\"price\": 8.95,\"category\": \"reference\"}").replace("\r",""));
  assertEquals(expected,fixture.safeFormatValue(" {\"price\": 8.95,\"category\": \"reference\"}").replace("\r",""));
}
