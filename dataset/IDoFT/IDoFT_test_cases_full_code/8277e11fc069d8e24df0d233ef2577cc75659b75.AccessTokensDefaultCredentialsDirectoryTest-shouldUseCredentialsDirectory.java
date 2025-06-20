@Test public void shouldUseCredentialsDirectory() throws NoSuchFieldException, IllegalAccessException {
  final TokenRefresherConfiguration configuration=getConfiguration();
  final ClientCredentialsProvider clientCredentialsProvider=configuration.getClientCredentialsProvider();
  final UserCredentialsProvider userCredentialsProvider=configuration.getUserCredentialsProvider();
  final ClientCredentials client=clientCredentialsProvider.get();
  assertThat(client.getId(),is("id"));
  assertThat(client.getSecret(),is("secret"));
  final UserCredentials user=userCredentialsProvider.get();
  assertThat(user.getUsername(),is("username"));
  assertThat(user.getPassword(),is("password"));
}
