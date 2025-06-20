@Test public void LBCLASSIC_104() throws Exception {
assertTrue(body.startsWith(HEADER.trim()));
assertTrue(body.contains("key=val"));
assertTrue(body.endsWith(FOOTER.trim()));
}