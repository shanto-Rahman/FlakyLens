/** 
 * Test empty HFile. Test all features work reasonably when hfile is empty of entries.
 * @throws IOException
 */
public void testEmptyHFile() throws IOException {
Path f=new Path(ROOT_DIR,getName());//RW
assertNull(r.getFirstKey());
assertNull(r.getLastKey());
}