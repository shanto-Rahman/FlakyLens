@Test(expected=RuntimeException.class) public void constructorWithExceptionTest(){
Assert.assertEquals(k,tUserInfo.getUserId());
Assert.fail("UserId " + k + " should be invalid.");
}