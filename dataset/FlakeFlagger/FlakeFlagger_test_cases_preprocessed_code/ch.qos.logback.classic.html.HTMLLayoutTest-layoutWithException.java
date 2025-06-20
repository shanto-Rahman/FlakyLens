@SuppressWarnings("unchecked") @Test public void layoutWithException() throws Exception {
assertEquals(3,tableElement.elements().size());
assertTrue(exceptionElement.getText().contains("java.lang.Exception: test Exception"));
}