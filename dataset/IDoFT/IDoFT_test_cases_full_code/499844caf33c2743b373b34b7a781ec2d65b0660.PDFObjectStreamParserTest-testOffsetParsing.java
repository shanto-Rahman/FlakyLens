@Test void testOffsetParsing() throws IOException {
  COSStream stream=new COSStream();
  stream.setItem(COSName.N,COSInteger.TWO);
  stream.setItem(COSName.FIRST,COSInteger.get(8));
  OutputStream outputStream=stream.createOutputStream();
  outputStream.write("1 0 2 5 true false".getBytes());
  outputStream.close();
  PDFObjectStreamParser objectStreamParser=new PDFObjectStreamParser(stream,null);
  Map<Long,Integer> objectNumbers=objectStreamParser.readObjectNumbers();
  assertEquals(2,objectNumbers.size());
  Long[] numbers=objectNumbers.keySet().toArray(new Long[0]);
  objectStreamParser=new PDFObjectStreamParser(stream,null);
  assertEquals(COSBoolean.TRUE,objectStreamParser.parseObject(numbers[0]));
  objectStreamParser=new PDFObjectStreamParser(stream,null);
  assertEquals(COSBoolean.FALSE,objectStreamParser.parseObject(numbers[1]));
}
