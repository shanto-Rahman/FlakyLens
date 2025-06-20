@Test public void testSelectColumnStatementWithTimeFilter(){
Assert.assertNotNull(actual);
Assert.assertEquals(Code.SUCCESS,actual.code());
Assert.assertEquals(gt,actual.message().get(0).getData());
}