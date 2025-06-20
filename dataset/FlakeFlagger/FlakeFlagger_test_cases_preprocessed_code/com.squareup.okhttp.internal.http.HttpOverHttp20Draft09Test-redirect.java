@Test public void redirect() throws Exception {
assertEquals("/",request1.getPath());
assertEquals("/foo",request2.getPath());
}