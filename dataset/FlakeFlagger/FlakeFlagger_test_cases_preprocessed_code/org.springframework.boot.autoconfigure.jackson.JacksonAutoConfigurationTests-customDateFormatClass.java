@Test public void customDateFormatClass() throws Exception {
assertEquals("\"1988-06-25 20:30:00\"",mapper.writeValueAsString(date));
}