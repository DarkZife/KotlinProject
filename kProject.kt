//This is our set attributes and their value
data class Contact(val name: String, val phone: String, val email: String)

class ContactManager {
    private val contacts = mutableListOf<Contact>()

    //right here we are just adding our contact to the contact list
    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    //This is our function for searching for the contact by the name
    fun searchContact(query: String): List<Contact> {
        return contacts.filter { it.name.contains(query, ignoreCase = true) }
    }

    //This is our function for showing all contacts, or saying there are none if we haven't put any in contacts list
    fun listContacts() {
        if (contacts.isEmpty()) {
            println("No contacts found.")
        } else {
            contacts.forEachIndexed { index, contact ->
                println("Contact ${index + 1}:")
                println("Name: ${contact.name}")
                println("Phone: ${contact.phone}")
                println("Email: ${contact.email}")
                println()
            }
        }
    }
}

fun main() {
    val contactManager = ContactManager()
//This will display our menu and keep running until we exit on option 4
    while (true) {
        println("Contact Manager Menu:")
        println("1. Add Contact")
        println("2. Search Contacts")
        println("3. List Contacts")
        println("4. Exit")
        print("Enter your choice: ")
//We are going to ask for the choice ^ but below this is where its going to grab whatever input the user puts in
        when (readLine()?.toIntOrNull()) {
            //This first option as you can see from the Menu is our add contact
            1 -> {
                print("Enter contact name: ")
                val name = readLine() ?: ""
                print("Enter contact phone number: ")
                val phone = readLine() ?: ""
                print("Enter contact email: ")
                val email = readLine() ?: ""
                val contact = Contact(name, phone, email)
                contactManager.addContact(contact)
            }
            //This option we can search through our list of contacts by the name we put in
            2 -> {
                print("Enter search query: ")
                val query = readLine() ?: ""
                val searchResults = contactManager.searchContact(query)
                if (searchResults.isNotEmpty()) {
                    searchResults.forEach { println("${it.name}, ${it.phone}, ${it.email}") }
                } else {
                    println("No matching contacts found.")
                }
            }
            3 -> contactManager.listContacts()//This will show all of our contacts
            4 -> return//here will stop the process and below is and invalid option we put in. so like any number not 1-4
            else -> println("Invalid choice. Please enter a valid option.")
        }
    }
}
