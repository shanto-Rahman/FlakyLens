/** 
 * Tests that there is no repeated text in the page margin area as reported in issue 458.
 */
@Test public void testIssue458PageContentRepeatedInMargin() throws IOException {
  try (PDDocument doc=run("issue-458-content-repeated")){
    PDFTextStripper stripper=new PDFTextStripper();
    String text=stripper.getText(doc);
    String expected=IntStream.rangeClosed(1,9).mapToObj(i -> "Line " + i + "\r\n").collect(Collectors.joining()) + "This is \r\n" + "some \r\n"+ "flowing \r\n"+ "text that \r\n"+ "should not \r\n"+ "repeat in \r\n"+ "page \r\n"+ "margins.\r\n"+ "1.  \r\n"+ "2.  \r\n"+ "3.  \r\n"+ "One\r\n"+ "Two\r\n"+ "Three";
    String normalizedExpected=expected.replaceAll("(\\r|\\n)","");
    String normalizedActual=text.replaceAll("(\\r|\\n)","");
    assertEquals(normalizedExpected.trim(),normalizedActual.trim());
  }
 }
