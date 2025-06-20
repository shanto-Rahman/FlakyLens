@Test public void testRecursiveGroupDirToAttributes() throws Exception {
if (mff.getAttribute("hdfs.objectName").equals("mydir")) {
if (mff.getAttribute("hdfs.objectName").equals("dir1")) {
if (mff.getAttribute("hdfs.objectName").equals("dir2")) {
if (mff.getAttribute("hdfs.objectName").equals("regDir")) {
if (mff.getAttribute("hdfs.objectName").equals("regDir2")) {
}
}
}
}
}
Assert.assertEquals(matchCount,5);
}