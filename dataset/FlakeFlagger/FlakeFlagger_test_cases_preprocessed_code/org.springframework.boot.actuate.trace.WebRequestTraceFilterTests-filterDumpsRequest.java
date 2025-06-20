@Test public void filterDumpsRequest(){
assertEquals("GET",trace.get("method"));
assertEquals("/foo",trace.get("path"));
assertEquals("{Accept=application/json}",map.get("request").toString());
}