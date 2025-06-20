@Test public void testInvalidRange(){
Assert.assertFalse("Range value accepted an invalid value: " + invalidRange,accepts);
Assert.fail("Range value did *not* throw IllegalArgumentException for an invalid range: " + invalidRange);
}