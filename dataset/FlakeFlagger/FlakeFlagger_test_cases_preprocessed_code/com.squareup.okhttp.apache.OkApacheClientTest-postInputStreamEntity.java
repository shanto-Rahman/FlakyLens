@Test public void postInputStreamEntity() throws Exception {
assertTrue(Arrays.equals(body,request.getBody()));
assertEquals(request.getHeader("Content-Length"),"13");
}