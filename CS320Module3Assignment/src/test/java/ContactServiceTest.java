import static org.junit.jupiter.api.Assertions.*;

import org.cs320.module3.Contact;
import org.cs320.module3.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void addContact_uniqueId_succeeds() {
        Contact contact = new Contact("1", "Jane", "Doe", "0123456789", "123 Elm St");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void addContact_duplicateId_throws() {
        Contact c1 = new Contact("1", "Jane", "Doe", "0123456789", "123 Elm St");
        Contact c2 = new Contact("1", "Bob", "Smith", "9876543210", "456 Oak St");
        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    void addContact_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void deleteContact_existingId_removesContact() {
        Contact contact = new Contact("2", "Bob", "Smith", "1112223333", "456 Oak St");
        service.addContact(contact);
        service.deleteContact("2");

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("2"));
    }

    @Test
    void deleteContact_missingId_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NOPE"));
    }

    @Test
    void updateFirstName_existingId_succeeds() {
        Contact contact = new Contact("3", "Amy", "Jones", "9998887777", "789 Pine St");
        service.addContact(contact);
        service.updateFirstName("3", "Ann");
        assertEquals("Ann", contact.getFirstName());
    }

    @Test
    void updateLastName_existingId_succeeds() {
        Contact contact = new Contact("3", "Amy", "Jones", "9998887777", "789 Pine St");
        service.addContact(contact);
        service.updateLastName("3", "Brown");
        assertEquals("Brown", contact.getLastName());
    }

    @Test
    void updatePhone_existingId_succeeds() {
        Contact contact = new Contact("3", "Amy", "Jones", "9998887777", "789 Pine St");
        service.addContact(contact);
        service.updatePhone("3", "1231231234");
        assertEquals("1231231234", contact.getPhone());
    }

    @Test
    void updateAddress_existingId_succeeds() {
        Contact contact = new Contact("3", "Amy", "Jones", "9998887777", "789 Pine St");
        service.addContact(contact);
        service.updateAddress("3", "New Address");
        assertEquals("New Address", contact.getAddress());
    }

    @Test
    void updateFirstName_missingId_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("NOPE", "Ann"));
    }

    @Test
    void updateLastName_missingId_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateLastName("NOPE", "Brown"));
    }

    @Test
    void updatePhone_missingId_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updatePhone("NOPE", "1231231234"));
    }

    @Test
    void updateAddress_missingId_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateAddress("NOPE", "New Address"));
    }
}
