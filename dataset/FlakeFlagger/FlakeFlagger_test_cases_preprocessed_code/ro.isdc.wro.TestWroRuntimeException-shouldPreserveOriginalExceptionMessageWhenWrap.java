@Test public void shouldPreserveOriginalExceptionMessageWhenWrap(){
Assert.assertEquals(e.getMessage(),result.getMessage());
}