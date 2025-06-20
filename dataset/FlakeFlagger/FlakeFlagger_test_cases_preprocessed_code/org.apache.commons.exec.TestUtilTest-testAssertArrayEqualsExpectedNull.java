public void testAssertArrayEqualsExpectedNull(){
TestUtil.assertEquals(expected,actual,true);
fail("Must throw AssertionFailedError");
}