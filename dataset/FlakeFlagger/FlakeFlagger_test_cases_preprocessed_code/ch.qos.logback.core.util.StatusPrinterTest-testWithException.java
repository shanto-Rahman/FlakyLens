@Test public void testWithException(){
assertTrue(result.contains("|-ERROR in " + this.getClass().getName()));
assertTrue(result.contains("+ INFO in " + this.getClass().getName()));
assertTrue(result.contains("ch.qos.logback.core.util.StatusPrinterTest.testWithException"));
}