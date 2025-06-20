@Test void extensionSerialize() throws IOException {
  AccountProblemDetails details=AccountProblemDetails.empty().withBalance(30).withAccounts("/account/12345","/account/67890");
  ExtendedProblem<AccountProblemDetails> problem=Problem.create(details).withType(URI.create("https://example.com/probs/out-of-credit")).withTitle("You do not have enough credit.").withStatus(HttpStatus.BAD_REQUEST).withDetail("Your current balance is 30, but that costs 50.").withInstance(URI.create("/account/12345/msgs/abc"));
  String actual=this.mapper.writeValueAsString(problem);
  assertThat(actual).isEqualTo(MappingUtils.read(new ClassPathResource("extension.json",getClass())));
}
