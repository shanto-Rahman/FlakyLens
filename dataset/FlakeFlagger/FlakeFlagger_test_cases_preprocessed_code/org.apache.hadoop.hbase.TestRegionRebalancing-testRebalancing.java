/** 
 * For HBASE-71. Try a few different configurations of starting and stopping region servers to see if the assignment or regions is pretty balanced.
 * @throws IOException
 */
public void testRebalancing() throws IOException {
assertEquals("Test table should have 20 regions",20,table.getStartKeys().length);
}