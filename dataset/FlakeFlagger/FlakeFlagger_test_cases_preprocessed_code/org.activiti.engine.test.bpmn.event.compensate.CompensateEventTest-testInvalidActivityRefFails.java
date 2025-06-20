public void testInvalidActivityRefFails(){
fail("exception expected");
if (!e.getMessage().contains("Invalid attribute value for 'activityRef':")) {
fail("different exception expected");
}
}