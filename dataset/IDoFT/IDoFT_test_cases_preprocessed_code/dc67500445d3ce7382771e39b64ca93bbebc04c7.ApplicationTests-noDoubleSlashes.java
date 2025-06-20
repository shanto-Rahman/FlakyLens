@Test void noDoubleSlashes(){
assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(body).isNotNull();
assertThat(body.contains(basePath + "/")).as("basePath contains double slashes").isFalse();
}