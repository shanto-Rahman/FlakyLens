@Test public void testLogbackStatusPrinterPrintStreamIsRestoredToSystemOut() throws Exception {
assertThat(out).isSameAs(System.out);
}