@Test public void stringDecimalFormat() throws IOException {
assertEquals("stringFormat",stringFormat.name());
assertEquals("10 / 3 = 3.33",stringFormat.apply("10 / 3 = %.2f",options));
}