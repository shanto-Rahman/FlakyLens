@Test public void canLocateValidResource() throws Exception {
assertNotNull(victim.getInputStream(mockRequest,mockResponse,"http://www.google.com"));
}