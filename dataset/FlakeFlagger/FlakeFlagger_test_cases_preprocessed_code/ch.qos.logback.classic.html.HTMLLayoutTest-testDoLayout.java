@Test public void testDoLayout() throws Exception {
assertEquals(2,rootElement.elements().size());
assertEquals("table",tableElement.getName());
assertEquals("DEBUG",tdElement.getText());
assertTrue(tdElement.getText().matches(regex));
assertEquals("test message",tdElement.getText());
}