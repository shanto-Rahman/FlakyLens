@Test public void checkUrlIsAllowed() throws Exception {
assertFalse(processor.isUriAllowed("/WEB-INF/web.xml"));
assertTrue(processor.isUriAllowed("classpath:folder/img.gif"));
}