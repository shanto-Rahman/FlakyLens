@Test public void testHashCode(){
Assert.assertTrue(host1.hashCode() == host1.hashCode());
Assert.assertTrue(host1.hashCode() != host2.hashCode());
Assert.assertTrue(host1.hashCode() != host3.hashCode());
Assert.assertTrue(host2.hashCode() == host4.hashCode());
Assert.assertTrue(host2.hashCode() == host5.hashCode());
Assert.assertTrue(host5.hashCode() != host6.hashCode());
}