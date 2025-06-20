@Test public void inputSteamReadOffsetBytes() throws Exception {
assertThat(b,equalTo(new byte[]{0,0,1,2,3,0,0}));
assertThat(amountRead,equalTo(3));
}