# googlebooksapi
A Kotlin Wrapper of the [Google Books APIs](https://developers.google.com/books)

# Install

## Groovy
```
allprojects {
  repositories {
      maven { url "https://jitpack.io" }
  }
}

dependencies {
   implementation 'com.github.MatthiasReumann:googlebooksapi:master-SNAPSHOT'
}
```

## Kotlin DSL

```
allprojects {
  repositories {
    maven { url = uri("https://www.jitpack.io") }
  }
}

dependencies {
   implementation("com.github.MatthiasReumann:googlebooksapi:master-SNAPSHOT")
}
```

# Usage

## Volumes

### Get volumes

```
val volumeHelper = VolumeHelper("API_KEY")
volumeHelper.apply {
    inauthor("Michael Pollan")
    inpublisher("Penguin")
    intitle("This Is Your Mind On Plants")
    sorting(SortOption.NEWEST)
    printType(PrintTypeOption.BOOKS)
    projection(ProjectionOption.FULL)
    maxResults(3)
}
val volume = volumeHelper.get()
```

### Get specific volume

```
val volumeHelper = VolumeHelper("API_KEY")
val volume = volumeHelper.getSpecific("wVyWswEACAAJ")
```

## Bookshelves

### Get bookshelves

```
val bookshelfHelper = BookshelfHelper("API_KEY")
bookshelfHelper.userID("1164450273332089480971")

val bookshelves = bookshelfHelper.get()
```

### Get specific bookshelf

```
val bookshelfHelper = BookshelfHelper("API_KEY")
bookshelfHelper.userID("1164450273332089480971")

val bookshelf = bookshelfHelper.getSpecific(3)
```

### Get volumes in bookshelf

```
val bookshelfHelper = BookshelfHelper("API_KEY")
bookshelfHelper.userID("1164450273332089480971")

val volumes = bookshelfHelper.getVolumesInBookshelf(3)
```

