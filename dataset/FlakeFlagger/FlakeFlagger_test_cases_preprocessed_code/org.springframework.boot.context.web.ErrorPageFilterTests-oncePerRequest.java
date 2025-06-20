@Test public void oncePerRequest() throws Exception {
assertNotNull(request.getAttribute("FILTER.FILTERED"));
}