@Test public void enabled(){
assertThat(AnsiOutput.getEnabled(),equalTo(Enabled.ALWAYS));
}