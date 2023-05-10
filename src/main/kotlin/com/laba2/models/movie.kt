import java.time.LocalDate

// Клас сутності Кінотеатр
data class Cinema(
    val name: String,
    val address: String,
    val openingDate: LocalDate,
    val seats: Int,
    val screens: Int,
    val soundTechnology: String,
    val is3D: Boolean,
    val films: MutableList<Film> = mutableListOf()
) : Comparable<Cinema> {
    /**
     * Реалізація інтерфейсу Comparable для порівняння кінотеатрів за кількістю екранів і назвою.
     * @param other Кінотеатр для порівняння.
     * @return Результат порівняння кінотеатрів за кількістю екранів і назвою.
     */
    override fun compareTo(other: Cinema): Int {
        return if (screens != other.screens) {
            screens - other.screens
        } else {
            name.compareTo(other.name)
        }
    }
}

// Клас сутності Фільм
data class Film(
    val name: String,
    val country: String,
    val studio: String,
    val duration: Int,
    val budget: Double,
    val releaseDate: LocalDate,
    val isRated: Boolean
) : Comparable<Film> {
    /**
     * Реалізація інтерфейсу Comparable для порівняння фільмів за тривалістю і назвою.
     * @param other Фільм для порівняння.
     * @return Результат порівняння фільмів за тривалістю і назвою.
     */
    override fun compareTo(other: Film): Int {
        return if (duration != other.duration) {
            duration - other.duration
        } else {
            name.compareTo(other.name)
        }
    }
}


/**
 * Клас-контейнер, що містить колекцію кінотеатрів.
 *
 * @param T тип кінотеатру.
 * @property cinemas колекція кінотеатрів.
 */
class CinemaContainer<T : Cinema>(private val cinemas: MutableList<T>) : Container<T> {

    /**
     * Додає кінотеатр до колекції.
     *
     * @param item кінотеатр для додавання.
     */
    override fun add(item: T) {
        cinemas.add(item)
    }

    /**
     * Видаляє кінотеатр з колекції за індексом.
     *
     * @param index індекс кінотеатру, який треба видалити.
     */
    override fun remove(index: Int) {
        cinemas.removeAt(index)
    }

    /**
     * Оновлює кінотеатр у колекції за індексом.
     *
     * @param index індекс кінотеатру, який треба оновити.
     * @param item новий об'єкт кінотеатру.
     */
    override fun update(index: Int, item: T) {
        cinemas[index] = item
    }

    /**
     * Повертає кінотеатр з колекції за індексом.
     *
     * @param index індекс кінотеатру, який потрібно повернути.
     * @return кінотеатр з колекції за індексом.
     */
    override fun get(index: Int): T {
        return cinemas[index]
    }

    /**
     * Повертає всі кінотеатри з колекції.
     *
     * @return список всіх кінотеатрів з колекції.
     */
    override fun getAll(): List<T> {
        return cinemas
    }
}

/**
 * Інтерфейс контейнера для зберігання об'єктів.
 *
 * @param T тип об'єкта.
 */
interface Container<T> {

    /**
     * Додає об'єкт до контейнера.
     *
     * @param item об'єкт, який треба додати.
     */
    fun add(item: T)

    /**
     * Видаляє елемент з контейнера за індексом
     * @param index індекс елемента, що видаляється
     */
    fun remove(index: Int)

    /**
     * Оновлює елемент в контейнері за індексом
     * @param index індекс елемента, що оновлюється
     * @param item новий елемент
     */
    fun update(index: Int, item: T)

    /**
     * Повертає елемент з контейнера за індексом
     * @param index індекс елемента
     * @return елемент з контейнера за індексом
     */
    fun get(index: Int): T

    /**
     * Повертає всі елементи з контейнера
     * @return всі елементи з контейнера
     */
    fun getAll(): List<T>

}

