/** 
 * Test if a KeyValue is in the lists of deletes already. Cases that needs to be tested are: Not deleted Deleted by a Delete Deleted by a DeleteColumn Deleted by a DeleteFamily
 */
public void testIsDeleted_NotDeleted(){
assertEquals(false,dt.isDeleted(col2,0,col2Len,ts3));
assertEquals(false,dt.isDeleted(col2,0,col2Len,ts1));
}