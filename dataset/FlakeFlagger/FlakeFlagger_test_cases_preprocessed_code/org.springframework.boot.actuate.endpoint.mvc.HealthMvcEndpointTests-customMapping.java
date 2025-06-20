@SuppressWarnings("unchecked") @Test public void customMapping(){
assertTrue(result instanceof ResponseEntity);
assertTrue(response.getBody().getStatus().equals(new Status("OK")));
assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
}