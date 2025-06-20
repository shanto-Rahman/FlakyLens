/** 
 * The test suppresses unchecked warnings in {@link org.mockito.Mockito#reset}. Although calling the method is a bad manner, we call the method instead of splitting the test (i.e. restarting MiniDFSCluster) to save time.
 */
@Test @SuppressWarnings("unchecked") public void testSplitPlacement() throws Exception {
if (!fileSys.mkdirs(inDir)) {
}
assertEquals(1,splits.size());
assertEquals(2,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file1.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(file5.getName(),fileSplit.getPath(1).getName());
assertEquals(0,fileSplit.getOffset(1));
assertEquals(BLOCKSIZE,fileSplit.getLength(1));
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
if (splits.size() == 2) {
if (split.equals(splits.get(0))) {
assertEquals(2,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file2.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(file2.getName(),fileSplit.getPath(1).getName());
assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
assertEquals(BLOCKSIZE,fileSplit.getLength(1));
assertEquals(hosts2[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(1))) {
assertEquals(1,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file1.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (splits.size() == 1) {
assertEquals(3,fileSplit.getNumPaths());
assertTrue(actual.containsAll(expected));
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
fail("Expected split size is 1 or 2, but actual size is " + splits.size());
}
}
if (splits.size() == 3) {
if (split.equals(splits.get(0))) {
assertEquals(3,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file3.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(file3.getName(),fileSplit.getPath(1).getName());
assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
assertEquals(BLOCKSIZE,fileSplit.getLength(1));
assertEquals(file3.getName(),fileSplit.getPath(2).getName());
assertEquals(2 * BLOCKSIZE,fileSplit.getOffset(2));
assertEquals(BLOCKSIZE,fileSplit.getLength(2));
assertEquals(hosts3[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(1))) {
assertEquals(2,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file2.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(file2.getName(),fileSplit.getPath(1).getName());
assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
assertEquals(BLOCKSIZE,fileSplit.getLength(1));
assertEquals(hosts2[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(2))) {
assertEquals(1,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file1.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (splits.size() == 2) {
if (split.equals(splits.get(0))) {
assertEquals(1,fileSplit.getLocations().length);
if (fileSplit.getLocations()[0].equals(hosts2[0])) {
assertEquals(2,fileSplit.getNumPaths());
if (fileSplit.getLocations()[0].equals(hosts3[0])) {
assertEquals(3,fileSplit.getNumPaths());
fail("First split should be on rack2 or rack3.");
}
}
}
if (split.equals(splits.get(1))) {
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (splits.size() == 1) {
assertEquals(1,fileSplit.getLocations().length);
assertEquals(6,fileSplit.getNumPaths());
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
fail("Split size should be 1, 2, or 3.");
}
}
}
assertEquals(6,actual.size());
assertTrue(actual.containsAll(expected));
if (splits.size() == 3) {
if (split.equals(splits.get(0))) {
assertEquals(6,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts3[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(1))) {
assertEquals(2,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file2.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(file2.getName(),fileSplit.getPath(1).getName());
assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
assertEquals(BLOCKSIZE,fileSplit.getLength(1));
assertEquals(hosts2[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(2))) {
assertEquals(1,fileSplit.getNumPaths());
assertEquals(1,fileSplit.getLocations().length);
assertEquals(file1.getName(),fileSplit.getPath(0).getName());
assertEquals(0,fileSplit.getOffset(0));
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (splits.size() == 2) {
if (split.equals(splits.get(0))) {
assertEquals(1,fileSplit.getLocations().length);
if (fileSplit.getLocations()[0].equals(hosts2[0])) {
assertEquals(5,fileSplit.getNumPaths());
if (fileSplit.getLocations()[0].equals(hosts3[0])) {
assertEquals(6,fileSplit.getNumPaths());
fail("First split should be on rack2 or rack3.");
}
}
}
if (split.equals(splits.get(1))) {
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (splits.size() == 1) {
assertEquals(1,fileSplit.getLocations().length);
assertEquals(9,fileSplit.getNumPaths());
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
fail("Split size should be 1, 2, or 3.");
}
}
}
assertEquals(9,actual.size());
assertTrue(actual.containsAll(expected));
assertEquals(5,splits.size());
assertEquals(9,actual.size());
assertTrue(actual.containsAll(expected));
assertEquals(3,splits.size());
assertEquals(9,actual.size());
assertTrue(actual.containsAll(expected));
assertEquals(3,splits.size());
assertEquals(9,actual.size());
assertTrue(actual.containsAll(expected));
assertEquals(2,splits.size());
assertEquals(9,actual.size());
assertTrue(actual.containsAll(expected));
if (splits.size() == 2) {
if (split.equals(splits.get(0))) {
assertEquals(3,fileSplit.getNumPaths());
assertTrue(actual.containsAll(expected));
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(1))) {
assertEquals(6,fileSplit.getNumPaths());
assertTrue(actual.containsAll(expected));
assertEquals(1,fileSplit.getLocations().length);
}
if (splits.size() == 3) {
if (split.equals(splits.get(0))) {
assertEquals(2,fileSplit.getNumPaths());
assertTrue(actual.containsAll(expected));
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts2[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(1))) {
assertEquals(1,fileSplit.getNumPaths());
assertEquals(file1.getName(),fileSplit.getPath(0).getName());
assertEquals(BLOCKSIZE,fileSplit.getLength(0));
assertEquals(0,fileSplit.getOffset(0));
assertEquals(1,fileSplit.getLocations().length);
assertEquals(hosts1[0],fileSplit.getLocations()[0]);
}
if (split.equals(splits.get(2))) {
assertEquals(6,fileSplit.getNumPaths());
assertTrue(actual.containsAll(expected));
assertEquals(1,fileSplit.getLocations().length);
}
fail("Split size should be 2 or 3.");
}
}
assertEquals(splits.size(),6);
if (dfs != null) {
}
}