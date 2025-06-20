@Test public void synchronousSmoke() throws Exception {
assertTrue(body.startsWith(HEADER.trim()));
assertTrue(body.endsWith(FOOTER.trim()));
}