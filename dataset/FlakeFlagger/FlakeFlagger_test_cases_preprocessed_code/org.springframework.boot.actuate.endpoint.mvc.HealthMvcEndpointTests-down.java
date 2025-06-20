@SuppressWarnings("unchecked") @Test public void down(){
assertTrue(result instanceof ResponseEntity);
assertTrue(response.getBody().getStatus() == Status.DOWN);
assertEquals(HttpStatus.SERVICE_UNAVAILABLE,response.getStatusCode());
}