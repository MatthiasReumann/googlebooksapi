package googlebooksapi

import googlebooksapi.exceptions.InvalidUserIdException

class BookshelfURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    private val url: String

    init {
        url = baseURL + "/users"
    }

    fun getBookshelves(userID: String): String {
        if (userID.isEmpty()) {
            throw InvalidUserIdException("UserID is empty")
        }
        return "$url/$userID/bookshelves?key=$key"
    }

    fun getSpecificBookshelf(userID: String, bookshelfID: String): String {
        return "$url/$userID/bookshelves/$bookshelfID?key=$key"
    }

    fun getVolumesInBookshelf(userID: String, bookshelfID: String) : String{
        return "$url/$userID/bookshelves/$bookshelfID/volumes?key=$key"
    }
}