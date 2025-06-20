@Test public void testShowStorageGroup(){
Assert.assertNotNull(actual);
Assert.assertEquals(Code.SUCCESS,actual.code());
Assert.assertTrue(gt == actual.message().get(0).getData() || gt_alternative == actual.message().get(0).getData());
}