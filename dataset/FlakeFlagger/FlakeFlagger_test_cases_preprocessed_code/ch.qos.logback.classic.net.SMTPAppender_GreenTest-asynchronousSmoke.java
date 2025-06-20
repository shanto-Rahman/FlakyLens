@Test public void asynchronousSmoke() throws Exception {
assertTrue(body.startsWith(HEADER.trim()));
assertTrue(body.endsWith(FOOTER.trim()));
}