@Test public void shouldUseCredentialsDirectory() throws NoSuchFieldException, IllegalAccessException {
assertThat(client.getId(),is("id"));
assertThat(client.getSecret(),is("secret"));
assertThat(user.getUsername(),is("username"));
assertThat(user.getPassword(),is("password"));
}