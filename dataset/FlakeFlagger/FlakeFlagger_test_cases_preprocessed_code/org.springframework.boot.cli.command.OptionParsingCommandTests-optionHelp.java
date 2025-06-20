@Test public void optionHelp(){
assertThat(command.getHelp(),containsString("--bar"));
}