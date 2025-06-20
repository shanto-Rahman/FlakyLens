@Test public void testBasic() throws Exception {
assertEquals(0,OurConnectionProxy.insertCount);//RW
assertEquals(1,dao.create(foo));
assertEquals(1,OurConnectionProxy.insertCount);//RW
assertEquals(foo.val + VALUE_INCREMENT,result.val);
}