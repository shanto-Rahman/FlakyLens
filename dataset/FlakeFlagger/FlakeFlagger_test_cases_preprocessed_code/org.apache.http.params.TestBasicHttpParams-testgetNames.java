@Test public void testgetNames(){
Assert.assertTrue(nameSet.isEmpty());
Assert.assertTrue(nameSet.isEmpty());
Assert.assertFalse(nameSet.isEmpty());
Assert.assertEquals(1,nameSet.size());
Assert.assertTrue("Iterator has an entry",iterator.hasNext());
Assert.assertTrue(((Boolean)params.getParameter(entry)).booleanValue());
}