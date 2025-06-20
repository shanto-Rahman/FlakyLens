/** 
 * Test the case where there is a delete row 'in front of' the next row, the scanner will move to the next row.
 */
public void testDeletedRowThenGoodRow() throws IOException {
assertEquals(true,scan.next(results));
assertEquals(0,results.size());
assertEquals(true,scan.next(results));
assertEquals(1,results.size());
assertEquals(kvs[2],results.get(0));
assertEquals(false,scan.next(results));
}