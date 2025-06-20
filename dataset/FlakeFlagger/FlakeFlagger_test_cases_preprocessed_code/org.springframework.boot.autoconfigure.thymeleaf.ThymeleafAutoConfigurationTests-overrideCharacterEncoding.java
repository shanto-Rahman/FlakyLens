@Test public void overrideCharacterEncoding() throws Exception {
assertTrue(resolver instanceof TemplateResolver);
assertEquals("UTF-16",((TemplateResolver)resolver).getCharacterEncoding());
assertEquals("UTF-16",views.getCharacterEncoding());
assertEquals("text/html;charset=UTF-16",views.getContentType());
}