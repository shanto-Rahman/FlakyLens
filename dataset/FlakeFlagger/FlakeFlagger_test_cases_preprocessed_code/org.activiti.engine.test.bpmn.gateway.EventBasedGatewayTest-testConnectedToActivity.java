public void testConnectedToActivity(){
fail("exception expected");
if (!e.getMessage().contains("Event based gateway can only be connected to elements of type intermediateCatchEvent")) {
fail("different exception expected");
}
}