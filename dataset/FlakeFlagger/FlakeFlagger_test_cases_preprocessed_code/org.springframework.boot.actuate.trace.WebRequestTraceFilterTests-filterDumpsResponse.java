@Test public void filterDumpsResponse(){
assertEquals("{Content-Type=application/json, status=200}",map.get("response").toString());
}