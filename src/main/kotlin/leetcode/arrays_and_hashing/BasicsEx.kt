package leetcode.arrays_and_hashing

// The actual code for creating an Array to hold DVD's.
var dvdCollection = arrayOfNulls<DVD>(15)

// A simple definition for a DVD.
class DVD(var name: String, var releaseYear: Int, var director: String) {
    override fun toString(): String {
        return "$name, directed by $director, released in $releaseYear"
    }
}