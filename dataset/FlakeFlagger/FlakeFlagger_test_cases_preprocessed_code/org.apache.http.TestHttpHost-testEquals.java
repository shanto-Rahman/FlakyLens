@Test public void testEquals(){
Assert.assertTrue(host1.equals(host1));
Assert.assertFalse(host1.equals(host2));
Assert.assertFalse(host1.equals(host3));
Assert.assertTrue(host2.equals(host4));
Assert.assertTrue(host2.equals(host5));
Assert.assertFalse(host5.equals(host6));
Assert.assertFalse(host1.equals(null));
Assert.assertFalse(host1.equals("http://somehost"));
}