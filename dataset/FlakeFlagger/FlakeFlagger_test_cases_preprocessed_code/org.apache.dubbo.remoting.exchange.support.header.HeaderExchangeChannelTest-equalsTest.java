@Test(expected=IllegalArgumentException.class) public void equalsTest(){
Assert.assertEquals(header,new HeaderExchangeChannel(channel));
}