@Test public void pack() throws IOException, ServletException {
assertEquals("application/zip",ctx.response().getContentType());
assertEquals(334,ctx.response().getOutput().length);
}