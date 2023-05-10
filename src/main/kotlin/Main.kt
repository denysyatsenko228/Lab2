import java.time.LocalDate

fun main() {
    // Створення об'єктів кінотеатрів та фільмів
    val cinema1 = Cinema("Cinema 1", "Address 1", LocalDate.now(), 100, 5, "Dolby Atmos", true)
    val cinema2 = Cinema("Cinema 2", "Address 2", LocalDate.now(), 200, 10, "IMAX", false)
    val film1 = Film("Film 1", "USA", "Studio 1", 120, 1000000.0, LocalDate.now(), true)
    val film2 = Film("Film 2", "UK", "Studio 2", 90, 510000.0, LocalDate.now(), false)
    val film3 = Film("Film 3", "UK", "Studio 2", 90, 500000.0, LocalDate.now(), false)
    val film4 = Film("Film 5", "UA", "Studio 1", 100, 500000.0, LocalDate.now(), true)


    // Додавання фільмів до кінотеатрів
    cinema1.films.add(film1)
    cinema2.films.add(film1)
    cinema2.films.add(film2)
    cinema2.films.add(film3)
    cinema1.films.add(film4)



    // Створення контейнера кінотеатрів та додавання до нього кінотеатрів
    val cinemaContainer = CinemaContainer(mutableListOf(cinema1, cinema2))

    // Виведення всіх кінотеатрів та їх фільмів
    for (cinema in cinemaContainer.getAll()) {
        println(cinema.name)
        for (film in cinema.films) {
            println(" - ${film.name}")
        }
    }

    // Виводимой фільм з індексом 3
    val thirdFilm = cinemaContainer.getAll()[1].films[2]
    println(thirdFilm.name)

}

