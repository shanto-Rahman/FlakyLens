@Config(sdk=21) @Test public void completableFuturePreApi24(){
service.endpoint();//IT
fail();
assertThat(e).hasMessage("Unable to create call adapter for java.util.concurrent.CompletableFuture<java.lang.String>\n" + "    for method Service.endpoint");
}