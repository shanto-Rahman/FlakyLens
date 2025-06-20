public void testNullMetaBlocks() throws Exception {
Path mFile=new Path(ROOT_DIR,"nometa.hfile");//RW
assertNull(reader.getMetaBlock("non-existant"));
}