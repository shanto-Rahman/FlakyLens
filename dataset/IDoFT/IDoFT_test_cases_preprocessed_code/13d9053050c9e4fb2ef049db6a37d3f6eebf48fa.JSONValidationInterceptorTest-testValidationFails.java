public void testValidationFails() throws Exception {
assertThat(normalizedActual).contains("\"errors\":[\"Generalerror\"]").contains("\"fieldErrors\":{").contains("\"value\":[\"Minvalueis-1\"]").contains("\"text\":[\"Tooshort\",\"Thisisnoemail\"]").contains("\"password\":[\"Passwordisn'tcorrect\"]");
assertFalse(action.isExecuted());//IT
assertEquals(HttpServletResponse.SC_BAD_REQUEST,response.getStatus());
assertEquals("application/json",response.getContentType());
assertEquals("UTF-8",response.getCharacterEncoding());
}