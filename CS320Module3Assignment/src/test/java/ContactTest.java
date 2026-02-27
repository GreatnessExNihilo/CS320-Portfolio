import static org.junit.jupiter.api.Assertions.*;

import org.cs320.module3.Contact;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void createContact_validFields_succeeds() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void createContact_nullId_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void createContact_idTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St")); // 11 chars
    }

    @Test
    void contactId_isNotUpdatable_byDesign() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("ID123", contact.getContactId());
    }

    @Test
    void createContact_nullFirstName_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void createContact_firstNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "JohnJacobJr", "Doe", "1234567890", "123 Main St")); // 11 chars
    }

    @Test
    void setFirstName_validUpdate_succeeds() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void setFirstName_null_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void setFirstName_tooLong_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJacobJr")); // 11 chars
    }

    @Test
    void createContact_nullLastName_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    void createContact_lastNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doecheshire", "1234567890", "123 Main St")); // 11 chars
    }

    @Test
    void setLastName_validUpdate_succeeds() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void setLastName_null_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void setLastName_tooLong_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Doecheshire")); // 11 chars
    }

    @Test
    void createContact_nullPhone_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void createContact_phoneTooShort_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "123", "123 Main St"));
    }

    @Test
    void createContact_phoneTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "12345678901", "123 Main St")); // 11 digits
    }

    @Test
    void createContact_phoneNonDigits_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "123-456-78", "123 Main St"));
    }

    @Test
    void setPhone_validUpdate_succeeds() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void setPhone_null_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void setPhone_invalidLength_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }

    @Test
    void setPhone_nonDigits_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abcdefghij"));
    }

    @Test
    void createContact_nullAddress_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "1234567890", null));
    }

    @Test
    void createContact_addressTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "1234567890",
                        "This address is definitely more than thirty characters long"));
    }

    @Test
    void setAddress_validUpdate_succeeds() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    void setAddress_null_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    void setAddress_tooLong_throws() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress("This address is definitely more than thirty characters long"));
    }
}
