@Test public void testDecodingRowByRow() throws Exception {
fail(NotFoundException.class.getName() + " expected");
assertEquals(1,rssExpandedReader.getRows().size());
assertEquals(firstRowNumber,firstExpandedRow.getRowNumber());
assertEquals(2,firstExpandedRow.getPairs().size());
assertEquals("(01)98898765432106(3202)012345(15)991231",result.getText());
}