@Test void testOffsetParsing() throws IOException {
assertEquals(2,objectNumbers.size());
assertEquals(COSBoolean.TRUE,objectStreamParser.parseObject(numbers[0]));
assertEquals(COSBoolean.FALSE,objectStreamParser.parseObject(numbers[1]));
}