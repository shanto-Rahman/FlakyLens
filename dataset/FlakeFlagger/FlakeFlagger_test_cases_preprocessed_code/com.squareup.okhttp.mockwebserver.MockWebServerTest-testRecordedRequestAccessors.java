public void testRecordedRequestAccessors(){
assertEquals("s=square",request.getHeader("cookie"));
assertEquals(Arrays.asList("s=square","a=android"),request.getHeaders("cookie"));
assertEquals("left",request.getHeader("x-whitespace"));
assertEquals(Arrays.asList("left","right","both"),request.getHeaders("x-whitespace"));
assertEquals("ABC",request.getUtf8Body());
}