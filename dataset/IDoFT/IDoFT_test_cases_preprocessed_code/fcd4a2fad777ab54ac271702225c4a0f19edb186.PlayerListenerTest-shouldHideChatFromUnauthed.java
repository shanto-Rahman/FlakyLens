@Test public void shouldHideChatFromUnauthed(){
assertThat(event.getRecipients(),contains(recipients.get(1),recipients.get(2)));
}