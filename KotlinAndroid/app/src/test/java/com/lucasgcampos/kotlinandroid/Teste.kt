package com.lucasgcampos.kotlinandroid

import junit.framework.Assert.*
import org.junit.Ignore
import org.junit.Test

class Teste {

    @Test
    @Ignore
    fun aggregationOperations() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        assertTrue(list.any {it % 2 == 0})
        assertTrue(list.all {it < 10})
        assertFalse(list.all {it % 2 == 0})
        assertEquals(3, list.count {it % 2 == 0})
        assertEquals(21, list.fold(0) { total, next -> total + next })
        assertEquals(21, list.foldRight(0) { total, next -> total + next })
        assertEquals(6, list.max())
        assertEquals(6, list.maxBy { it })
        assertEquals(1, list.min())
        assertEquals(6, list.minBy { -it })
        assertTrue(list.none { it % 7 == 0 })
        assertEquals(21, list.reduce { total, next -> total + next })
        assertEquals(21, list.reduceRight { total, next -> total + next })
        assertEquals(21, list.sum())
        assertEquals(3, list.sumBy { it % 2 })
        list.forEach(::println)
        list.forEachIndexed { index, value -> println("position $index contains a $value") }
    }

    @Test
    @Ignore
    fun filteringOperations() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        assertEquals(listOf(5, 6), list.drop(4))
        assertEquals(listOf(3, 4, 5, 6), list.dropWhile { it < 3 })
        assertEquals(listOf(1, 2, 3, 4), list.dropLastWhile { it > 4 })

        assertEquals(listOf(2, 4, 6), list.filter { it % 2 == 0 })
        assertEquals(listOf(1, 3, 5), list.filterNot { it % 2 == 0 })
        assertEquals(listOf(1, 2, 3, 4, 5, 6), list.filterNotNull())

        assertEquals(listOf(2, 4, 5), list.slice(listOf(1, 3, 4)))

        assertEquals(listOf(1, 2), list.take(2))
        assertEquals(listOf(5, 6), list.takeLast(2))
        assertEquals(listOf(1, 2), list.takeWhile { it < 3 })
    }

    @Test
    @Ignore
    fun mappingOperations() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        assertEquals(listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7), list.flatMap { listOf(it, it + 1) })
        assertEquals(mapOf("odd" to listOf(1, 3, 5), "even" to listOf(2, 4, 6)), list.groupBy { if (it % 2 == 0) "even" else "odd" })
        assertEquals(listOf(2, 4, 6, 8, 10, 12), list.map { it * 2 })
        assertEquals(listOf (0, 2, 6, 12, 20, 30), list.mapIndexed { index, it -> index * it })
        assertEquals(listOf(2, 4, 6, 8, 10, 12), list.mapNotNull { it * 2 })
    }

    @Test
    @Ignore
    fun elementsOperations() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        assertTrue(list.contains(2))

        assertEquals(3, list.elementAt(2))
        assertEquals(10, list.elementAtOrElse(10, { it }))
        assertNull(list.elementAtOrNull(10))

        assertEquals(1, list.first())
        assertEquals(2, list.first({it % 2 == 0}))
        assertNull(list.firstOrNull({it % 2 == 21}))

        assertEquals(6, list.last())
        assertEquals(5, list.last { it % 2 == 1 })
        assertNull(list.lastOrNull { it % 2 == 21 })

        assertEquals(3, list.indexOf(4))
        assertEquals(-1, list.indexOf(10))
        assertEquals(1, list.indexOfFirst { it % 2 == 0 })
        assertEquals(5, list.indexOfLast { it % 2 == 0 })
        assertEquals(4, list.lastIndexOf(5))

        assertEquals(5, list.single({it % 5 == 0}))
        assertNull(list.singleOrNull({it % 7 == 0}))
    }

    @Test
    @Ignore
    fun generationOperations() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        assertEquals(Pair(listOf(2, 4, 6), listOf(1, 3, 5)), list.partition { it % 2 == 0 })

        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), list.plus(listOf(7, 8)))

        assertEquals(listOf(Pair(1, 7), Pair(2, 8)), list.zip(listOf(7, 8)))
        assertEquals(Pair(listOf(5, 6), listOf(7, 8)), listOf(Pair(5, 7), Pair(6, 8)).unzip())
    }

    @Test
    fun orderingOperations() {
        val unsortedList = arrayOf(3, 2, 7, 5)

        unsortedList.reverse()
        assertEquals(5, unsortedList[0])

        unsortedList.sort()
        assertEquals(2, unsortedList[0])

        unsortedList.sortBy { it % 3 }
        assertEquals(3, unsortedList[0])

        unsortedList.sortDescending()
        assertEquals(7, unsortedList[0])

        unsortedList.sortByDescending { it % 3 }
        assertEquals(5, unsortedList[0])
    }












}