public void testAssertArrayEqualsActualNull(){
TestUtil.assertEquals(expected,actual,true);
fail("Must throw AssertionFailedError");
}