/** 
 * HIVE-5788 <p> Background: in cases of "add column", table metadata changes but data does not.  Columns missing from the data but which are required by metadata are interpreted as null. <p> This tests the use-case of altering columns of a table with already some data, then adding more data in the new schema, and seeing if this serde can to read both types of data from the resultant table.
 * @throws SerDeException
 */
@Test public void testHandlingAlteredSchemas() throws SerDeException {
Assert.assertEquals(((LongWritable)objs1.get(0)).get(),1L);
Assert.assertEquals(((LongWritable)objs1.get(1)).get(),2L);
Assert.assertNull(objs1.get(2));
Assert.assertEquals(((LongWritable)objs2.get(0)).get(),11L);
Assert.assertEquals(((LongWritable)objs2.get(1)).get(),12L);
Assert.assertEquals(((LongWritable)objs2.get(2)).get(),13L);
}