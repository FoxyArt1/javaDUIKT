@Test
void testId() {
    User user = new User(1, "Mikhail");
    assertEquals(1, user.getId());
}

@Test
void testUsername() {
    User user = new User(1, "Mikhail");
    assertEquals("Mikhail", user.getUsername());
}

@Test
void testCart() {
    User user = new User(1, "Mikhail");
    assertEquals(new HashMap<>(), user.getCart());
}

@Test
void testNegativeId() {
    assertThrows(IllegalArgumentException.class, () -> new User(-1, "Mikhail"));
}

@Test
void testEmptyUsername() {
    assertThrows(IllegalArgumentException.class, () -> new User(1, ""));
}