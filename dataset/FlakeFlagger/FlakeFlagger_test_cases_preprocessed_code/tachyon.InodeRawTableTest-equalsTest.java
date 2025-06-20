@Test public void equalsTest() throws TachyonException {
Assert.assertTrue(inode1.equals(inode2));
Assert.assertFalse(inode1.equals(inode3));
}