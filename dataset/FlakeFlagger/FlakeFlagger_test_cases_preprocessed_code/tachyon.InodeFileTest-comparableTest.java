@Test public void comparableTest(){
Assert.assertEquals(-1,inode1.compareTo(inode2));
Assert.assertEquals(0,inode1.compareTo(inode1));
Assert.assertEquals(0,inode2.compareTo(inode2));
Assert.assertEquals(1,inode2.compareTo(inode1));
}